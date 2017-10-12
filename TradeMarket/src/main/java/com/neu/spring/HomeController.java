package com.neu.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.spring.dao.TraderDao;
import com.neu.spring.pojo.Trader;
import com.neu.spring.pojo.UserAccount;


/**
 * Handles requests for the application home page.
 */
@Controller
//@RequestMapping("/adduser.htm")
public class HomeController {
	@Autowired
	@Qualifier("traderDao")
	TraderDao traderDao;
	
	@Autowired
	@Qualifier("traderValidator")
	TraderValidator traderValidator;
	@InitBinder
	//TraderValidator traderValidator=new TraderValidator();
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(traderValidator);
	}
	
	@RequestMapping(value = "/adduser.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("trader") Trader trader) {
        System.out.println("registration form");
		return "Registration";
	}
	@RequestMapping(value = "/adduser.htm",method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("trader") Trader trader, BindingResult result) throws Exception {
		traderValidator.validate(trader, result);
		if (result.hasErrors()) {
			return "Registration";
		}

		try {
			
			
			//TraderDao traderDao=new TraderDao();
			traderDao.create(trader);
			
			// DAO.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "traderpage";
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	
	
	
	
}
