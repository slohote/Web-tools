package com.neu.spring;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.spring.pojo.Trader;
import com.neu.spring.pojo.UserAccount;



public class TraderValidator implements Validator {
	 public boolean supports(Class aClass)
	    {
	        return aClass.equals(Trader.class);
	    }

	    public void validate(Object obj, Errors errors)
	    {
	    	Trader trader = (Trader) obj;
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.user", "User Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.email.emailId", "Email Required");
	    }

}
