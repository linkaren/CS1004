// The actual game
 
public class Game{
    
    //Instance variables needed
    private int marbles;
    private Human humanPlayer;
    private Computer computerPlayer;
    private boolean humanTurn;

    //Constructor for Game
    public Game(){
        
        humanPlayer = new Human();
    }
    
    //Takes user input (0 or 1), chooses stupid or smart mode
    private void computerMode(){
        
        if (humanPlayer.chooseComputerMode() == 0){
            
            System.out.println("You chose stupid mode!");
            
            //Instantiates new computer with mode as stupid
            computerPlayer = new Computer(0);
        }
        
        else{
            System.out.println("You chose smart mode!");
            
            //Instantiates new computer with mode as smart
            computerPlayer = new Computer(1);
        }
    }
    
    //Decides who goes first
    private void setFirstMove(){
        
        double setFirstMove = Math.random();
        
        if (setFirstMove < 0.5){
            humanTurn = true;
        }
        
        else{
            humanTurn = false;
        }
    }
    
    //Move for human
    private void playHuman(){
                     
        humanPlayer.move();

        if (humanPlayer.getChoice() >= 1 && 
            humanPlayer.getChoice() <= marbles / 2){
            
            marbles = marbles - humanPlayer.getChoice();
            System.out.println("There are(is) " 
                + marbles + " marble(s) now!");
            
            humanTurn = false;
        }
        
        else{
            System.out.println("That is an invalid input. Try again!");
        }
    }
    
    //Move for computer
    private void playComp(){
        
        computerPlayer.move(marbles); 
        
        System.out.println("The computer took " 
            + computerPlayer.getChoice() + " marble(s).");
        marbles = marbles - computerPlayer.getChoice();
        System.out.println("There are(is) " + marbles + " marble(s) now!");
        
        humanTurn = true;
    }
    
    //Play that combines all the above methods
    public void play(){
        
        computerMode();
        setFirstMove();
        
        marbles = (int)(Math.random() * 91) +10;
        System.out.println("Starting pile is " + marbles + " marbles!");
        
        while(marbles > 1){
            
            if (humanTurn){ //Boolean for if human goes first
                playHuman();
            }
            
            else{
                playComp();
            }
        }
        
        //Winning moment - when only one marble left
        //other player must take it and lose
        if (marbles <= 1 && !humanTurn){
            System.out.println("Computer takes the last marble. YOU WIN!");
        }
        
        else{
            System.out.println("You take the last marble. YOU LOSE!");
        }
    }
}
