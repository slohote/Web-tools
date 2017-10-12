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
import com.neu.spring.pojo.StockEvent;
import com.neu.spring.pojo.StockInfo;
import com.neu.spring.pojo.Trader;

@Controller
public class ViewIndividualEventsController {
	@Autowired
	@Qualifier("stockDao")
	StockDao stockDao;
	
	@RequestMapping(method=RequestMethod.GET,value="/viewindividualevents.htm")
	protected ModelAndView intializeForm(HttpServletRequest request)
	{
		StockInfo stockInfo=null;
		
		long id=Long.parseLong(request.getParameter("id"));
		 List eventList = new ArrayList();
		
		try {
            
            stockInfo = stockDao.getStockById(id);
            
            Iterator eventIterator = stockInfo.getStockEvents().iterator();

            while (eventIterator.hasNext())
            {
                StockEvent stockEvent = (StockEvent) eventIterator.next();
                eventList.add(stockEvent);
            }

		}
            //DAO.close();
         catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("Viewindividualevent", "stocks", eventList);
        return mv;
		
		
		
	}

}
