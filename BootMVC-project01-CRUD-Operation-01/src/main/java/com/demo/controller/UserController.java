package com.demo.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entity.User;
import com.demo.service.IUserManagementService;

@Controller
public class UserController {
	private IUserManagementService service;

	public UserController(IUserManagementService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}

	@GetMapping("/register")
	public String userRegister() {
		return "register_form";
	}

	@PostMapping("/register")
	public String userRegister(@ModelAttribute("user") User user, RedirectAttributes attribute) {
		String registerUser = service.registerUser(user);

		attribute.addFlashAttribute("status", registerUser);

		return "redirect:show";
	}

	@GetMapping("/show")
	public String paginationOfUser(
			@PageableDefault(page = 0, size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
			Map<String, Object> map) {
		// Add result in model attribute object
		map.put("userDatalist", service.paginationOfUser(pageable));
		return "show_pagination";
	}

	@GetMapping("/edit")
	public String editUser(@RequestParam("id") Integer id, @ModelAttribute("userData") User user) {
		// get existing data
		User userData = service.findUserById(id);

		// copy user object data in userData
		BeanUtils.copyProperties(userData, user);

		return "edit_user";
	}

	@PostMapping("/edit")
	public String updateUser(@ModelAttribute("userData") User user, RedirectAttributes attribute) {
		attribute.addFlashAttribute("message", service.updateUserData(user));

		return "redirect:show";
	}
	
	@GetMapping("/delete")
	public String deleteUserById(@RequestParam("id")Integer id, RedirectAttributes attrebutes )
	{
		attrebutes.addFlashAttribute("deleteMsg",service.deleteUserById(id));
		return"redirect:show";
	}
}
