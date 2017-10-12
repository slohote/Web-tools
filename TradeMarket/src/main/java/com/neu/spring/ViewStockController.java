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

import com.neu.spring.dao.CurrentStockDao;
import com.neu.spring.dao.StockDao;
import com.neu.spring.pojo.StockCurrentInfo;
import com.neu.spring.pojo.StockInfo;

@Controller
public class ViewStockController {
	@Autowired
	@Qualifier("stockDao")
	StockDao stockDao;
	
	@RequestMapping(method=RequestMethod.GET,value="/viewstocks.htm")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ArrayList<StockInfo> stockList = new ArrayList<StockInfo>();
        List stockList = null;
        ModelAndView mv=new ModelAndView();
        int page = 1;
        int recordsPerPage = 5;
        ArrayList<StockInfo> stockSubList = new ArrayList<StockInfo>();

        try {
            
            stockList = stockDao.list();
//            for (Object result : stockList) {
//                Product p = (Product) result[0];
//                ProductCategory pc = (ProductCategory) result[1];
//            }

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
        
        if (stockList != null) {
            if (stockList.size() != 0) {
                if (request.getParameter("page") != null) {
                    page = Integer.parseInt(request.getParameter("page"));
                }
                int noOfRecords = stockList.size();
                int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

                int num = page * recordsPerPage;
                for (int j = num; j < num + recordsPerPage; j++) {
                	stockSubList.add((StockInfo) stockList.get(j));
                }
                //session.setAttribute("csvDetails", salesList);

                int strlenght = stockList.size();
                mv.addObject("lenght", strlenght);
                mv.addObject("recordsPerPage", recordsPerPage);
                mv.addObject("noOfPages", noOfPages);
                mv.addObject("currentPage", page);
                mv.addObject("csvDetails", stockSubList);
            }
            else{
                mv.addObject("error", "No such file exist");
            }
        } else {
            mv.addObject("error", "No such file exist");
        }

        
        mv.setViewName("ViewStock");

       // ModelAndView mv = new ModelAndView("ViewStock", "stocks", stockList);
        return mv;
    }

}
