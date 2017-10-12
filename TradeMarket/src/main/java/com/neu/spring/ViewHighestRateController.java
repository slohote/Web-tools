package com.neu.spring;

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

import com.neu.spring.dao.CurrentStockDao;
import com.neu.spring.dao.StockDao;
import com.neu.spring.pojo.StockCurrentInfo;
import com.neu.spring.pojo.StockInfo;

@Controller
public class ViewHighestRateController {
	
	
	@Autowired
	@Qualifier("currentStockDao")
	CurrentStockDao currentStockDao;
	
	@Autowired
	@Qualifier("stockDao")
	StockDao stockDao;
	
	@RequestMapping(method=RequestMethod.GET,value="/viewhighest.htm")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        List stockList = null;
        long id=Long.parseLong(request.getParameter("id"));
        StockInfo stockInfo=stockDao.getStockById(id);
       

        try {
            
            stockList = currentStockDao.getHighestPrice(stockInfo);
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
        System.out.println("highes list"+ stockList);
        ModelAndView mv = new ModelAndView("ViewCurrentStock", "stock", stockList);
        return mv;
    }

}
