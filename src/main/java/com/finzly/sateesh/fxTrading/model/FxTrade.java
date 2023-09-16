package com.finzly.sateesh.fxTrading.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FxTrade {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int  tradeId ; 
	private String customerName;
	private String currencyPair ;
	private double amount;
	private double totalAmount;
	private String remark;
		
	public FxTrade() {}
	

	public FxTrade(int tradeId, String customerName, String currencyPair, double amount, double totalAmount,String remark) {
		super();
		this.tradeId = tradeId;
		this.customerName = customerName;
		this.currencyPair = currencyPair;
		this.amount = amount;
		this.totalAmount = totalAmount;
		this.remark = remark;
		
	}
	
	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "FxTrade [tradeId=" + tradeId + ", customerName=" + customerName + ", currencyPair=" + currencyPair
				+ ", amount=" + amount  + ", totalAmount=" + totalAmount  + ", remark= " + remark 
				+ "]";
	}
		
	

	 
	
	
	
	
}
