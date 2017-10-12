package com.neu.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.spring.dao.TraderDao;
import com.neu.spring.pojo.Trader;
@Controller
public class SetCreditController {
	@Autowired
	@Qualifier("traderDao")
	TraderDao traderDao;
	@RequestMapping(value = "/setcredit.htm",method = RequestMethod.GET)
	public ModelAndView initializeForm(HttpServletRequest request) {
		long id=0;
		try{
		 id=Long.parseLong(request.getParameter("id"));
		System.out.println("jay"+id);
		}
		catch(Exception e)
		{
			System.out.println("jay"+id);
		}
		Trader trader=traderDao.getTraderById(id);
		ModelAndView mv=new ModelAndView();
		mv.addObject("trader", trader);
		mv.setViewName("setpdform");
		return mv;
		
		
		
	}
	@RequestMapping(value = "/setcredit.htm",method = RequestMethod.POST)
	public String doSubmitAction(HttpServletRequest request) {
		String creditScore=request.getParameter("score");
		long id=Long.parseLong(request.getParameter("id"));
		int result=traderDao.updatePd(id, creditScore);
		System.out.println("result" + result);
		return "updatedpd";
		
		
		
		
	}
}
