/* Checks an manually inputed string of 
* numbers to see if its a valid credit card!
*/

public class CreditCard {

	private String number; // The number is stored as a string
	private boolean valid; // Boolean IV indicating valid or not
    private int firstDigit; // Necessary digit variables
    private int fourthDigit;
    private int fifthDigit;
    private int ninthDigit;
    private int errorCode; // Integer giving errorCode
	
	// Initializes the instance variables: number and valid
	// This class assumes that the String n is formatted correctly. 
	public CreditCard(String n){
        
		number = n;
		valid = true;
        errorCode = 0;
        firstDigit = Integer.parseInt(number.substring(0,1));
        fourthDigit = Integer.parseInt(number.substring(3,4));
        fifthDigit = Integer.parseInt(number.substring(4,5));
        ninthDigit = Integer.parseInt(number.substring(8,9));
	}
	
	// Method to check if 1st digit = 4
	private void check1(){
        
		if (firstDigit != 4){
            valid = false;
            errorCode = 1;
        }
	}
	
	// Method to check if 4th digit > 5th digit by 1
	private void check2(){
        
        // All methods past the first rule check to see
        // if errorCode is still 0 or not; if not skips respective method
        if(errorCode == 0){
            
            if (!(fourthDigit == fifthDigit + 1)){
                valid = false;
                errorCode = 2;
            }
        }
	}
	
    // Method to check if product of 1st, 5th, and 9th digits = 24
	private void check3(){
        
        if (errorCode == 0){
            
            if (firstDigit * fifthDigit * ninthDigit != 24){
                valid = false;
                errorCode = 3;
            }
        }
	}
       	
    // Method to check if sum of all digits is evenly divisible by 4
	private void check4(){
        
        if (errorCode == 0){
            int sum = 0;
        
            for(int i = 0; i < number.length();){
                sum += Integer.parseInt(number.substring(i, ++i));
            }
        
            if (sum % 4 != 0){
                valid = false;
                errorCode = 4;
            }
        }
	}
	
    // Method to check if sum of first four digits = 
    // sum of last four digits - 1
	private void check5(){
        
        if (errorCode == 0){
            
            int firstSum = 0;
            int lastSum = 0;
            String firstFour = number.substring(0,4);
            String lastFour = number.substring(8,12);
        
            for(int i = 0; i < firstFour.length();){
                firstSum += Integer.parseInt(firstFour.substring(i, ++i));
            }
        
            for(int i = 0; i < lastFour.length();){
                lastSum += Integer.parseInt(lastFour.substring(i, ++i));
            }
         
            if (!(firstSum == lastSum - 1)){
                valid = false;
                errorCode = 5;
            }
        }
	}
        
    // Method to check if 1st and 2nd digit # + 7th and 8th digit # = 100
	private void check6(){
        
        if (errorCode == 0){
            
            int firstSecond = Integer.parseInt(number.substring(0,2));
            int seventhEight = Integer.parseInt(number.substring(6,8));
            
            if (firstSecond + seventhEight != 100){
                valid = false;
                errorCode = 6;
            }
        }
	}
    
	// Method to see if the number is valid
	public void check(){
            check1();
            check2();
            check3();
            check4();
            check5();
            check6();
	}
    
	// Accessor method for the IV valid
	public boolean isValid(){
		return valid;
	}
    
    // Accessor for errorCode
    public int getErrorCode(){
        return errorCode;
    }
}
