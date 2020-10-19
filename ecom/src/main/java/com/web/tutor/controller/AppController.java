package com.web.tutor.controller;


import java.util.Date;

import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.tutor.model.PaymentMethod;
import com.web.tutor.model.Users;

@Controller
public class AppController {
	
	


	@GetMapping({"home","/"})
	public String home(Model model) {
		model.addAttribute("msg", "Welcome from controller");
		return "home";
	}
	
	@GetMapping("about")
	public String about(Model model) {
		model.addAttribute("msg", "About us");
		return "about";
	}
	
	@GetMapping("contact")
	public String contactus(Model model) {
		model.addAttribute("msg", "Contact");
		return "contact";
	}
	
	@GetMapping("login")
	public String login(Model model) {
		model.addAttribute("msg", "Login");
		return "login";
	}
	
	@PostMapping("sign-in")
	public String signin(Model model, @RequestParam String email, @RequestParam String password) {
		model.addAttribute("msg", email + " " + password);
		return "login";
	}
	
	@GetMapping("signup")
	public String signup(Model model) {
		model.addAttribute("msg", "Sign Up");
		model.addAttribute("users", new Users());
		return "signup";
	}
	
	@GetMapping("myName")
	public String time(Model model, @RequestParam String name, @RequestParam String address) {
		model.addAttribute("msg", "Hi " + name + " from " + address + " time now is " + new Date());
		return "home";
	}
	
	@GetMapping("name-{name}-{address}")
	public String name(Model model, @PathVariable String name, @PathVariable String address) {
		model.addAttribute("msg", "Hi " + name + " from " + address + " time now is " + new Date());
		return "home";
	}
}
