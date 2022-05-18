package com.myGroup.springBootDemo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {
	
	@RequestMapping("/")
	public String homepage(Map<String,Object> map) {
		map.put("title", "homepage");
		map.put("content", "welcome to my demo website!");
		return "homepage";
	}
}
