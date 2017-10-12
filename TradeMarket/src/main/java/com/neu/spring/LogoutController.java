package com.neu.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.spring.pojo.UserAccount;
@Controller
public class LogoutController {
	
	@RequestMapping(value = "/logout.htm",method = RequestMethod.GET)
	public String initializeForm(HttpServletRequest request) {
        System.out.println("logout form");
        HttpSession session=request.getSession();
        session.removeAttribute("userName");
        session.removeAttribute("password");
        session.invalidate();
		return "loginform";
	}

}
