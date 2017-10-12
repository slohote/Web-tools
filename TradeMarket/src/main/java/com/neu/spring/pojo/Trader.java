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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="trader")
@PrimaryKeyJoinColumn(name="user_ID")
public class Trader extends UserAccount {
//	@Id 
//	@GeneratedValue
//	@Column(name="traderId", unique = true, nullable = false)
//	private long traderId;
	
	
	
	
	
	@Column(name = "creditScore")
	private String creditScore;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="trader")
    private Set<TradeOrder> tradeOrders = new HashSet<TradeOrder>();
	
//	@OneToMany(fetch=FetchType.LAZY,mappedBy="traderstock")
//    private Set<TraderStock> traderStocks = new HashSet<TraderStock>();
	@ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "trader_stock", 
	joinColumns = { @JoinColumn(name = "traderId") },
	inverseJoinColumns = { @JoinColumn(name = "stockId") })
	private Set<StockInfo> stockInfos = new HashSet<StockInfo>();
	public Trader()
	{
		
	}
//	public long getTraderId() {
//		return traderId;
//	}
//	public void setTraderId(long traderId) {
//		this.traderId = traderId;
//	}
	
	
	public Set<TradeOrder> getTradeOrders() {
		return tradeOrders;
	}
	public Set<StockInfo> getStockInfos() {
		return stockInfos;
	}


	public void setStockInfos(Set<StockInfo> stockInfos) {
		this.stockInfos = stockInfos;
	}
	public void addStockInfo(StockInfo stockInfo) {
        getStockInfos().add(stockInfo);
    }


	public void setTradeOrders(Set<TradeOrder> tradeOrders) {
		this.tradeOrders = tradeOrders;
	}
	public void addTradeOrders(TradeOrder tradeOrder) {
        getTradeOrders().add(tradeOrder);
    }
	
	//public Set<TraderStock> getTraderStocks() {
	//	return traderStocks;
	//}
	//public void setTraderStocks(Set<TraderStock> traderStocks) {
	//	this.traderStocks = traderStocks;
	//}
	//public void addTraderStocks(TraderStock traderStock) {
    //    getTraderStocks().add(traderStock);
    //}
	
	public String getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}
	
	
	

}
