package com.neu.spring;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.spring.pojo.StockInfo;


public class StockValidator implements Validator{
	public boolean supports(Class aClass)
    {
        return aClass.equals(StockInfo.class);
    }

    public void validate(Object obj, Errors errors)
    {
        StockInfo stockInfo = (StockInfo) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stockName", "error.invalid.stockName", "stockName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shortName", "error.invalid.shortName", "shortName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "faceValue", "error.invalid.faceValue", "faceValue Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "marketValue", "error.invalid.marketValue", "marketValue Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "limitValue", "error.limitValue", "limitValue Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valid", "error.valid", "valid Required");
    }

}
