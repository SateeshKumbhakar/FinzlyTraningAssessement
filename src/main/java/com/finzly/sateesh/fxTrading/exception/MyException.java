package com.finzly.sateesh.fxTrading.exception;

public class MyException extends Exception {
	public MyException() {}
	
	public MyException(String msg) {
		super(msg);
	}

	public static CurrencyNotFoundExeption  getCurrenypairNotFoundException() throws CurrencyNotFoundExeption {
		 throw new CurrencyNotFoundExeption("This given currency pair is not Found Database List");
	}
	public static DataObjectNotFoundException  getDataObjectNotFoundException() throws DataObjectNotFoundException  {
		throw new DataObjectNotFoundException ("Data Object is not availble in Database");
	}
	
}
