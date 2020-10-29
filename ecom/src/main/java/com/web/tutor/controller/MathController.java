package com.web.tutor.controller;

import java.util.*;

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

import com.web.tutor.applications.Equation;
import com.web.tutor.model.Addressess;
import com.web.tutor.model.PaymentMethod;
import com.web.tutor.model.Role;
import com.web.tutor.model.Users;
import com.web.tutor.repository.MathRepository;

@Controller
public class MathController {

	@Autowired
	private MathRepository mathRepository;
	
	@ModelAttribute("equation")
	Equation Equation() {
	return new Equation();
	}
	
	@GetMapping("math") 
		String math(@SessionAttribute(required = false) String loggedInuser, Model model) {
	    	try {
	    		model.addAttribute("page", "math");
	    		//if user is not in session return login page expired session
	    		if(loggedInuser.isEmpty() || loggedInuser == null) {
	    			model.addAttribute("error", "Expired session, please Login");
	    			return "login"; 
	    		}
	    		//populate equation details from database
	    		List<Equation> list = mathRepository.findAll();
				model.addAttribute("list", list );
				
				
				
				 
	    	} catch (Exception e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	} 
	    	return "math";
	}
	
	
	@GetMapping("addeq")
	public String addEq(Model model, @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
	            @RequestParam(value = "size", defaultValue = "4", required = false) Integer size) {
	        
		try {
	        Page<Equation> findAllPagable = mathRepository.findAll(PageRequest.of(page, size, Sort.by("id")));
	        model.addAttribute("list", findAllPagable);
	        model.addAttribute("msg"," Equations found");
	        model.addAttribute("equation", new Equation());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	return "addEquation";

	}
	
	@PostMapping("searchMath")
	public String search(Model model, @RequestParam long id) {
		model.addAttribute("list", mathRepository.findById(id));
		model.addAttribute("msg", "Equations found");
		return "search";
	}
	
	//add mapping to delete an Equation in the controller	
	@GetMapping({"deleteEquation"})
	public String delete(@RequestParam Long id, RedirectAttributes red){	
		try {
			mathRepository.deleteById(id);
			red.addFlashAttribute("success", "Delete Success");
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return "redirect:addeq";
	}
	
	//add Equation controller
	@PostMapping("addEquation")
	String addEquation(RedirectAttributes redirect,@ModelAttribute Equation eq, Model model) {
	
		try {
			System.out.println(eq.getEquation()+"****");
			mathRepository.save(eq);
			model.addAttribute("msg", "Equation Added");
			redirect.addFlashAttribute("success", "Add Equation Success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:addeq";	
		
	}
	
	@GetMapping("displayhelp")
	String displayHelp(@RequestParam Long id, Model model, RedirectAttributes redirect) {
		try {
			//populate help from database
			Optional<Equation> e = mathRepository.findById(id);
			redirect.addFlashAttribute("help", e.get().getHelp());
			model.addAttribute("help", e.get().getHelp());
			redirect.addFlashAttribute("codeEq", e.get().getCodeEq());
			model.addAttribute("codeEq", e.get().getCodeEq());
			System.out.println(id);
			System.out.println(e.get().getHelp());
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:math";
	}
	
	
}
