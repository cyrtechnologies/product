package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.example.model.Product;
import com.example.model.ProductResponse;
import com.example.service.AnotherProductService;

@RunWith(JUnit4.class)
public class AnotherProductServiceTest {
	
	AnotherProductService service;
	
	@Before
	public void setUp() {
		service = new AnotherProductService();
	}
	
	@Test
	public void testAddProduct() {
		Product product = null;
		ProductResponse response = service.addProduct(product);
		assertEquals("Success", response.getStatus());
		assertEquals("Product is added successfully", response.getMessage());
	}
	
	
}
