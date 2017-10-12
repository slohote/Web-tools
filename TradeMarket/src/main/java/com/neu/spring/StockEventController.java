package com.neu.spring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.spring.dao.StockDao;
import com.neu.spring.pojo.StockInfo;


@Controller
public class StockEventController {
	@Autowired
	@Qualifier("stockDao")
	StockDao stockDao;
	
	@RequestMapping(method=RequestMethod.GET,value="/stockdisplay.htm")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        List stockList = null;
       

        try {
            
            stockList = stockDao.list();

            Iterator stockIterator = stockList.iterator();

            while (stockIterator.hasNext())
            {
                StockInfo stock = (StockInfo) stockIterator.next();

                
                    stockList.add(stock);
                }
            }
            //DAO.close();
         catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("stockeventsoffering", "stocks", stockList);
        return mv;
    }
	//@RequestMapping(method=RequestMethod.GET,value="/addevent.htm")
//	protected String initializeForm(HttpServletRequest request){
	//	long id=Long.parseLong(request.getParameter("id"));
	//	StockInfo stockInfo=stockDao.getStockById(id);
	//	request.setAttribute("stock", stockInfo);
	//	return "AddStockEvent";
	//	
		
	//}
	
	

}
