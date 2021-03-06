package com.web.tutor.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.web.tutor.model.Users;
import com.web.tutor.repository.UserRepository;


@Component
public class DataValidation implements Validator {

	@Autowired
	public UserRepository userRepository;
	//add regex validation
	String emailRegex ="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	String passwordRegex ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$";	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Users.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		
		Users user = (Users) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fName", "size.user.fName");		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lName", "size.user.lName");			
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");		
		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
	    	errors.rejectValue("email", "size.user.unique");
	    }
		       
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password2", "NotEmpty");
        if (!user.getPassword2().equals(user.getPassword())) {
	    	errors.rejectValue("password2", "match.user.password2");
	    }
        		
		if(!user.getEmail().matches(emailRegex)) { 
			errors.rejectValue("email","size.user.email"); 
		}
		 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (!user.getPassword().matches(passwordRegex)) {
        	errors.rejectValue("password", "size.user.password");
	    }
       

	}

}

