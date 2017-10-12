package com.neu.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.spring.dao.BuyOrderDao;
import com.neu.spring.dao.StockDao;
import com.neu.spring.dao.TraderDao;
import com.neu.spring.pojo.StockInfo;
import com.neu.spring.pojo.TradeOrder;
import com.neu.spring.pojo.Trader;
@Controller
public class SellStockController {
	@Autowired
	@Qualifier("sellValidator")
	SellValidator sellValidator;
	
	@Autowired
	@Qualifier("buyOrderDao")
	BuyOrderDao buyOrderDao;
	
	@Autowired
	@Qualifier("traderDao")
	TraderDao traderDao;
	
	@Autowired
	@Qualifier("stockDao")
	StockDao stockDao;
	
	@InitBinder
	//TraderValidator traderValidator=new TraderValidator();
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(sellValidator);
	}
	
	@RequestMapping(value = "/sellstock.htm",method = RequestMethod.GET)
	public ModelAndView initializeForm(@ModelAttribute("tradeOrder")TradeOrder tradeOrder,HttpServletRequest request) {
        System.out.println("BuyEquityForm");
        long id=Long.parseLong(request.getParameter("id"));
        System.out.println("shubh" + id);
        HttpSession session=request.getSession();
        Trader trader=(Trader)session.getAttribute("user");
        ModelAndView mv=new ModelAndView();
        mv.addObject("id", id);
        mv.setViewName("SellEquityForm");
        
		return mv;
	}


@RequestMapping(value = "/sellstock.htm",method = RequestMethod.POST)
protected String doSubmitAction(@ModelAttribute("tradeOrder")TradeOrder tradeOrder, BindingResult result,HttpServletRequest request) throws Exception {
    
	sellValidator.validate(tradeOrder, result);
	if (result.hasErrors()) {
		return "SellEquityForm";
	}
	
	long stockId=tradeOrder.getStockId();
	long id=tradeOrder.getTraderId();
	String sellDate=tradeOrder.getSellDate();
	float sellPrice=tradeOrder.getSellPrice();
	String status=tradeOrder.getStatus();
	int type=tradeOrder.getType();
	int qty=tradeOrder.getQty();
	String intrument=tradeOrder.getInstrument();
	float triggerPrice=tradeOrder.getTriggerPrice();
	
	
    
    

	try {
		Trader trader=traderDao.getTraderById(id);
		if(trader.getCreditScore().equalsIgnoreCase("high")){
		StockInfo stockInfo=stockDao.getStockById(stockId);
		
		tradeOrder.setTrader(trader);
		
		tradeOrder.setStockInfo(stockInfo);
//		stockCurrentInfo.setStockInfo_current(stockInfo);
		
//		//TraderDao traderDao=new TraderDao();
		buyOrderDao.create(tradeOrder);
//		stockCurrentDao.create(stockCurrentInfo);
//		
		trader.addTradeOrders(tradeOrder);
		trader.addStockInfo(stockInfo);
		stockInfo.addTraders(trader);
		
//		stockInfo.addStockCurrentInfo(stockCurrentInfo);
		
		traderDao.save(trader);
		stockDao.save(stockInfo);
		long generatedId=tradeOrder.getOrderId();
		request.setAttribute("generatedId", generatedId);
		}
		else if(trader.getCreditScore().equalsIgnoreCase("low"))
		{
			request.setAttribute("Message", "You are not eligible for trading!");
		}
		
		// DAO.close();
	} 
	catch (Exception e) {
		System.out.println("Exception: " + e.getMessage());
	}

	

return "PlacedBuyOrder";


}

}
