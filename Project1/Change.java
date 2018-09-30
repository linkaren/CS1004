import java.util.Scanner;

public class Change{
  
    public static void main(String[] args){

        // your code here!
        Scanner fred;
        fred= new Scanner(System.in);
        System.out.println("Hello!!! Welcome to your change calculator!!");
        System.out.println("************************************************");
        
        System.out.println("Please enter the amount due (in pennies!):");
        int amountDue = fred.nextInt();
        
        System.out.println("Now, enter the amount recieved (in pennies, too!):");
        int amountRecieved = fred.nextInt();
        
        //calculations
        int totalChange = amountRecieved - amountDue;
        if (totalChange < 0)
        {
            System.out.println("Sorry, you're too poor, please add more!");
        }
        else if (totalChange == 0)
        {
            System.out.println("You are a blessing, no change needed!");
        }
        else
        {
            int dollars = totalChange / 100;
            int centsLeft = totalChange % 100;
            int quarters = centsLeft / 25;
            centsLeft = centsLeft % 25;
            int dimes = centsLeft / 10;
            centsLeft = centsLeft % 10;
            int nickels = centsLeft / 5;
            centsLeft = centsLeft % 5;
            int pennies = centsLeft;
       
            //results
            System.out.print(totalChange + " cent(s) is your change: " + dollars + " dollar(s), " + quarters + " quarter(s), ");
            System.out.println(dimes + " dime(s), " + nickels + " nickel(s) and " + pennies + " penny(ies)!");
        }
    }
}	
