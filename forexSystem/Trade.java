package forexSystem;

import java.util.Scanner;

public class Trade {
	
	private String name;
	private String currencyPair ;
	private double amount;
	private float rate = 66.00f;
	private double totalAmt;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name.toUpperCase();
	}
	
	public String getCurrencyPair() {
		return currencyPair;
	}
	
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair.toUpperCase();
	}
	
	public double getAmount() {
		return amount;
	}
	
	public double getTotalAmt() {
		return totalAmt;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public float getRate() {
		return rate;
	}

   
	
	// Taking all Information of trader	
	
	public String takeTraderInfo() {
		Scanner sc  = new Scanner(System.in);
		
        // taking trader Data 
		TradeUtil.takeTraderData(sc, this);		
		
		System.out.println("Do You Want to Get Rate(Yes/No) ");
 		//sc.nextLine();
		totalAmt = getRate()*getAmount();
		TradeUtil.showRate(sc.nextLine(),this,sc);
		
//		System.out.println(totalAmt);
			
		// Do book or cancel trade 
		if(!TradeUtil.bookingOrCancel(sc,this)) {
			return "";
		}
		
		return "success";
	}

}
