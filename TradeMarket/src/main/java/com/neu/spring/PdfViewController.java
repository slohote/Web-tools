package com.neu.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;



import com.neu.spring.dao.BuyOrderDao;
import com.neu.spring.dao.TraderDao;
import com.neu.spring.pojo.TradeOrder;


@Controller
public class PdfViewController {
	@Autowired
	@Qualifier("buyOrderDao")
	BuyOrderDao buyOrderDao;
	@RequestMapping(value = "/viewpdfreport.pdf", method = RequestMethod.GET)
	public ModelAndView createReport(HttpServletRequest request)
	{
		long id=Long.parseLong(request.getParameter("id1"));
		TradeOrder tradeOrder=buyOrderDao.getOrderById(id);
		
        // return a view which will be resolved by an excel view resolver
        //return new ModelAndView("pdfView", "tradeOrder", tradeOrder);
        View view = new PdfReportView();
		
		return new ModelAndView(view,"tradeOrder",tradeOrder);
	}

}
