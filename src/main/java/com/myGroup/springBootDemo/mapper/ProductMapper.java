package com.myGroup.springBootDemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myGroup.springBootDemo.entity.Product;

@Mapper
public interface ProductMapper {
	
	List<Product> searchAll();
	
	void regist(Product product);
	
	void delete(Product product);

}
