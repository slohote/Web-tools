package com.neu.spring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.spring.dao.StockDao;
import com.neu.spring.pojo.StockCurrentInfo;
import com.neu.spring.pojo.StockInfo;

@Controller
public class DeleteStockController {
	@Autowired
	@Qualifier("stockDao")
	StockDao stockDao;
	
	@RequestMapping(method=RequestMethod.GET,value="/deletestock.htm")
	protected ModelAndView intializeForm(HttpServletRequest request)
	{
StockInfo stockInfo=null;
		
		long id=Long.parseLong(request.getParameter("id"));
		 List stockList = new ArrayList();
		// List stockList1 = new ArrayList();
		
		try {
            
            stockDao.deleteUser(id);
            stockList=stockDao.list();
//            Iterator eventIterator = stockList.iterator();
//
//            while (eventIterator.hasNext())
//            {
//                StockInfo stockCurrentInfo = (StockInfo) eventIterator.next();
//                stockList1.add(stockInfo);
//            }
		}
		catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("stockeventsoffering", "stocks", stockList);
        return mv;
	}
	

}
