package com.finzly.sateesh.fxTrading.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FxTrade {
    
	@Id
	private  int  tradeId; 
	private String customerName;
	private String currencyPair ;
	private double amount;
	private float rate = 66.00f;
	
	private double totalAmt;
	
	@Column(columnDefinition = "BOOLEAN")
	private boolean isBooked;
	
	public FxTrade() {}
		
	public FxTrade(int tradeId, String customerName, String currencyPair, double amount) {
		super();
		this.tradeId = tradeId;
		this.customerName = customerName;
		this.currencyPair = currencyPair;
		this.amount = amount;
		this.isBooked = false;
	}

	public int gettradeId() {
		return tradeId;
	}

	public void settradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName =customerName;
	}
	public String getCurrencyPair() {
		return currencyPair;
	}
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public float getRate() {
		return rate;
	}
	
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = amount*rate;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	@Override
	public String toString() {
		return "FxTrade [tradeId=" + tradeId + ",customerName=" +customerName + ", currencyPair=" + currencyPair + ", amount=" + amount
				+ ", rate=" + rate + ", totalAmt=" + totalAmt + "]";
	}

	 
	
	
	
	
}
