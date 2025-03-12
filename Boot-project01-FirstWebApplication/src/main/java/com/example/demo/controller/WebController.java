package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping("/home")
	public String showHomePage()
	{
		//return logical view name
		return "welcome";
	}
}
