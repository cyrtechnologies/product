package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import com.example.model.Product;
import com.example.model.ProductResponse;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	
	@InjectMocks
	ProductService service;
	
	@Mock
	ProductRepository productRepository;

	@Test
	public void showProductByManufacturerWithEmptyValue() {
		ProductService service = new ProductService();
		ProductResponse response = service.showProductByManufacturer("");
		assertEquals("Company cannot be empty", response.getMessage());
	}
	
	@Test
	public void showProductByManufacturerWithValidInput() {
		ProductService service = new ProductService();
		ProductResponse response = service.showProductByManufacturer("HP");
		assertNotNull(response.getProducts());
	}
	
	@Test
	public void showProductByManufacturerWithInValidInput() {
		ProductService service = new ProductService();
		ProductResponse response = service.showProductByManufacturer("CANON");
		assertNull(response.getProducts());
	}
	
	@Test
	public void showProductByCompanyWithValidInput() {
		ProductResponse response = service.showProductByCompany("CANON");
		assertNotNull(response.getProducts());
	}
	
	@Test
	public void showAllProductsTest() {
		List<Product> products = new ArrayList<Product>();
		Product product = new Product();
		product.setId("H-PR1");
		product.setName("DESKJET - PRINTER");
		product.setCompany("HP");
		products.add(product);
	
		ProductResponse response = new ProductResponse();
		response.setProducts(products);
		response.setMessage("");
		response.setStatus("Success");
		
		when(productRepository.showAllProducts()).thenReturn(products);
		
		ProductResponse prodRsp = service.showAllProducts();
		assertNotNull(prodRsp.getProducts());
		assertEquals("", prodRsp.getMessage());
		assertEquals("Success", prodRsp.getStatus());
	}
	
	@Test
	public void showProductByIdTest() {
		
		Product product = new Product();
		product.setId("C-PR1");
		product.setName("INKJET - PRINTER");
		product.setCompany("CANON");
		
		List<Product> products = new ArrayList<Product>();
		products.add(product);
		
		when(productRepository.showProductById("C-PR1")).thenReturn(products);
		
		ProductResponse response = service.showProductById("C-PR1");
		assertNotNull(response.getProducts());
		assertEquals("INKJET - PRINTER", response.getProducts().get(0).getName());
		
	}

}
