/**
 * This program determines the correct article to use for different
 * countries.
 * 
 * @author: <Karen Lin>
 * @date: <02/02/18>
 */

import java.util.Scanner;

public class Pays{

    public static void main(String[] args){

        // your code here!
        Scanner fred;
        fred = new Scanner(System.in);
        
        System.out.println("Hello!!! Welcome to your French Country Article Calculator!!");
        System.out.println("************************************************");
        
        System.out.println("Please enter a name of a country in French (don't forget to capitalize!):");
        String name = fred.nextLine();
        char firstLetter = name.charAt(0);
        char lastLetter = name.charAt(name.length() - 1);
        
        //computations
        if (name.equals("Etats-Unis") || name.equals("Pays-Bas"))
        {
            System.out.print("The correct French format for this country would be: ");
            System.out.println("les " + name);
        }
        else if (name.equals("Belize") || name.equals("Cambodge") || name.equals("Mexique") || name.equals("Mozambique") || name.equals("Zaire") || name.equals("Zimbabwe"))
        {
            System.out.print("The correct French format for this country would be: ");
            System.out.println("le " + name);
        }
        else if (firstLetter == 'A' || firstLetter == 'E' || firstLetter == 'I' || firstLetter == 'O' || firstLetter == 'U')
        {
            System.out.print("The correct French format for this country would be: ");
            System.out.println("l'" + name);
        }
        else if (lastLetter == 'e')
        {
            System.out.print("The correct French format for this country would be: ");
            System.out.println("la " + name);
        }
        else
        {
            System.out.print("The correct French format for this country would be: ");
            System.out.println("le " + name);
        }  
    }
}
