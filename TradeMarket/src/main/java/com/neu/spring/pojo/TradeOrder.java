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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;

//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="tradeorder")

public class TradeOrder {
	
	@Id 
	@GeneratedValue
	@Column(name="orderId", unique = true, nullable = false)
	private long orderId;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="stockcurrentId")
	private StockCurrentInfo stockCurrentInfo;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="stockId")
	private StockInfo stockInfo;
	 
	@Transient
	private long stockId;
	
	@Column(name="buyDate")
	private String buyDate;
	
	@Column(name="sellDate")
	private String sellDate;
	
	@Column(name="status")
	private String status;
	
	@Column(name="type")
	private int type;
	
	@Column(name="qty")
	private int qty;
	
	@ManyToOne
	@JoinColumn(name="trderId")
	private Trader trader;
	
	@Transient
	private long traderId;
	
	@Column(name="instrument")
	private String instrument;
	
	@Column(name="triggerPrice")
	private float triggerPrice;
	
	@Column(name="buyPrice")
	private float buyPrice;
	
	@Column(name="sellPrice")
	private float sellPrice;
	public TradeOrder()
	{
		
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public long getStockId() {
		return stockId;
	}
	public void setStockId(long stockId) {
		this.stockId = stockId;
	}
	public long getTraderId() {
		return traderId;
	}
	public void setTraderId(long traderId) {
		this.traderId = traderId;
	}
	public StockCurrentInfo getStockCurrentInfo() {
		return stockCurrentInfo;
	}
	public void setStockCurrentInfo(StockCurrentInfo stockCurrentInfo) {
		this.stockCurrentInfo = stockCurrentInfo;
	}
	public StockInfo getStockInfo() {
		return stockInfo;
	}
	public void setStockInfo(StockInfo stockInfo) {
		this.stockInfo = stockInfo;
	}
	
	
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getSellDate() {
		return sellDate;
	}
	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}
	public float getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
	}
	public float getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(float sellPrice) {
		this.sellPrice = sellPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public Trader getTrader() {
		return trader;
	}
	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public float getTriggerPrice() {
		return triggerPrice;
	}
	public void setTriggerPrice(float triggerPrice) {
		this.triggerPrice = triggerPrice;
	}
	

}
