package com.neu.spring;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.spring.dao.StockCurrentDao;
import com.neu.spring.dao.StockDao;
import com.neu.spring.pojo.StockCurrentInfo;
import com.neu.spring.pojo.StockInfo;

@Controller
public class ViewCurrentRatesController {
	@Autowired
	@Qualifier("stockCurrentDao")
	StockCurrentDao stockCurrentDao;
	
	@RequestMapping(method=RequestMethod.GET,value="/viewcurrentrates.htm")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        List stockList = null;
         long id=Long.parseLong(request.getParameter("id"));
         System.out.println("id"+id);

        try {
            
            stockList =  stockCurrentDao.getCurrentInfoById(id);
//            for (Object result : stockList) {
//                Product p = (Product) result[0];
//                ProductCategory pc = (ProductCategory) result[1];
//            }

            Iterator stockIterator = stockList.iterator();

            while (stockIterator.hasNext())
            {
                StockCurrentInfo stock = (StockCurrentInfo) stockIterator.next();
                
                
                    stockList.add(stock);
                    
                }
            }
            //DAO.close();
         catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("list"+stockList);
        ModelAndView mv =new ModelAndView();
        mv.addObject("id", id);
        mv.addObject("stocks", stockList);
        mv.setViewName("ViewCurrentStock");
      //  ModelAndView mv = new ModelAndView("ViewCurrentStock", "stocks", stockList);
        return mv;
    }


}
