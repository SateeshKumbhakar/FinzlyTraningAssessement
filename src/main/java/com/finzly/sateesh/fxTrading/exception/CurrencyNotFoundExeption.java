package com.finzly.sateesh.fxTrading.exception;

public class CurrencyNotFoundExeption extends MyException{
	
	// No args constructor
	public CurrencyNotFoundExeption() {}
	
	// args constructor
	public CurrencyNotFoundExeption(String msg) {
		super(msg);
	}

}
