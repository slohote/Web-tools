package com.neu.spring;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.spring.dao.StockDao;
import com.neu.spring.dao.TraderDao;
import com.neu.spring.pojo.StockInfo;
import com.neu.spring.pojo.TradeOrder;
import com.neu.spring.pojo.Trader;
@Controller
public class SetPdController {
	@Autowired
	@Qualifier("traderDao")
	TraderDao traderDao;
	@RequestMapping(value = "/setpd.htm",method = RequestMethod.GET)
	public ModelAndView initializeForm(HttpServletRequest request) {
        System.out.println("BuyEquityForm");
        //long id=Long.parseLong(request.getParameter("id"));
       // System.out.println("shubh" + id);
        List traderList = null;
        

        try {
            
            traderList = traderDao.list();

            Iterator traderIterator = traderList.iterator();

            while (traderIterator.hasNext())
            {
                Trader trader = (Trader) traderIterator.next();

                
                    traderList.add(trader);
                }
            }
            //DAO.close();
         catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("SetPd", "trader", traderList);
        return mv;
    }
		
	
	
	
	

}
