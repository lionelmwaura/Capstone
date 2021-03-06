package com.web.tutor.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.tutor.model.Addressess;
import com.web.tutor.model.PaymentMethod;
import com.web.tutor.model.Role;
import com.web.tutor.model.Users;
import com.web.tutor.repository.AddressRepository;
import com.web.tutor.repository.PaymentMethodRepository;
import com.web.tutor.repository.RoleRepository;
import com.web.tutor.repository.UserRepository;
import com.web.tutor.utils.DataValidation;
import com.web.tutor.utils.States;
import com.web.tutor.utils.WebUtils;

@Controller
@SessionAttributes({"loggedInuser","role"})
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DataValidation dataValidation;
	
	@Autowired
	private WebUtils webUtils;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository usersRepository;
	
	@Autowired
	private PaymentMethodRepository paymentMethodRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@ModelAttribute("address")
	Addressess address() {
	return new Addressess();		
	}
	
	@ModelAttribute("states")
    public List<States> populateStates(){    	
        return Arrays.asList(States.values());
    }
	
	@ModelAttribute("card")
	PaymentMethod pay() {
		return new PaymentMethod();		
	}
	
	@ModelAttribute("user")
	Users User() {
		return new Users();		
	}
	
	

	

	
	@PostMapping("register")
	String register(@ModelAttribute Users user, BindingResult result, Model model) {

		dataValidation.validate(user, result);
			if (result.hasErrors()) {
			model.addAttribute("profile", "active");
			return "signup";
		}	
		
		// save users and put the in session/login
		//user.setRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(roleRepository.findByRole("USER"))));
		userRepository.save(user);
		model.addAttribute("user_account", user);		
		model.addAttribute("msg","Hi "+ user.getfName()+ " welcome");
		model.addAttribute("page", "Profile");
	    model.addAttribute("loggedInuser", user.getEmail());
	    model.addAttribute("role", "USER");
		
		return "profile";
		
	}
	
	//
	@PostMapping("addcard")
	String addcard(@ModelAttribute PaymentMethod payment, Model model) {
	
		try {
			Users user=usersRepository.findById(payment.getId()).get();	
			payment.setUser(user);			
			paymentMethodRepository.save(payment);
			model.addAttribute("msg", "Card Added");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:profile";	
		
	}
	
	//
	@GetMapping("deletecard")
	String removeCard(@RequestParam Long id, Model model) {
	
		try {			
			paymentMethodRepository.deleteById(id);
			model.addAttribute("msg", "Card Removed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:profile";	
		
	}

	//
	@PostMapping("updatecontact")
	String update(@ModelAttribute Addressess addressess, Model model) {
	
		try {
			Users user=usersRepository.findById(addressess.getId()).get();	
			user.setfName(addressess.getUser().getfName());
			user.setlName(addressess.getUser().getlName());
			addressess.setUser(user);
			addressRepository.save(addressess);
			model.addAttribute("msg", "Update success");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:profile";	
		
	}
	
	//add session to profile get method to render profile page with session attributes	
		 @GetMapping("profile") 
		  String profile(@SessionAttribute(required = false) String loggedInuser, Model model) {
		     try {
		    	 model.addAttribute("page", "Profile");
		    	 //if user is not in session return login page expired session
				if(loggedInuser.isEmpty() || loggedInuser == null) {
				 model.addAttribute("error", "Expired session, please Login");
				return "login"; 
				 }
				//populate user details from database 
				userRepository.findByEmail(loggedInuser).ifPresent(a->{
					model.addAttribute("user_account", a);
					 //model.addAttribute("image", Base64.getEncoder().encodeToString(a.getData()));
					 if(a.getAddress()!=null) {
						 model.addAttribute("address", a.getAddress());	 
					 }

				 });
				model.addAttribute("page", "Profile");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  return "profile";
		 }

	//
	@PostMapping("updateUsers")
	public String update(@ModelAttribute Users user, Model model, RedirectAttributes red) {
		
		userRepository.findById(user.getId()).ifPresent(a->{
			a.setfName(user.getfName());
			a.setlName(user.getlName());
			a.setRole(user.getRole());
			userRepository.save(a);
			red.addFlashAttribute("success", "Update success");
		});
		
		return "redirect:admin";
	}
	
	//also modify edit roles to populate roles	
	@PostMapping("editrole")
		String editrole(@RequestParam Long id, @RequestParam String role, 
				RedirectAttributes redirect) {
			
			try {			
				usersRepository.findById(id).
				ifPresent(a->{	
					a.setRole(role);
					if(role.equals("ADMIN")) {
						a.setRoles(new HashSet<Role>(roleRepository.findAll()));
						usersRepository.save(a);
					}
					else {
						a.setRoles(new HashSet<Role>(Arrays.asList(roleRepository.findByRole(role))));
						usersRepository.save(a);
					}				
				});
				
				redirect.addFlashAttribute("success", role+ " Role Granted ");
			} catch (Exception e) {
				e.printStackTrace();
				redirect.addFlashAttribute("success", "Operation Fail");
			}
			
			return "redirect:admin";		
		}

	
	@GetMapping("admin")
	public String users(Model model, @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
	            @RequestParam(value = "size", defaultValue = "4", required = false) Integer size) {
	        
		try {
	        model.addAttribute("users", "active");
	        Page<Users> findAllPagable = userRepository.findAll(PageRequest.of(page, size, Sort.by("fName")));
	        model.addAttribute("list", findAllPagable);
	        model.addAttribute("msg"," Users found");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	return "admin";

	}
	
	//
	@PostMapping("search")
	public String search(Model model, @RequestParam String keyword) {
		model.addAttribute("list", userRepository.findByName(keyword));
		model.addAttribute("msg", "User found");
		return "search";
	}
	
	//add mapping to delete the user in the controller	
	@GetMapping({"deleteUser"})
	public String delete(@RequestParam Long id, RedirectAttributes red){	
		try {
			userRepository.deleteById(id);
			red.addFlashAttribute("success", "Delete Success");
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return "redirect:admin";
	}
	
	// add mapping for login post to login users in the controller
	@PostMapping("login")
	String login(RedirectAttributes redirect, Model model, @RequestParam String email, @RequestParam String password){
		  // login user
		  Optional<Users> user= userRepository.login(email, password);
		 //add user email and role in session
		  if(user.isPresent()) {
			  model.addAttribute("loggedInuser", email);
			  model.addAttribute("role", user.get().getRole()); 
			  
		  }else {
			  redirect.addFlashAttribute("error", "Invalid Credentials");
			  return "redirect:/login";
		  }
		  
		  return "redirect:/math";
			
	}
	
	//add logout mapping handler to clear session and logout user
	@GetMapping("logout")
	String logout(Model model, SessionStatus status, HttpSession session){
		 //status.setComplete();
		session.invalidate();
		model.addAttribute("loggedInuser", "");
		model.addAttribute("role", "");
		//Users user=new Users();		
		//model.addAttribute("user", user);
		model.addAttribute("msg", "You have been Logged out");
		
	return "login";
			
	}
	
	@PostMapping("/addimages")
	public String add(@RequestParam("file") MultipartFile file, 
			@RequestParam Long id, RedirectAttributes model) {
    	    
		Pattern ext = Pattern.compile("([^\\s]+(\\.(?i)(png|jpg))$)");
		try {
			
			  if(file != null && file.isEmpty()){
				  model.addFlashAttribute("error", "Error No file Selected "); 
			      return "redirect:profile"; 
			      } 
			  if(file.getSize()>1073741824){
				  model.addAttribute("error","File size "+file.getSize()+"KB excceds max allowed, try another photo ");
				  return "redirect:profile"; 
			      } 
			  Matcher mtch = ext.matcher(file.getOriginalFilename());
			  
			  if (!mtch.matches()) {
				  model.addFlashAttribute("error", "Invalid Image type "); 
			      return "redirect:profile";			  
			  }
			
			   webUtils.addProfilePhoto(file, id, "users");
			
				
			model.addFlashAttribute("msg", "Upload success "+ file.getSize()+" KB");
			
		} catch (Exception e) {
			//e.printStackTrace);
		}

		return "redirect:profile";
	}
	
	@PostMapping("sendemail")
	String sendemail(@RequestParam String email, 
					 @RequestParam String name,
					 @RequestParam String subject,
					 @RequestParam String message, RedirectAttributes red) {
		
			try {
				webUtils.sendMail(email, message+" From "+ name, subject);
				red.addFlashAttribute("success", "Your message has been sent. Thank you! "+ name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				red.addFlashAttribute("error", "Email fail! ");
			}
		
	 
	return "redirect:contact";		
	}


	
	
}
