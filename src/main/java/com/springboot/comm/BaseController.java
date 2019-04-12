package com.springboot.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
	
	@GetMapping("/ping")
	String getPing(HttpServletRequest request, HttpServletResponse response) {
		return "application is ok!";
	}

	@GetMapping("/test")
	public String hello(HttpServletRequest request, HttpServletResponse response) {
		return "test ok";
	}
}
