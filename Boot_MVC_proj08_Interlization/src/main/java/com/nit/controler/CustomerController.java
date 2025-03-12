package com.nit.controler;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nit.model.Customer;

@Controller
public class CustomerController 
{
	@GetMapping("/")
	public String showHome()
	{
		return "homme";
	}
	@GetMapping("/resistor")
	public String showCustomerFormPage(@ModelAttribute("cust") Customer cust,Map<String, Object> map)
	{
		return "cust_Res";
	}
	

}
