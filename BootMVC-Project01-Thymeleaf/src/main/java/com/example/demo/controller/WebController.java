package com.example.demo.controller;

import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Employee;
import com.example.demo.service.IEmployeeManagementService;

@Controller
@RequestMapping("/home")
public class WebController {

	private IEmployeeManagementService  empService;
	
	
    public WebController(IEmployeeManagementService empService)
    {
		this.empService = empService;
	}

	// GET request to display the home page
    @GetMapping
    public String showLoginPage() {
        return "index"; 
    }

    // POST request to handle login form submission
    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, 
                              @RequestParam String password, 
                              Map<String, Object> map) {
        
        if ("admin".equals(username) && "123".equals(password)) { 
            // Redirect to a success page or home page if login is successful
            return "redirect:/home/show_employees"; // Change to your desired redirect URL
        } else {
           
            map.put("resultMsg", "Invalid Credentials");
            return "index"; 
        }
    }

    // GET request to show employees
    @GetMapping("/show_employees")
    public String showEmployees(@PageableDefault(page=0,size=4)Pageable pageable,Map<String,Object>map)
    {
        map.put("employeeList",empService.showEmployeesByPagination(pageable));
        return "show_employees"; 
    }
    
    
 // Get request for add employee form page
    @GetMapping("/add_emp")
    public String showAddForm(Map<String,Object>map) {
        map.put("emp", new Employee());
        return "add_employee";
    }

    // Post request to add employee
    @PostMapping("/add_emp")
    public String addEmployee(@ModelAttribute("emp") Employee employee, RedirectAttributes redirectAttr) {
        // Add employee data
        String resultMsg = empService.registerEmployee(employee);
        
        redirectAttr.addFlashAttribute("resultMsg", resultMsg);
        return "redirect:/home/show_employees";
    }

}
