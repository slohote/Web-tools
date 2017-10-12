package com.neu.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.spring.dao.StockCurrentDao;
import com.neu.spring.dao.StockDao;
import com.neu.spring.dao.StockEventDao;
import com.neu.spring.pojo.StockCurrentInfo;
import com.neu.spring.pojo.StockEvent;
import com.neu.spring.pojo.StockInfo;


@Controller
public class UpdateRateController {
	@Autowired
	@Qualifier("stockCurrentDao")
	StockCurrentDao stockCurrentDao;

	@Autowired
	@Qualifier("stockDao")
	StockDao stockDao;
	
	@Autowired
	@Qualifier("currentValidator")
	CurrentValidator currentValidator;
	
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(currentValidator);
	}
	@RequestMapping(value = "/updaterate.htm",method = RequestMethod.GET)
	public ModelAndView initializeForm(@ModelAttribute("stockCurrentInfo") StockCurrentInfo stockCurrentInfo,HttpServletRequest request) {
        System.out.println("registration form");
        long id=Long.parseLong(request.getParameter("id"));
	//	StockInfo stockInfo=stockDao.getStockById(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("stock", id);
		//id.request.setAttribute("stock", id);
		mv.setViewName("UpdateRatePage");
		//return "AddStockEvent";
		return mv;
	}
	
	@RequestMapping(value = "/updaterate.htm",method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("stockCurrentInfo") StockCurrentInfo stockCurrentInfo, BindingResult result) throws Exception {
		currentValidator.validate(stockCurrentInfo, result);
		if (result.hasErrors()) {
			return "UpdateRatePage";
		}
		String date = stockCurrentInfo.getDate();   //get posting user from addAdvertForm
        float openPrice = stockCurrentInfo.getOpenPrice();   //get category user from addAdvertForm
        float currentPrice = stockCurrentInfo.getCurrentPrice();
        float highest = stockCurrentInfo.getHighest();
        float lowest = stockCurrentInfo.getLowest();
        float totalExchangeQty = stockCurrentInfo.getTotalExchangeQty();
        
        long stockId=stockCurrentInfo.getStockId();

		try {
			StockInfo stockInfo=stockDao.getStockById(stockId);
			stockCurrentInfo.setStockInfo_current(stockInfo);
			//TraderDao traderDao=new TraderDao();
			stockCurrentDao.create(stockCurrentInfo);
			
			stockInfo.addStockCurrentInfo(stockCurrentInfo);
			stockDao.save(stockInfo);
			
			// DAO.close();
		} 
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "AddedStockCurrentRate";
	}
	
	

}
