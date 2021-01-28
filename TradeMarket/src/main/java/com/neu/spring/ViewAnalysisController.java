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
import com.neu.spring.pojo.StockEvent;
import com.neu.spring.pojo.StockInfo;

@Controller
public class ViewAnalysisController {
	
	@Autowired
	@Qualifier("stockDao")
	StockDao stockDao;
	
	@RequestMapping(method=RequestMethod.GET,value="/viewanalysis.htm")
	protected ModelAndView intializeForm(HttpServletRequest request)
	{
		StockInfo stockInfo=null;
		
		long id=Long.parseLong(request.getParameter("id"));
		 List eventList = new ArrayList();
		
		try {
            
            stockInfo = stockDao.getStockById(id);
            
            Iterator eventIterator = stockInfo.getStockCurrentInfos().iterator();

            while (eventIterator.hasNext())
            {
                StockCurrentInfo stockCurrentInfo = (StockCurrentInfo) eventIterator.next();
                eventList.add(stockCurrentInfo);
            }

		}
            //DAO.close();
         catch (Exception e) {
            System.out.println(e.getMessage());
        }
//add debug logs 
        ModelAndView mv = new ModelAndView("ViewAnalysis", "stocks", eventList);
        return mv;
		
		
		
	}

	

}
