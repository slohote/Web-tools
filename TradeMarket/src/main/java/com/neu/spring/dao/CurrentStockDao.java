package com.neu.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.neu.spring.pojo.StockCurrentInfo;
import com.neu.spring.pojo.StockInfo;


public class CurrentStockDao extends Dao {
 public CurrentStockDao() {
	// TODO Auto-generated constructor stub
}
 public List getStockCurrentInfo() {
		
		
		
		Criteria crit = getSession().createCriteria(StockInfo.class);
		Criteria prdCrit = crit.createCriteria("stockCurrentInfos");
		//prdCrit.add(Restrictions.gt("price",25.0));
		List results = crit.list();
		return results;
		
	}
 public float getStockCurrentPrice(long stockId)
 {
	 float currentPrice=0;
	 try{
	 List<StockCurrentInfo> results=null;
	 Criteria crit = getSession().createCriteria(StockCurrentInfo.class);
	 Criteria suppCrit = crit.createCriteria("stockInfo_current");
	 suppCrit.add(Restrictions.eq("stockId",stockId));
	
	  results = crit.list();
      System.out.println("currentpricelist" + results);

    
     
     StockCurrentInfo obj = results.get(results.size()-1);
     currentPrice = obj.getCurrentPrice();
    
     System.out.println("querycurrentprice" + currentPrice);
	 
	 
 } catch (HibernateException e) {
     rollback();
     
 }
 finally
 {
	 close();
 }
	 return currentPrice;
 }
 
 public int getStockQty(long stockId)
 {
	 int qty=0;
	 try{
	 List<StockCurrentInfo> results=null;
	 Criteria crit = getSession().createCriteria(StockCurrentInfo.class);
	 Criteria suppCrit = crit.createCriteria("stockInfo_current");
	 suppCrit.add(Restrictions.eq("stockId",stockId));
	
	  results = crit.list();
      System.out.println("currentpricelist" + results);

    
     
     StockCurrentInfo obj = results.get(results.size()-1);
     qty = obj.getTotalExchangeQty();
    
     System.out.println("querycurrentprice" + qty);
	 
	 
 } catch (HibernateException e) {
     rollback();
     
 }
 finally
 {
	 close();
 }
	 return qty;
 }
 public List getHighestPrice(StockInfo stockInfo)throws Exception {
	 List<StockCurrentInfo> results=null;
	 try
	 {

		 
		 
		 Criteria crit = getSession().createCriteria(StockCurrentInfo.class);
		 ProjectionList projList = Projections.projectionList();
		 projList.add(Projections.max("highest"));
		crit.add(Restrictions.eq("stockInfo",stockInfo));
		 //projList.add(Projections.groupProperty("stockId"));
		 crit.setProjection(projList);
		 
		 results = crit.list();
		 System.out.println("func highest"+ results);
		 
		 
		 
//		 DetachedCriteria versions = DetachedCriteria.forClass(StockCurrentInfo.class, "f")
//				    .setProjection( Property.forName("f.highest").max())
//				    .add(Property.forName("f.stockId").eqProperty("fl.stockId"));
//
//				results=getSession().createCriteria(StockCurrentInfo.class, "fl")
//				    .add( Property.forName("fl.highest").eq(versions) )
//				   .list();
		 
		 
		 
		
		 
	 
 } catch (HibernateException e) {
     rollback();
     throw new Exception("Could not list the stock", e);
 }
 finally
 {
	 close();
 }
 
 return results;

 }
 
 public List list() throws Exception {
     try {
         begin();
         Query q = getSession().createQuery("from StockInfo as s join stockCurrentInfos as c");
         List list = q.list();
         commit();
         return list;
     } catch (HibernateException e) {
         rollback();
         throw new Exception("Could not list the stock", e);
     }
 }
 
 
	
}
