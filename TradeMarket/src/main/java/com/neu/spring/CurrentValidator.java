package com.neu.spring;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.spring.pojo.StockCurrentInfo;
import com.neu.spring.pojo.UserAccount;

public class CurrentValidator implements Validator {
	public boolean supports(Class aClass)
    {
        return aClass.equals(StockCurrentInfo.class);
    }

    public void validate(Object obj, Errors errors)
    {
        StockCurrentInfo stockCurrentInfo = (StockCurrentInfo) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "error.invalid.date", "date Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "openPrice", "error.invalid.openPrice", "openPrice Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPrice", "error.invalid.currentPrice", "currentPrice Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "highest", "error.invalid.highest", "highest Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lowest", "error.invalid.lowest", "lowest Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "totalExchangeQty", "error.invalid.totalExchangeQty", "totalExchangeQty Required");
    }


}
