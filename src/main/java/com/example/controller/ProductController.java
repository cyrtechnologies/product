package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.model.ProductResponse;
import com.example.service.AnotherProductService;
import com.example.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	@Autowired
	AnotherProductService anotherProductService;
	
	@ApiOperation(value = "Add Product", response = ProductResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ProductResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
	@PostMapping(value = "/addProduct")
	public ProductResponse addProduct(@RequestBody Product product) 
	{
		return productService.addProduct(product);
	}
	
	@ApiOperation(value = "Return product for given ID", response = ProductResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ProductResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
	@GetMapping(value = "/showProductById")
	public ProductResponse showProductById(@RequestParam String id) 
	{
		return productService.showProductById(id);
	}
	
	@ApiOperation(value = "Return product for given ID", response = ProductResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ProductResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
	@GetMapping(value = "/showProductByManufacturer")
	public ProductResponse showProductByManufacturer(@RequestParam String name) 
	{
		return productService.showProductByManufacturer(name);
	}
	
	@ApiOperation(value = "Return product for given ID", response = ProductResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ProductResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
	@GetMapping(value = "/showProductByCompany")
	public ProductResponse showProductByCompany(@RequestParam String name) 
	{
		return productService.showProductByCompany(name);
	}
	
	@ApiOperation(value = "Returns all Products", response = ProductResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ProductResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
	@GetMapping(value = "/showAllProducts")
	public ProductResponse showAllProducts() 
	{
		return productService.showAllProducts();
	}
	
	@ApiOperation(value = "Add Product", response = ProductResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ProductResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
	@PostMapping(value = "/addProductToAnotherService")
	public ProductResponse addProductToAnotherService() 
	{
		Product product = new Product();
		product.setId("H-PR1");
		product.setName("DESKJET - PRINTER");
		product.setCompany("HP");
		return anotherProductService.addProduct(product);
	}
	
	@ApiOperation(value = "Returns all Products", response = ProductResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ProductResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
	@GetMapping(value = "/showAllProductsFromAnotherService")
	public ProductResponse showAllProductsFromAnotherService() 
	{
		return anotherProductService.showAllProducts();
	}
}
