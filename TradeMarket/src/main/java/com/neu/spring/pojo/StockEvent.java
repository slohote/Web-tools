package com.neu.spring.pojo;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="stockeventtable")
public class StockEvent {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="eventId", unique = true, nullable = false)
	private long eventId;
	
	@Column(name="date")
	private String date;
	
	@Column(name="eventDescription")
	private String eventDescription;
	
	@Transient //will stored in advert table
    private long stockId;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="stockId")
	private StockInfo stockInfo;
	public StockEvent()
	{
		
	}
	
	public long getStockId() {
		return stockId;
	}

	public void setStockId(long stockId) {
		this.stockId = stockId;
	}

	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public StockInfo getStockInfo() {
		return stockInfo;
	}

	public void setStockInfo(StockInfo stockInfo) {
		this.stockInfo = stockInfo;
	}
	

}
