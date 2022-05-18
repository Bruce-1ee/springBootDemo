package com.myGroup.springBootDemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myGroup.springBootDemo.entity.Product;
import com.myGroup.springBootDemo.form.ProductForm;
import com.myGroup.springBootDemo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping("/searchAll")
	public String searchAll(Map<String,Object> map) {

		List<Product> productList = productService.searchAll();
		map.put("productList", productList);
		map.put("title", "搜索结果");

		return "/product/productDetail";
	}

	@RequestMapping("/registPage")
	public String registInit() {

		return "/product/registpage";
	}
	
	@RequestMapping("/regist")
	public String regist(ProductForm form) {

		productService.regist(form);
//		return "redirect:searchAll";
		return "/product/registcomplete";
		
	}
	
	@RequestMapping("/delete/{productId}")
	public String delete(@PathVariable("productId") Integer productId ,Model model) {
		
		productService.delete(productId);
		
		List<Product> productList = productService.searchAll();
		model.addAttribute("productList", productList);
		model.addAttribute("title", "搜索结果");
		return "/product/productDetail";
		//return "redirect:searchAll";
	}
}
