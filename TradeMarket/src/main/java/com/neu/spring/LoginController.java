package com.neu.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.spring.dao.TraderDao;
import com.neu.spring.pojo.UserAccount;



@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("traderDao")
	TraderDao traderDao;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String initializeForm() {

		System.out.println("inside initilization");
		return "loginform";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/login.htm")
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
		ModelAndView mv=new ModelAndView();
		String userName = hsr.getParameter("userName");   
	     String password = hsr.getParameter("password");
	     System.out.println("username" + userName);
	     //TraderDao traderDao=new TraderDao();
	     boolean result = traderDao.authenticateUser(userName, password);
	     UserAccount user = traderDao.getUserByUserName(userName);
	     System.out.println("result" +result);
	     if(result == true){
	    	 if(user.getRole().equalsIgnoreCase("Admin"))
	    	 {
	         hsr.getSession().setAttribute("user", user);
	         mv.addObject("userAccount", user);
	         mv.setViewName("adminhomepage");
	    	 }
	    	 else if (user.getRole().equalsIgnoreCase("Trader"))
	    	 {
	    		 hsr.getSession().setAttribute("user", user);
		         mv.addObject("userAccount", user);
		         mv.setViewName("traderpage");
	    		 
	    	 }
	     }
	     //else{
	    //	 mv.setViewName("loginform");
	    // }
	     return mv;
		
		
		
	}
	
	

}
