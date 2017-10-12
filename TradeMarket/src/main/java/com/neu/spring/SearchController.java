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

import com.neu.spring.dao.StockDao;
import com.neu.spring.dao.TraderDao;

import com.neu.spring.pojo.StockInfo;


@Controller
public class SearchController {
	@Autowired
	@Qualifier("stockDao")
	StockDao stockDao;
	@RequestMapping(method=RequestMethod.POST,value="/searchSpecificStock.htm")
    public void handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
        String action = hsr.getParameter("action");
        
        if (action.equalsIgnoreCase("searchuser")) {
        	
            List<StockInfo> stockList = new ArrayList();

            String key = hsr.getParameter("key");
            String searchKey = hsr.getParameter("flag");
            System.out.println("flag" + searchKey);
            
            
            
            stockList = stockDao.searchUsers(key, searchKey);
            System.out.println("searchlist" + stockList);
            JSONObject obj = new JSONObject();
            
            JSONArray ja=new JSONArray();
            for(int i=0;i<stockList.size();i++){
            	JSONObject jo = new JSONObject();
            	jo.put("stockId", stockList.get(i).getStockId());
            	jo.put("stockName", stockList.get(i).getStockName());
            	jo.put("shortName", stockList.get(i).getShortName());
            	jo.put("marketValue", stockList.get(i).getMarketValue());
            	jo.put("limitValue", stockList.get(i).getLimitValue());
            	
            	ja.put(jo);
            }
            
            obj.put("users",ja);
            PrintWriter out = hsr1.getWriter();
            out.println(obj);
            System.out.println("obj" +obj);
            
            
            
//            JSONObject obj = new JSONObject();
//            obj.put("users",userList);
//            PrintWriter out = hsr1.getWriter();
//            out.println(obj);
        }
        
        if(action.equals("delete")){
            int id = Integer.parseInt(hsr.getParameter("user"));
            stockDao.deleteUser(id);
        }

       // return null;
    }

	

}
