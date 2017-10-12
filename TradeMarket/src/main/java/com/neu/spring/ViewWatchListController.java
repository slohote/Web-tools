package com.neu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewWatchListController {
	@RequestMapping(value="/viewwatchlist.htm",method = RequestMethod.GET)
	public String initializeForm() {

		System.out.println("inside initilization");
		return "ViewWatchList";
	}

}
