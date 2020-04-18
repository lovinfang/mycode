package com.lovin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lovin.framework.service.FrameworkTestService;

@Controller
@RequestMapping("/framework")
public class FrameworkTestController {
	
	@Autowired
	FrameworkTestService service;

	@RequestMapping("/index")
	public @ResponseBody String index(){
		String result = service.sleep("My Name is lovin!!!");
		System.out.println(result);
		return result;
	}
}
