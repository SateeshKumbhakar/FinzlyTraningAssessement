package com.finzly.sateesh.fxTrading.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency {
	@Id
	private String currencyPair;
	private double rate;

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Currency() {
	}

	@Override
	public String toString() {
		return "Currency [currencyPair=" + currencyPair + ", rate=" + rate + "]";
	}

}
