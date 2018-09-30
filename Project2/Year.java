/* Represents a calendar year!
* Is it a leap year??
*/

public class Year {  
    
    // declaring instance variable
    public int givenYear;
    
    // constructor
    public Year(int y) {
        
        // initializing instance variable
        givenYear = y;
    }

    public boolean isLeapYear() {
        
        // for years divisible by 100 but not 400
        if (givenYear % 100 == 0 && givenYear % 400 != 0) {
            return false; 
        }
        
        // for years divisible by 4 and/or 400
        else if (givenYear % 4 == 0 || givenYear % 400 == 0) {
            return true;
        }
        
        // for years that don't fit either the above requirements
        else {
            return false;
        }
    }
}    
