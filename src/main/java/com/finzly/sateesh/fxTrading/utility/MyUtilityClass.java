package com.finzly.sateesh.fxTrading.utility;

import com.finzly.sateesh.fxTrading.model.FxTrade;

public class MyUtilityClass {
	
	
//	public static boolean isValidTrade(FxTrade fxTrade) {
//		return    isValidNumber((Double.toString( fxTrade.gettradeId()))) && isString(fxTrade.getCustomerName()) && isValidNumber((Double.toString( fxTrade.getAmount()))) && isString(fxTrade.getCurrencyPair())  &&   fxTrade.getCurrencyPair().equalsIgnoreCase("usdinr") ;
//	}
	public static boolean isString(String input) {
        // Use regular expression to check if the input consists of only letters (no numbers or special characters)
        return input.matches("^[a-zA-Z ]+$");//"^[a-zA-Z ]+$"
 }
	
	//Valid number Checker
	public static boolean isValidNumber(String input) {
	        return input.matches("^[-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?$");
	    }
	

}
