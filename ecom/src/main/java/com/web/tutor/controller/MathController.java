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

import com.web.tutor.applications.Algebra;
import com.web.tutor.applications.Equation;

@Controller
public class MathController {

	
	
	@ModelAttribute("algebra")
	Algebra algebra() {
	return new Algebra();
	}
	
	
	
	@PostMapping("createEquation")
	String createEquation(@ModelAttribute Equation eq, @RequestParam ArrayList<Double> input, @RequestParam ArrayList<String> arithmetic, @RequestParam String math) {
		
		eq.setInput(input);
		eq.setMath(math);
		eq.setArithmetic(arithmetic);
		return "redirect:Math";
	}
	
	
}
