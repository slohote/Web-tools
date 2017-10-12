package com.neu.spring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
import com.neu.spring.dao.CurrentStockDao;
import com.neu.spring.dao.StockDao;
import com.neu.spring.dao.TraderDao;
import com.neu.spring.pojo.StockCurrentInfo;
import com.neu.spring.pojo.StockEvent;
import com.neu.spring.pojo.StockInfo;
import com.neu.spring.pojo.TradeOrder;
import com.neu.spring.pojo.Trader;
import com.neu.spring.pojo.UserAccount;
@Controller
public class BuyOrderController {
	
	@Autowired
	@Qualifier("buyValidator")
	BuyValidator buyValidator;
	
	@Autowired
	@Qualifier("traderDao")
	TraderDao traderDao;
	
	@Autowired
	@Qualifier("buyOrderDao")
	BuyOrderDao buyOrderDao;
	
	@Autowired
	@Qualifier("currentStockDao")
	CurrentStockDao currentStockDao;
	
	@Autowired
	@Qualifier("stockDao")
	StockDao stockDao;
	
	@InitBinder
	//TraderValidator traderValidator=new TraderValidator();
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(buyValidator);
	}
	
	@RequestMapping(value = "/great.htm",method = RequestMethod.GET)
	public ModelAndView initializeForm(@ModelAttribute("tradeOrder")TradeOrder tradeOrder,HttpServletRequest request) {
        System.out.println("BuyEquityForm");
        long id=Long.parseLong(request.getParameter("id"));
        float currentPrice=0;
       // Set<StockCurrentInfo> currentInfoList=new TreeSet<StockCurrentInfo>();
        System.out.println("shubh" + id);
        StockInfo stockInfo=stockDao.getStockById(id);
         currentPrice=currentStockDao.getStockCurrentPrice(id);
        
//        currentInfoList=   stockInfo.getStockCurrentInfos();
//        for(int i = 1; currentInfoList.size()==i;i++)
//        {
//        	 currentPrice=(float) currentInfoList.get(i).getCurrentPrice();	
//        }
        
        System.out.println("currentPrice" + currentPrice);
        ModelAndView mv=new ModelAndView();
        mv.addObject("id", id);
        mv.addObject("currentPrice", currentPrice);
        mv.setViewName("BuyEquityForm");
        
        return mv;
        
        
		
	}
	@RequestMapping(value = "/great.htm",method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("tradeOrder")TradeOrder tradeOrder, BindingResult result,HttpServletRequest request) throws Exception {
	    
		buyValidator.validate(tradeOrder, result);
		if (result.hasErrors()) {
			return "BuyEquityForm";
		}
		
		long stockId=tradeOrder.getStockId();
		long id=tradeOrder.getTraderId();
		String buyDate=tradeOrder.getBuyDate();
		float buyPrice=tradeOrder.getBuyPrice();
		String status=tradeOrder.getStatus();
		int type=tradeOrder.getType();
		int qty=tradeOrder.getQty();
		String intrument=tradeOrder.getInstrument();
		float triggerPrice=tradeOrder.getTriggerPrice();
		
		
        
        

		try {
			Trader trader=traderDao.getTraderById(id);
			
			StockInfo stockInfo=stockDao.getStockById(stockId);
			int availableQty=currentStockDao.getStockQty(stockId);
			System.out.println("availableqty"+availableQty);
			//TradeOrder tradeOrder1=buyOrderDao.getSpecificOrder(stockId, id);
			//System.out.println("tradeorder1"+tradeOrder1);
			if(trader.getCreditScore().equalsIgnoreCase("high") && qty<=availableQty){
				tradeOrder.setTrader(trader);
			
			tradeOrder.setStockInfo(stockInfo);
//			stockCurrentInfo.setStockInfo_current(stockInfo);
			
//			//TraderDao traderDao=new TraderDao();
			buyOrderDao.create(tradeOrder);
//			stockCurrentDao.create(stockCurrentInfo);
//			
			trader.addTradeOrders(tradeOrder);
			trader.addStockInfo(stockInfo);
			stockInfo.addTraders(trader);
			
//			stockInfo.addStockCurrentInfo(stockCurrentInfo);
			
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
