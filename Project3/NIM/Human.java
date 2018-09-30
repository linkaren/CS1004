//Hooman player

import java.util.Scanner;

public class Human{
    
    //Instance variables
    private int choice;
    private Scanner input;
    
    public Human(){
        
        //Initializes variables
        input = new Scanner(System.in);
        choice = -1;
    }
    
    //User input to choose computer mode (stupid of smart)
    public int chooseComputerMode(){
        
        System.out.println("What computer mode would you like to play?");
        System.out.println("Type 0 for stupid mode and 1 for smart mode.");
        
        int chooseComputerMode = input.nextInt();
        return chooseComputerMode;
    }
    
    //User input for move
    public void move(){
        
        System.out.println("How many marbles would you like to take?");
        choice = input.nextInt();
    }
    
    //Returns final choice for turn
    public int getChoice(){
        return choice;
    }
} // end class  

    
    

