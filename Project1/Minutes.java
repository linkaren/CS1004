import java.util.Scanner;

public class Minutes{
    
    public static void main(String[] args){
        
        //your code here
        Scanner fred;
        fred= new Scanner(System.in);
        
        System.out.println("Hello!!! Welcome to your minutes calculator!!");
        System.out.println("************************************************");
        
        System.out.println("Please enter an integer number of years:");
        int years = fred.nextInt();
        
        System.out.println("Now, enter an integer number of weeks:");
        int weeks = fred.nextInt();
        
        System.out.println("Next, enter an integer number of days:");
        int days = fred.nextInt();
        
        System.out.println("And finally, enter an integer number of hours:");
        int hours = fred.nextInt();
        
        // now do calculations
        int weeksLeft = years * 52;
        int weeksTotal = weeksLeft + weeks;
        int daysLeft = weeksTotal * 7;
        int daysTotal = daysLeft + days;
        int hoursLeft = daysTotal * 24;
        int hoursTotal = hoursLeft + hours;
        int minutes = hoursTotal * 60;
        
        //Now present results
        System.out.println("That is a total of " + minutes + " minute(s)!!!");
        
    } //IDIDIT
}
