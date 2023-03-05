package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getString("ID"));
		product.setName(rs.getString("NAME"));
		product.setCompany(rs.getString("COMPANY"));
		
		return product;
	}

}
