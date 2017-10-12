package com.neu.spring;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.spring.pojo.TradeOrder;

public class SellValidator implements Validator {
	public boolean supports(Class aClass)
    {
        return aClass.equals(TradeOrder.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	TradeOrder tradeOrder = (TradeOrder) obj;
      //  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stockId", "error.invalid.stockId", "stockId Required");
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "traderId", "error.invalid.traderId", "traderId Required");
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sellDate", "error.invalid.sellDate", "sellDate Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sellPrice", "error.invalid.buyPrice", "sellPrice Required");
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status", "error.status", "status Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "error.type", "type Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "qty", "error.qty", "qty Required");
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "instrument", "error.instrument", "instrument Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "triggerPrice", "error.triggerPrice", "triggerPrice Required");
        
    }

}
