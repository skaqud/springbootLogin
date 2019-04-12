package com.springboot.comm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "Jason");
		return "hello";
	}
}
