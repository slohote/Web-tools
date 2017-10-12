package com.neu.spring.dao;

import org.hibernate.HibernateException;

import com.neu.spring.pojo.StockEvent;
import com.neu.spring.pojo.StockInfo;

public class StockEventDao extends Dao {
	
	 public StockEventDao() {
		// TODO Auto-generated constructor stub
	}
	
	public StockEvent create(StockEvent stockEvent)
            throws Exception {
        try {
            begin();
            
            getSession().save(stockEvent);
            commit();
            return stockEvent;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create event", e);
            throw new Exception("Exception while creating advert: " + e.getMessage());
        }
        finally{
        	close();
        }
    }

}
