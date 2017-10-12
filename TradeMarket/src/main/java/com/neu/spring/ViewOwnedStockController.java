package com.neu.spring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.spring.dao.StockDao;
import com.neu.spring.dao.TraderDao;
import com.neu.spring.pojo.StockInfo;
import com.neu.spring.pojo.Trader;


@Controller
public class ViewOwnedStockController {
	@Autowired
	@Qualifier("traderDao")
	TraderDao traderDao;
	
	@RequestMapping(method=RequestMethod.GET,value="/viewownedstock.htm")
	protected ModelAndView intializeForm(HttpServletRequest request)
	{
		Trader trader1=null;
		 List stockList = new ArrayList();
		HttpSession session=request.getSession();
		Trader trader=(Trader)session.getAttribute("user");
		long id=trader.getId();
		try {
            
            trader1 = traderDao.getTraderById(id);
            
            Iterator stockIterator = trader1.getStockInfos().iterator();

            while (stockIterator.hasNext())
            {
                StockInfo stockInfo = (StockInfo) stockIterator.next();
                stockList.add(stockInfo);
            }

		}
            //DAO.close();
         catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("Viewsownedstock", "stocks", stockList);
        return mv;
		
		
		
	}
	

}
