package com.myGroup.springBootDemo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myGroup.springBootDemo.entity.Product;
import com.myGroup.springBootDemo.form.ProductForm;
import com.myGroup.springBootDemo.mapper.ProductMapper;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	public List<Product> searchAll() {
		return productMapper.searchAll();
	}
	
	public void regist(ProductForm form) {
		
		Product product = new Product();

		product.setName(form.getName());
		product.setPrice(Integer.parseInt(form.getPrice()));
		product.setAddress(form.getAddress());
		product.setCreateTime(LocalDateTime.now());
		product.setUpdateTime(LocalDateTime.now());
		product.setCreateUser("WEB");
		product.setUpdateUser("WEB");

		productMapper.regist(product);
	}
	
	public void delete(Integer productId) {
		
		Product product = new Product();
		product.setId(productId);
		productMapper.delete(product);
	}
	
}