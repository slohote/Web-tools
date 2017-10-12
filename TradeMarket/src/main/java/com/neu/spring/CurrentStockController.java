package com.neu.spring;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

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
public class CurrentStockController {
	
	@Autowired
	@Qualifier("currentStockDao")
	CurrentStockDao currentStockDao;
//	@RequestMapping(value="/currentMarket.htm", method = RequestMethod.GET)
//	protected ModelAndView initializeForm(HttpServletRequest request){
//		ModelAndView mv=new ModelAndView();
//		ArrayList<StockCurrentInfo> list;
//		try {
//			list = (ArrayList<StockCurrentInfo>)currentStockDao.list();
//			mv.addObject("list", list);
//			System.out.println("list" +list);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		mv.setViewName("CurrentMarketOffering");
//		return mv;
//	}

}
