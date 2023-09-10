package forexSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class TradeUtil {
	
	// Take trader data
	public static void takeTraderData(Scanner sc,Trade t) {
		while(true) {
		System.out.println("-------------------------------------------------------------------------");	
		System.out.println("Book trade Started ");
		
		boolean bool;	
		do {
		  bool =false;
		  System.out.println("Enter Customer Name= ");
	   	  t.setName(sc.nextLine());
	
		if( t.getName().trim().isEmpty()|| !TradeValidation.isString(t.getName())) {
			System.out.println("Enter valid Customer Name ");
			bool =true;
			break;	 // exit from inner do-while loop
		}
		
		System.out.println("Enter Currency Pair(USDINR) = ");
        t.setCurrencyPair(sc.nextLine()); 
        
        if( t.getCurrencyPair().trim().isEmpty() || !TradeValidation.isString(t.getCurrencyPair())|| !t.getCurrencyPair().equalsIgnoreCase("USDINR") ){
        	System.out.println("Please enter Only USDINR \n");
			bool =true;
			break; //exit from inner do-while loop
		}
        
        System.out.println("Enter Amount to transfer = ");
                           
         String temp = sc.nextLine();
         
         if(TradeValidation.isValidNumber(temp)) {
        	double d = Double.parseDouble(temp);
        	t.setAmount(d);
        	
        	if(t.getAmount()<1) {
    			System.out.println("Enter Positive Number and greater than 0 \n");
    			bool =true;
    			break;	// break loop after getting less valid number
    		}
          }
          else  {	
        	System.out.println("Enter valid Amount \n");
//			sc.nextLine();
			bool = true;
			break;
	
        }			
		}while(bool);
		
		if(!bool)
		   break;
		}
	}

	// Book and Cancel Function
	public static boolean bookingOrCancel(Scanner sc,Trade trade) {  
		boolean bool=false;
		do {
			System.out.println("Book/Cancel this trade?");
			
			String bookCancel =sc.nextLine(); 
			
			if(bookCancel.trim().equalsIgnoreCase("Book")) {
				System.out.println("Trade should be booked and confirmation to be displayed as below ");
			    System.out.println("Trade for USDINR has been booked with rate " + trade.getRate() +" , The amount of Rs "+trade.getTotalAmt()  +" will  be transferred in 2 working days to "+ trade.getName()+"\n\n");
			    
			    bool =false; // for terminate do-while loop
			}
			else if(bookCancel.equalsIgnoreCase("Cancel")){
				System.out.println("Trade is Canceled... \n");
				
				//inform caller
				return false;
			}
			else {
				System.out.println("Enter book or cancel\n");
				bool=true;		//maintains loop life
				 
			}
			}while(bool);
		
		  return true; //it ensures confirmation booking of trade
	}
	
	
	// This function is used for 3rd operation
	
	public static void exitSystem(Scanner sc) {
		boolean f = false;
		
		do {
		   System.out.println("Do you really want to exit (y/n)? ");
//		   sc.nextLine();
		   String ch = sc.nextLine();
		   
		   if(ch.equalsIgnoreCase("y")) {
			System.out.println("Bye - have a good day");
			System.exit(0);
		   }
		   
		   else if(ch.equalsIgnoreCase("n")) {
			   System.out.println();
			   break;  //Show supported Operations (i.e starter)
		   }
		   else {
                System.out.println("Enter Valid Input (y or n) \n");
                f = true; //maintain life of do-while 
		  }
		}while(f);
		
	}
	
	// This function is used for 2rd operation
	
	public static void printTradeData( ArrayList<Trade> list) {
		
		if(list.size()== 0) {
			System.out.println("No trade found");
		}
		else {
			System.out.println("Your total Trade= " +list.size()+"\n");
			System.out.println("Trade No.\t"+"Currency Pair\t"+"Customer Name\t\t\t"+"Amount\t\t"+"Rate");
		    int tradeNo =1;
			for(Trade t: list) {
				System.out.println((tradeNo++) +"\t\t"+t.getCurrencyPair()+"\t\t"+t.getName()+"\t\t"+t.getTotalAmt()+"\t\t"+ t.getRate());
			}
		}
	}
	
	//Logic for Show Rate of Exchange
	
	public static void showRate(String isWantGetRate,Trade trade,Scanner sc) {
		 boolean flag;
		 do {
			 flag =false;
			 
		     if(isWantGetRate.equalsIgnoreCase("no")) {
			  System.out.println();
			  break; //loop terminating here
		     }
		     else if(isWantGetRate.equalsIgnoreCase("yes")) {
					System.out.println("Rate is= "+ trade.getRate());
					System.out.println("You are transfering INR "+ trade.getTotalAmt()+ " to "+ trade.getName()+"\n");
		    	    break; //loop terminating here
		     }
		     else { 	 
			   System.out.println("invalid input");
			   System.out.println("Do You Want to Get Rate(Yes/No) ");
			   isWantGetRate =sc.nextLine();
			   flag =true;	  
		}
	}while(flag);		 
}

}
