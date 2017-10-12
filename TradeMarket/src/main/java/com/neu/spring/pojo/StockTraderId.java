package com.neu.spring.pojo;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class StockTraderId {
	private StockInfo stockInfo;
	private Trader trader;
	@ManyToOne
	public StockInfo getStock() {
		return stockInfo;
	}

	public void setStock(StockInfo stockInfo) {
		this.stockInfo = stockInfo;
	}

	@ManyToOne
	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockTraderId that = (StockTraderId) o;

        if (stockInfo != null ? !stockInfo.equals(that.stockInfo) : that.stockInfo != null) return false;
        if (trader != null ? !trader.equals(that.trader) : that.trader != null)
            return false;

        return true;
    }
	public int hashCode() {
        int result;
        result = (stockInfo != null ? stockInfo.hashCode() : 0);
        result = 31 * result + (trader != null ? trader.hashCode() : 0);
        return result;
    }

	

}
