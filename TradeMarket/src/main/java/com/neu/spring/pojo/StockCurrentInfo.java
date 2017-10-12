package com.neu.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;

//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="stockcurrentinfotable")
public class StockCurrentInfo {
	@Id 
	@GeneratedValue
	@Column(name="stockCurrentInfoId", unique = true, nullable = false)
	private long stockCurrentInfoId;
	
	@Column(name="date")
	private String date;
	
	@Column(name="openPrice")
	private float openPrice;
	
	@Column(name="currentPrice")
	private float currentPrice;
	
	@Column(name="highest")
	private float highest;
	
	@Column(name="lowest")
	private float lowest;
	
	@Column(name="totalExchangeQty")
	private int totalExchangeQty;
	
	//@JoinColumn(name="stockId")
	//private long stockInfo_current;
	
	@Transient //will stored in  table
    private long stockId;
	
	@ManyToOne
	@JoinColumn(name="stockId")
	private StockInfo stockInfo_current;
	
	public StockCurrentInfo()
	{
		
	}
	
	
	public long getStockId() {
		return stockId;
	}


	public void setStockId(long stockId) {
		this.stockId = stockId;
	}


	public StockInfo getStockInfo_current() {
		return stockInfo_current;
	}

	public void setStockInfo_current(StockInfo stockInfo_current) {
		this.stockInfo_current = stockInfo_current;
	}

	public long getStockCurrentInfoId() {
		return stockCurrentInfoId;
	}
	public void setStockCurrentInfoId(long stockCurrentInfoId) {
		this.stockCurrentInfoId = stockCurrentInfoId;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(float openPrice) {
		this.openPrice = openPrice;
	}
	public float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}
	public float getHighest() {
		return highest;
	}
	public void setHighest(float highest) {
		this.highest = highest;
	}
	public float getLowest() {
		return lowest;
	}
	public void setLowest(float lowest) {
		this.lowest = lowest;
	}
	public int getTotalExchangeQty() {
		return totalExchangeQty;
	}
	public void setTotalExchangeQty(int totalExchangeQty) {
		this.totalExchangeQty = totalExchangeQty;
	}
	
	

}
