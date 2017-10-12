package com.neu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.spring.dao.StockDao;
import com.neu.spring.dao.TraderDao;
import com.neu.spring.pojo.StockInfo;
import com.neu.spring.pojo.UserAccount;

@Controller
public class AddStockController {
	@Autowired
	@Qualifier("stockDao")
	StockDao stockDao;
	
	@Autowired
	@Qualifier("stockValidator")
	StockValidator stockValidator;
	
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(stockValidator);
	}
	@RequestMapping(value = "/addstock.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("stockInfo") StockInfo stockInfo) {
        System.out.println("registration form");
		return "IPO";
	}
	@RequestMapping(value = "/addstock.htm",method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("stockInfo") StockInfo stockInfo, BindingResult result) throws Exception {
		stockValidator.validate(stockInfo, result);
		if (result.hasErrors()) {
			return "IPO";
		}

		try {
			
			
			//TraderDao traderDao=new TraderDao();
			stockDao.create(stockInfo);
			
			// DAO.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "AddedStock";
	}
	
	

}
