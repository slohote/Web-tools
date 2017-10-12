package com.neu.spring.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="admintable")
@PrimaryKeyJoinColumn(name="user_ID")
public class Admin extends UserAccount{
//	@Id 
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="adminId", unique = true, nullable = false)
//	private long adminId;
	
	
	//@OneToMany(fetch=FetchType.LAZY,mappedBy="admin")
	//private Set<StockInfo> stockInfos = new HashSet<StockInfo>();
	public Admin()
	{
		
	}
	
	//public Set<StockInfo> getStockInfos() {
	//	return stockInfos;
	//}

	//public void setStockInfos(Set<StockInfo> stockInfos) {
	//	this.stockInfos = stockInfos;
	//}
	//public void addStockInfo(StockInfo stockInfo) {
     //   getStockInfos().add(stockInfo);
   // }

//	public long getAdminId() {
//		return adminId;
//	}
//	public void setAdminId(long adminId) {
//		this.adminId = adminId;
//	}
	
	
	

}
