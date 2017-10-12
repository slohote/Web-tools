package com.neu.spring;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.spring.pojo.StockEvent;
import com.neu.spring.pojo.UserAccount;

public class StockEventValidator implements Validator {
	
	public boolean supports(Class aClass)
    {
        return aClass.equals(StockEvent.class);
    }

    public void validate(Object obj, Errors errors)
    {
         StockEvent stockEvent = (StockEvent) obj;
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stockId", "error.invalid.stockId", "stockId Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "error.invalid.date", "date Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventDescription", "error.invalid.eventDescription", "eventDescription Required");
        
    }

}
