package com.neu.spring.pojo;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;

//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="stockinfotable")
public class StockInfo {
	
	@Id 
	@GeneratedValue
	@Column(name="stockId", unique = true, nullable = false)
	private long stockId;
	
	@Column(name="stockName")
    private String stockName;
	
	@Column(name="shortName")
    private String shortName;
	
	@Column(name="faceValue")
    private float faceValue;
	
	@Column(name="marketValue")
    private float marketValue;
	
	@Column(name="limitvalue")
    private int limitValue;
	
	@Column(name="valid")
    private float valid;
    
    //@JoinColumn(name="adminId")
   // private long admin;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="stockInfo")
    private Set<StockEvent> stockEvents = new HashSet<StockEvent>();
    
    @OneToMany(fetch=FetchType.EAGER,mappedBy="stockInfo_current")
    private Set<StockCurrentInfo> stockCurrentInfos = new HashSet<StockCurrentInfo>();
    
//    @OneToMany(fetch=FetchType.LAZY,mappedBy="pk_stock")
//    private Set<TraderStock> traderstock = new HashSet<TraderStock>();
    @ManyToMany(fetch=FetchType.EAGER,mappedBy="stockInfos")
    private Set<Trader> traders = new HashSet<Trader>();
	public long getStockId() {
		return stockId;
	}
	public void setStockId(long stockId) {
		this.stockId = stockId;
	}
	
	public float getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(float faceValue) {
		this.faceValue = faceValue;
	}
	public float getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(float marketValue) {
		this.marketValue = marketValue;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	
	public int getLimitValue() {
		return limitValue;
	}
	public void setLimitValue(int limitValue) {
		this.limitValue = limitValue;
	}
	public Set<StockEvent> getStockEvents() {
		return stockEvents;
	}
	public void setStockEvents(Set<StockEvent> stockEvents) {
		this.stockEvents = stockEvents;
	}
	public void addStocEvents(StockEvent stockEvent) {
        getStockEvents().add(stockEvent);
    }
	
	
	public Set<StockCurrentInfo> getStockCurrentInfos() {
		return stockCurrentInfos;
	}
	public void setStockCurrentInfos(Set<StockCurrentInfo> stockCurrentInfos) {
		this.stockCurrentInfos = stockCurrentInfos;
	}
	
	public void addStockCurrentInfo(StockCurrentInfo stockCurrentInfo) {
        getStockCurrentInfos().add(stockCurrentInfo);
    }
	public float getValid() {
		return valid;
	}
	public void setValid(float valid) {
		this.valid = valid;
	}
	public Set<Trader> getTraders() {
		return traders;
	}
	public void setTraders(Set<Trader> traders) {
		this.traders = traders;
	}
	public void addTraders(Trader trader) {
        getTraders().add(trader);
    }
	
//	public Set<TraderStock> getTraderstock() {
//		return traderstock;
//	}
//	public void setTraderstock(Set<TraderStock> traderstock) {
//		this.traderstock = traderstock;
//	}
    
	
	
	
	

}
