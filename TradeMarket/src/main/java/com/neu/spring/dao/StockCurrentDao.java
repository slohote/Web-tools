package com.neu.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.neu.spring.pojo.StockCurrentInfo;
import com.neu.spring.pojo.StockInfo;

public class StockCurrentDao extends Dao{

	public StockCurrentDao()
	{
		
	}
	public StockCurrentInfo create(StockCurrentInfo stockCurrentInfo)
            throws Exception {
        try {
            begin();
            
            getSession().save(stockCurrentInfo);
            commit();
            return stockCurrentInfo;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create event", e);
            throw new Exception("Exception while creating currentinfo: " + e.getMessage());
        }
        finally{
        	close();
        }
    }
public ArrayList getCurrentInfoById(long id) {
        List list=null;
       // StockCurrentInfo stockCurrentInfo = null;
        try {
        	
//        	Criteria crit = getSession().createCriteria(StockCurrentInfo.class);
//    		//Criteria prdCrit = crit.createCriteria("stockCurrentInfos");
//    		crit.add(Restrictions.gt("stockId",id));
//    		List results = crit.list();
//    		return results;
        	
            begin();
            
            Query query = getSession().createQuery("from StockCurrentInfo where stockId='"+id+"'");
             list =query.list();
            commit();
            //return stockCurrentInfo;
            
        }catch (HibernateException e) {
            rollback();
            //throw new Exception("Could not obtain the user " + e.getMessage());
        }
        finally{
        	close();
        }
        return (ArrayList) list;
    }



}
