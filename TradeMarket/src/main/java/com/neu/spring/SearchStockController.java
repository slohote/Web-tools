package com.neu.spring;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.spring.dao.StockCurrentDao;
import com.neu.spring.dao.StockDao;
import com.neu.spring.pojo.StockCurrentInfo;


@Controller
public class SearchStockController {
	@Autowired
	@Qualifier("stockCurrentDao")
	StockCurrentDao stockCurrentDao;

	@RequestMapping(method=RequestMethod.POST,value="/searchStock.htm")
    public void handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
        
        	
            List<StockCurrentInfo> stockList = new ArrayList<StockCurrentInfo>();

            long key = Long.parseLong(hsr.getParameter("key"));
            //String searchKey = hsr.getParameter("flag");

            
            
            stockList = stockCurrentDao.getCurrentInfoById(key);
//            for(int i=0;i<stockList.size();i++){
//            	System.out.println(stockList.get(i).getDate());
//            }stockList
            System.out.println("stocklist"+ stockList);
            JSONObject obj = new JSONObject();
           
            JSONArray ja=new JSONArray();
            for(int i=0;i<stockList.size();i++){
            	JSONObject jo = new JSONObject();
            	jo.put("date", stockList.get(i).getDate());
            	jo.put("openPrice", stockList.get(i).getOpenPrice());
            	jo.put("currentPrice", stockList.get(i).getCurrentPrice());
            	jo.put("highest", stockList.get(i).getHighest());
            	jo.put("lowest", stockList.get(i).getLowest());
            	jo.put("totalExchangeQty", stockList.get(i).getTotalExchangeQty());
            	ja.put(jo);
            }
            
            obj.put("users",ja);
            PrintWriter out = hsr1.getWriter();
            out.println(obj);
            System.out.println("obj" +obj);
        

        //return null;
	}

}
