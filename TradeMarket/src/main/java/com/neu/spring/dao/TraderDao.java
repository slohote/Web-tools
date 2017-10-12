package com.neu.spring.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.apache.velocity.app.event.ReferenceInsertionEventHandler.referenceInsertExecutor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.neu.spring.pojo.StockInfo;
import com.neu.spring.pojo.Trader;
import com.neu.spring.pojo.UserAccount;




public class TraderDao extends Dao{

	
	public TraderDao()
	{
		
	}
	
public Trader getTraderById(long id) {
        
	Trader trader = null;
        try {
            begin();
            Query query = getSession().createQuery("from Trader where id='"+id+"'");
            trader = (Trader)query.uniqueResult();
            commit();
        }catch (HibernateException e) {
            rollback();
            //throw new Exception("Could not obtain the user " + e.getMessage());
        }
        return trader;
    }

public void save(Trader trader) throws Exception {
    try {
        begin();
        getSession().update(trader);
        commit();
    } catch (HibernateException e) {
        rollback();
        throw new Exception("Could not save the stock", e);
    }
}
	public UserAccount create(Trader trader)
            throws Exception {
        try {
            begin();
            //Trader trader=new Trader();
           // trader.setId(id);
            getSession().save(trader);
            commit();
            return trader;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new Exception("Exception while creating advert: " + e.getMessage());
        }
        finally{
        	close();
        }
    }
	
	public boolean authenticateUser(String userName, String password) {
        UserAccount user = getUserByUserName(userName);         
        if(user!=null && user.getUserName().equals(userName) && user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
 
    public UserAccount getUserByUserName(String userName) {
        
        UserAccount user = null;
        try {
            begin();
            Query query = getSession().createQuery("from UserAccount where userName='"+userName+"'");
            user = (UserAccount)query.uniqueResult();
            commit();
        }catch (HibernateException e) {
            rollback();
            //throw new Exception("Could not obtain the user " + e.getMessage());
        }
        return user;
    }
    
    public int updatePd(long id,String creditScore){
    	int result=0;
    	try{
    		begin();
    		Query query = getSession().createQuery("update Trader set creditScore = :creditScore" +
    				" where id = :id");
    		query.setParameter("creditScore", creditScore);
    		query.setParameter("id", id);
    		 result = query.executeUpdate();
    		commit();
    		
    		
    	}
    catch(HibernateException e)
    	{
    	rollback();
        
    	}
    	finally{
        	close();
        }
    	return result;
    	
	

    }
    
    public List list() throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from Trader");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not list the stock", e);
        }
    }
     
}
