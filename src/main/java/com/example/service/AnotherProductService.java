package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.model.ProductResponse;

@Service
public class AnotherProductService {
	
	List<Product> list = new ArrayList<>();
	
	public ProductResponse addProduct(Product product) {
		ProductResponse productResponse = new ProductResponse();
		if (product == null) {
			productResponse.setStatus("Failure");
			productResponse.setMessage("Product is null");
			return productResponse;
		}
		productResponse.setStatus("Success");
		productResponse.setMessage("Product is added successfully");
        list.add(product);
        productResponse.setProducts(list);
        return productResponse;
    }
	
	public ProductResponse showAllProducts() {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setStatus("Success");
		productResponse.setProducts(list);
		return productResponse;
    }
	
	public ProductResponse showProductByCompany(String name) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setStatus("Success");
		
		List<Product> products = null;
		for (Product product : list) {
			if (product.getCompany().equalsIgnoreCase(name)) {
				products = new ArrayList<Product>();
				products.add(product);
			}
		}
		productResponse.setProducts(products);
		return productResponse;
	}
}
