package forexSystem;

import java.util.ArrayList;

import java.util.Scanner;

public class FXSystem {

	public static void main(String[] args) {
		System.out.println("-------------------------------------------------------------------------");	
		System.out.println("******Welcome To Forex Exchange *******\n");
		Scanner sc = new Scanner(System.in);
		ArrayList<Trade> list = new ArrayList<>();
		
		int choice=0;
		boolean flag;
//		int count =0;
//		int can=0;
	  	
		do {
			
			flag=false;
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Book Trade  1");
			System.out.println("Print Trade 2");
			System.out.println("Exit  3\n");
			System.out.println("Please Select a choice");
			
			String tempchoice = sc.nextLine();
			
			if(TradeValidation.isValidNumber(tempchoice)) {
				 choice = Integer.parseInt(tempchoice);
			}
			
			else {
				System.out.println("Enter Only Integer for choice ."+"\n");
				flag = true;
			}
				

			
			if(!flag) {
				
			 switch(choice) {
			 case 1:
				 Trade trade = new Trade();
				 
				 if(trade.takeTraderInfo().equals("success"))
					 list.add(trade);
				 flag =true;
				 break;
				 
			 case 2:
				 TradeUtil.printTradeData(list);
				 flag =true;
				 break;
				 
			 case 3:
				 TradeUtil.exitSystem(sc);
				 flag =true;
				 break;
				 
			default:
				flag =true;
				System.out.println("Please select only above Mentioned choices...\n");		 

		 }
     	}	
		}while(flag);				
}
}
