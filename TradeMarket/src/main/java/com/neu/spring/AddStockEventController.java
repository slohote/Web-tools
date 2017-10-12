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

import com.neu.spring.dao.StockDao;
import com.neu.spring.dao.StockEventDao;
import com.neu.spring.pojo.StockEvent;
import com.neu.spring.pojo.StockInfo;

@Controller
public class AddStockEventController {
	
	@Autowired
	@Qualifier("stockDao")
	StockDao stockDao;

	@Autowired
	@Qualifier("stockEventDao")
	StockEventDao stockEventDao;
	
	@Autowired
	@Qualifier("stockEventValidator")
	StockEventValidator stockEventValidator;
	
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(stockEventValidator);
	}
	@RequestMapping(value = "/addevent.htm",method = RequestMethod.GET)
	public ModelAndView initializeForm(@ModelAttribute("stockEvent") StockEvent stockEvent,HttpServletRequest request) {
        System.out.println("registration form");
        long id=Long.parseLong(request.getParameter("id"));
	//	StockInfo stockInfo=stockDao.getStockById(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("stock", id);
		//id.request.setAttribute("stock", id);
		mv.setViewName("AddStockEvent");
		//return "AddStockEvent";
		return mv;
	}
	
	@RequestMapping(value = "/addevent.htm",method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("stockEvent") StockEvent stockEvent, BindingResult result) throws Exception {
		stockEventValidator.validate(stockEvent, result);
		if (result.hasErrors()) {
			return "AddStockEvent";
		}
		String date = stockEvent.getDate();   //get posting user from addAdvertForm
        String eventDescription = stockEvent.getEventDescription();   //get category user from addAdvertForm
        long stockId=stockEvent.getStockId();

		try {
			StockInfo stockInfo=stockDao.getStockById(stockId);
			stockEvent.setStockInfo(stockInfo);
			//TraderDao traderDao=new TraderDao();
			stockEventDao.create(stockEvent);
			stockInfo.addStocEvents(stockEvent);
			stockDao.save(stockInfo);
			
			// DAO.close();
		} 
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "AddedStockEvent";
	}
}
