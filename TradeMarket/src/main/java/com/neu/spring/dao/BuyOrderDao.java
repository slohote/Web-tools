package com.neu.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.spring.pojo.StockCurrentInfo;
import com.neu.spring.pojo.StockInfo;
import com.neu.spring.pojo.TradeOrder;

public class BuyOrderDao extends Dao {
	public BuyOrderDao()
	{
		
	}
	public TradeOrder create(TradeOrder tradeOrder)
            throws Exception {
        try {
            begin();
            
            getSession().save(tradeOrder);
            commit();
            return tradeOrder;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create event", e);
            throw new Exception("Exception while creating currentinfo: " + e.getMessage());
        }
        finally{
        	close();
        }
    }
	public TradeOrder createSellOrder(TradeOrder tradeOrder)
            throws Exception {
        try {
            begin();
            
            getSession().save(tradeOrder);
            commit();
            return tradeOrder;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create event", e);
            throw new Exception("Exception while creating currentinfo: " + e.getMessage());
        }
        finally{
        	close();
        }
    }
	public TradeOrder getSpecificOrder(long stockId,long traderId)
	{
		TradeOrder tradeOrder=null;
		try{
			begin();
			
			Query query = getSession().createQuery("from TradeOrder where stockId='"+stockId+"' and traderId='"+traderId+"'");
            tradeOrder = (TradeOrder)query.uniqueResult();
            commit();
        }catch (HibernateException e) {
            rollback();
            //throw new Exception("Could not obtain the user " + e.getMessage());
        }finally{
        	close();
        }
        return tradeOrder;
	}
	
	public TradeOrder getOrderById(long id1)
	{
		TradeOrder tradeOrder=null;
		try{
			begin();
			
			Query query = getSession().createQuery("from TradeOrder where orderId='"+id1+"'");
            tradeOrder = (TradeOrder)query.uniqueResult();
            commit();
        }catch (HibernateException e) {
            rollback();
            //throw new Exception("Could not obtain the user " + e.getMessage());
        }finally{
        	close();
        }
        return tradeOrder;
	}
	

}
