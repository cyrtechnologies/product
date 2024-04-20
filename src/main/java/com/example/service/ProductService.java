package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.model.ProductResponse;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	ProductResponse productResponse = null;
	
	public ProductResponse addProduct(Product product) {
		productResponse = new ProductResponse();
		int count;
		if (product == null) {
			productResponse.setStatus("Failure");
			productResponse.setMessage("Product is null");
			return productResponse;
		}
		try {
			count = productRepository.addProduct(product);
			productResponse.setStatus("Success");
			productResponse.setMessage("Product is added successfully");
		} catch (Exception ex) {
			count = 0;
			System.out.println("Error connecting to DB");
			productResponse.setStatus("Failure");
			productResponse.setMessage("Product is not added successfully");
		}
		System.out.println(count + " row(s) updated.");		
		return productResponse;
	}

	public ProductResponse showProductById(String id) {
		productResponse = new ProductResponse();
		List<Product> products = null;
		if ("0".equalsIgnoreCase(id) || "".equalsIgnoreCase(id)) {
			productResponse.setStatus("Success");
			productResponse.setMessage("Product id cannot be 0 or empty");
			return productResponse;
		}
		try {
			products = productRepository.showProductById(id);
			productResponse.setStatus("Success");
			if (products.size() == 0) {
				productResponse.setMessage("Product is not found");
			}
			productResponse.setProducts(products);
		} catch (Exception ex) {
			products = null;
			productResponse.setStatus("Failure");
			productResponse.setMessage(ex.getMessage());
		}
		return productResponse;
	}
	
	public ProductResponse showAllProducts() {
		productResponse = new ProductResponse();
		List<Product> products = null;
		try {
			products = productRepository.showAllProducts();
			productResponse.setStatus("Success");
			if (products.isEmpty()) {
				productResponse.setMessage("No Product(s) found");
			}
			productResponse.setProducts(products);
		} catch (Exception ex) {
			productResponse.setStatus("Failure");
			productResponse.setMessage(ex.getMessage());
		}
		return productResponse;
	}
	
	public ProductResponse showProductByCompany(String name) {
		productResponse = new ProductResponse();
		List<Product> products = null;
		if (name == "") {
			productResponse.setStatus("Success");
			productResponse.setMessage("Company cannot BE empty");
			return productResponse;
		}
		try {
			products = productRepository.showProductByCompany(name);
			productResponse.setStatus("Success");
			if (products.size() == 0) {
				productResponse.setMessage("No Product(s) found for given company");
			}
			productResponse.setProducts(products);
		} catch (Exception ex) {
			products = null;
			productResponse.setStatus("Failure");
			productResponse.setMessage(ex.getMessage());
		}
		return productResponse;
	}
	
	
	public ProductResponse showProductByManufacturer(String name) {
		productResponse = new ProductResponse();
		List<Product> products = null;
		if (name == "" || name == null) {
			productResponse.setStatus("Success");
			productResponse.setMessage("Company cannot be empty");
			return productResponse;
		}
		try {
			if ("HP".equals(name)) {
				products = new ArrayList<Product>();
				Product product = new Product();
				product.setId("H-PR1");
				product.setName("DESKJET - PRINTER");
				product.setCompany(name);
				products.add(product);
			}
			productResponse.setStatus("Success");
			productResponse.setProducts(products);
		} catch (Exception ex) {
			products = null;
			productResponse.setStatus("Failure");
			productResponse.setMessage(ex.getMessage());
		}
		return productResponse;
	}
	
}
