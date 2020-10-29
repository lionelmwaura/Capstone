package com.web.tutor;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.tutor.applications.Equation;
import com.web.tutor.applications.Basics;

@SpringBootApplication
public class CapstoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneApplication.class, args);
		
		Basics b = new Basics();  
		System.out.println(b.abs(-1.0));
		
	}
	
	

}
