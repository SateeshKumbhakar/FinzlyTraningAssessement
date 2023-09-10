package forexSystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TradeValidation {
	 
	// String Checker
	public static boolean isString(String input) {
        // Use regular expression to check if the input consists of only letters (no numbers or special characters)
        return input.matches("^[a-zA-Z ]+$");//"^[a-zA-Z ]+$"
 }
	
	//Valid number Checker
	public static boolean isValidNumber(String input) {
	        // Use a regular expression to match a valid number pattern
	        // This regex allows for numbers with or without a decimal point
	        // It also handles numbers in scientific notation (e.g., 1.23e-4)
	        return input.matches("^[-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?$");
	    }
	
	
	// Valid positive Number Checker
	 public static boolean isValidPositiveInteger(String input) {
	        
		    // Define the regex pattern for a positive integer in the range of 1 to 5
	        String regex = "^[1-3]$";

	        // Create a Pattern object
	        Pattern pattern = Pattern.compile(regex);

	        // Create a Matcher object
	        Matcher matcher = pattern.matcher(input);

	        // Use the Matcher to perform the match
	        return matcher.matches();
	    }
}
//*******this code was in valid amount
//	try {
//	t.setAmount(sc.nextDouble());
//} 
//catch (Exception e) {
//	System.out.println("Enter valid Amount \n"+ e);
//	sc.nextLine();
//	bool = true;
//}
	 

//
//		try {
//		
//		
//		 if(count==0 ||can>0 ) {
//			 count++;
//			 choise = sc.nextInt();
//			 flag =false;		 
//		 }
//		 else {
//			 sc.nextLine();
//			 choise = sc.nextInt();
//			 flag =false;
//		 }
//				 
//	}
//	catch(Exception e) {
//		System.out.println("Enter Only Integer for Choise ."+e+"\n");
//		flag = true;
//		
//	}

