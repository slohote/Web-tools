package com.neu.spring.pojo;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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

//@Entity
//@Table(name="traderstock")
//@AssociationOverrides({
//	
//	@AssociationOverride(name = "traderstock", 
//		joinColumns = @JoinColumn(name = "trader_ID")),
//	@AssociationOverride(name = "pk_stock", 
//	joinColumns = @JoinColumn(name = "STOCK_ID"))
//
//
//
//})
public class TraderStock {
	
//	private StockTraderId pk = new StockTraderId();
//	
//	
//	@EmbeddedId
//	public StockTraderId getPk() {
//		return pk;
//	}
//
//	public void setPk(StockTraderId pk) {
//		this.pk = pk;
//	}
//
//	@Transient
//	public StockInfo getStockInfo() {
//		return getPk().getStock();
//	}
//
//	public void setStock(StockInfo stock) {
//		getPk().setStock(stock);
//	}
//	
//	@Transient
//	public Trader getCategory() {
//		return getPk().getTrader();
//	}
//
//	public void setTrader(Trader trader) {
//		getPk().setTrader(trader);
//	}
//	
//
//    @Column(name="qtyOwned")
//    private int qtyOwned;
//    
//    @Column(name="activeQty")
//    private int activeQty;
//    
//    
//    public TraderStock()
//    {
//    	
//    }
//	
//	
//
//	
//
//	public int getQtyOwned() {
//		return qtyOwned;
//	}
//	public void setQtyOwned(int qtyOwned) {
//		this.qtyOwned = qtyOwned;
//	}
//	public int getActiveQty() {
//		return activeQty;
//	}
//	public void setActiveQty(int activeQty) {
//		this.activeQty = activeQty;
//	}
//	
//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
//		if (o == null || getClass() != o.getClass())
//			return false;
//
//		TraderStock that = (TraderStock) o;
//
//		if (getPk() != null ? !getPk().equals(that.getPk())
//				: that.getPk() != null)
//			return false;
//
//		return true;
//	}
//
//	public int hashCode() {
//		return (getPk() != null ? getPk().hashCode() : 0);
//	}
//    
}
