package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Product;
import com.example.model.ProductRowMapper;

@Repository
public class ProductRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int addProduct(Product product) {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("insert into products values ('");
		sqlBuilder.append(product.getId());
		sqlBuilder.append("','");
		sqlBuilder.append(product.getName());
		sqlBuilder.append("','");
		sqlBuilder.append(product.getCompany());
		sqlBuilder.append("');");
		
		return jdbcTemplate.update(sqlBuilder.toString());
	}
	
	public List<Product> showProductById(String id) {
		String sql = "SELECT id, name, company FROM products WHERE id = '"+id+"'";
		return jdbcTemplate.query(sql, new ProductRowMapper());
	}
	
	public List<Product> showProductByCompany(String name) {
		System.out.println("Name: "+name);
		List<Product> products = null;
		if (name.equalsIgnoreCase("HP")) {
			products = new ArrayList<Product>();
			Product product = new Product();
			product.setId("H-PR1");
			product.setName("DESKJET - PRINTER");
			product.setCompany(name);
			products.add(product);
		}
		return products;
	}
	
	public List<Product> showAllProducts() {
		String sql = "SELECT id, name, company FROM products";
		return jdbcTemplate.query(sql, new ProductRowMapper());		
	}
}
