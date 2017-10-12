package com.neu.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.neu.spring.pojo.StockInfo;

import com.neu.spring.pojo.UserAccount;





public class StockDao extends Dao {
	public StockDao()
	{
		
	}
	public StockInfo create(StockInfo stockInfo)
            throws Exception {
        try {
            begin();
            
            getSession().save(stockInfo);
            commit();
            return stockInfo;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new Exception("Exception while creating advert: " + e.getMessage());
        }
        finally{
        	close();
        }
    }
	
	public void save(StockInfo stockInfo) throws Exception {
        try {
            begin();
            getSession().update(stockInfo);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not save the stock", e);
        }
    }
	public List list() throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from StockInfo");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not list the stock", e);
        }
    }
	
	
	
public StockInfo getStockById(long id) {
        
        StockInfo stockInfo = null;
        try {
            begin();
            Query query = getSession().createQuery("from StockInfo where stockId='"+id+"'");
            stockInfo = (StockInfo)query.uniqueResult();
            commit();
        }catch (HibernateException e) {
            rollback();
            //throw new Exception("Could not obtain the user " + e.getMessage());
        }
        return stockInfo;
    }

     public List<StockInfo> searchUsers(String key, String flag) {
       
        Query query = null;
        List<StockInfo> list = new ArrayList<StockInfo>();
        try {
 //       	begin();
//            String hql = "FROM StockInfo u where u." + flag + "= :value";
//            query = getSession().createQuery(hql);
//            query.setParameter("value", "%"+key+"%");
            
            Criteria crit = getSession().createCriteria(StockInfo.class);
            crit.add(Restrictions.like(flag,key+"%"));
            list = crit.list();
            
           // list = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return list;
    }
    
    

    public void deleteUser(long id) {
        
        Transaction tx = null;
        try {
            begin();
            StockInfo stockInfo
                    = (StockInfo) getSession().get(StockInfo.class, id);
            getSession().delete(stockInfo);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            close();
        }
    }



	

}
