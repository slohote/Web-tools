package com.neu.spring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

@Controller
public class WatchListController {
	
	@Autowired
	@Qualifier("stockDao")
	StockDao stockDao;
	@RequestMapping(method=RequestMethod.POST,value="/watchlist.htm")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
		HttpSession session=request.getSession();
        List<StockInfo> myList;
        if(session.getAttribute("output")!=null)
        {
            myList=(List<StockInfo>)session.getAttribute("output");
        }
        else
        {
            myList=new ArrayList<StockInfo>();
        }
        String[] selectedStocks=request.getParameterValues("stock");
        
     List<StockInfo> stockList = (List<StockInfo>)stockDao.list();

    for (int i = 0; i < selectedStocks.length; i++) {
        for (StockInfo s : stockList) {
            
            if (s.getStockId()==Long.parseLong(selectedStocks[i])) {
                if (!myList.contains(s)) {
                    System.out.println("match found");
                    myList.add(s);
                }
                
            }
        }
    }
       session.setAttribute("output",myList);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("AddedWatchList");
        return mv;
    }


}
