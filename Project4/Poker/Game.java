//Playing the game

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Game {
	
	private Player p;
	private Deck cards;
    private Scanner input;
    private int highestHand;
    private boolean tester;
    private int counter;
    private int amount;
    private int payout;
    private String answer;
	
	public Game(String[] testHand){
		//this constructor is to help test your code
		//use the contents of testHand to
		//make a hand for the player
        p = new Player();
        input = new Scanner(System.in);
        tester = true;
        
        //for each element of testHand create a new card
        //corresponding to the letter(suit) and number(rank)
        for (int i = 0; i < 5; i++){
            
            int value = Integer.parseInt(testHand[i].substring(1));
            
            if (testHand[i].charAt(0) == 'c') {
                     p.addCard(new Card(1, value));
            }
            if (testHand[i].charAt(0) == 'd') {
                     p.addCard(new Card(2, value));
            }
            if (testHand[i].charAt(0) == 'h') {
                     p.addCard(new Card(3, value));
            }
            if (testHand[i].charAt(0) == 's') {
                     p.addCard(new Card(4, value));
            }
        }
    }
	
	public Game(){
        
		//this no-argument constructor is to actually play a normal game	
		p = new Player();
        cards = new Deck();
        input = new Scanner(System.in);
        tester = false;
	}
	
    public boolean getTester(){
        return tester;
    }
    
	public void play(){
		//this method should play the game
		
		//play method for Game(testerHand)
		if(getTester() == true){
            
            System.out.println("Your cards are: " + p.getHand());
            System.out.println(checkHand(p.getHand()));
        }
       
        //play method
        else{
            System.out.println("Welcome to Poker!!!!!");
            System.out.println("***********************************");
            System.out.println("Starting bankroll is " + 
                               p.getBankroll() + " tokens.");
            
            //sets continueGame to yes
            int continueGame = 0;
            
            cards.shuffle();
            
            //while player wants to continue game 
            //and has more than 0 tokens
            while (continueGame == 0 && p.getBankroll() > 0){
                
                highestHand = 0;
                
                //sets bet
                System.out.println("How many tokens would you like" +
                                   "to bet? 1-5");
                amount = input.nextInt();
                p.bets(amount);
                
                //deals 5 cards into player's hand
                for (int i = 0; i < 5; i++){
                    p.addCard(cards.deal());
                }
                  
                //asks player if they want to replace any cards
                System.out.println("Your initial cards are: "
                                   + p.getHand());
                redraw(p.getHand());
                
                System.out.println(checkHand(p.getHand()));
                
                //adjusts bankroll and clears player's hand
                p.winnings(payout);
                System.out.println("Current bankroll is " + p.getBankroll() 
                                   + " tokens.");
                p.clearHand();
                
                //if player has no more tokens
                if (p.getBankroll() <= 0){
                    System.out.println("Game over! No more tokens!");
                    System.out.println("Thanks for playing!");
                }
                
                //else player has tokens
                else{
                    System.out.println("Continue with the game? y/n");
                    answer = input.next();
                
                    //if player wants to end game
                    if (answer.equals("n")){
                    
                        continueGame = 1;
                        
                        System.out.println("You've chosen to end the game.");
                        System.out.println("Final bankroll is " + 
                                           p.getBankroll() + " tokens.");
                        System.out.println("Thanks for playing!");
                    }
                    //else game continues
                    else{
                        continueGame = 0;
                    }
                } 
            }
        }
    }
    
    //method to replace player's cards as requested
    public void redraw(ArrayList<Card> hand){ 
        
        for (int i = 0; i < hand.size(); i++){
            
            System.out.println("Would you like to replace the " +
                               hand.get(i) + " ? y/n");
            String answer = input.next();
            
            if (answer.equals("y")){
                p.replace(i, cards.deal());
            }
        }
    }
    //checks for royal flush
    public void royalFlush(ArrayList<Card> hand){
        
        if (highestHand == 0){
            counter = 0;
            
            for (int i = 1; i < hand.size(); i++){
                //if all same suit
                if(hand.get(0).pairsSuit(hand.get(i)) == 1){
                    counter++;
                }
            }
            //if ace, 10, jack, queen, king
            if (hand.get(0).getRank() == 1 && hand.get(1).getRank() == 10 
                && hand.get(2).getRank() == 11 && hand.get(3).getRank() == 12
                && hand.get(4).getRank() == 13 && counter == 4){
                
                highestHand = 1;
            }
        }
    }
    
    //checks for straight flush
    public void straightFlush(ArrayList<Card> hand){
        
        if (highestHand == 0){
            counter = 0;
            int counter2 = 0;
            
            for (int i = 1; i < hand.size(); i++){
                //if all same suit
                if(hand.get(0).pairsSuit(hand.get(i)) == 1){
                    counter++;
                }
                
                for (int j = i + 1; j < hand.size(); j++) {
                    //if no pairs
                    if (hand.get(j).pairsRank(hand.get(i)) == 1) {
                        counter2++;
                    }
                }
            } 
            //if, when ordered, last # - first # = 4
            if (hand.get(4).getRank() - hand.get(0).getRank() == 4
               && counter == 4 && counter2 == 0){
                
                highestHand = 2;
            }
        }
    }
	
    //checks for four of a kind
    public void fourOfAKind(ArrayList<Card> hand){
        
        if (highestHand == 0){
            counter = 0;
            
            for (int i = 0; i < hand.size(); i++) {
                for (int j = i + 1; j < hand.size(); j++) {
                    
                    if (hand.get(j).pairsRank(hand.get(i)) == 1) {
                        counter++;
                    }
                }
            }
            //if i = j six times
            if (counter == 6) {
                highestHand = 3;
            } 
        } 
    }
    
    //checks for full house
    public void fullHouse(ArrayList<Card> hand){
        
        if (highestHand == 0){
            counter = 0;
            
            for(int i = 0; i <= 4; i++){
                for(int j = i + 1; j <= 4; j++){
                
                    if(hand.get(i).pairsRank(hand.get(j)) == 1){
                        counter++;
                    }
                }
            }
            //if i = j four times
            if(counter == 4){
                highestHand = 4;
            }
        }
    }
    
    //checks for flush
    public void flush(ArrayList<Card> hand){
        
        if (highestHand == 0){
            counter = 0;
            
            for (int i = 1; i < hand.size(); i++){
                //if all same suit
                if(hand.get(0).pairsSuit(hand.get(i)) == 1){
                    counter++;
                }
            }
            if(counter == 4){
                highestHand = 5;
            }
        }
    }
    
    //checks for straight
    public void straight(ArrayList<Card> hand){

        if (highestHand == 0){
            counter = 0;
            
            for (int i = 0; i < hand.size(); i++) {
                for (int j = i + 1; j < hand.size(); j++) {
                    //if no pairs
                    if (hand.get(j).pairsRank(hand.get(i)) == 1) {
                        counter++;
                    }
                } 
            }
            //if, when ordered, last # - first # = 4
            //or if ace, 10, jack, queen, king
            if ((counter == 0 && hand.get(4).getRank() - 
                hand.get(0).getRank() == 4) || (hand.get(0).getRank() == 1
                && hand.get(1).getRank() == 10 && hand.get(2).getRank() == 11
                && hand.get(3).getRank() == 12 && hand.get(4).getRank() == 13)){
                    
                highestHand = 6;
            }
        } 
    }
    
    //checks for three of a kind
    public void threeOfAKind(ArrayList<Card> hand){
        
        if (highestHand == 0){
            counter = 0;
            
            for (int i = 0; i < hand.size(); i++) {
                for (int j = i + 1; j < hand.size(); j++) {
                    
                    if (hand.get(j).pairsRank(hand.get(i)) == 1) {
                        counter++;
                    }
                }
            }
            //if i = j three times
            if (counter == 3) {
                highestHand = 7;
            } 
        } 
    }
    
    //checks for two pairs
    public void twoPairs(ArrayList<Card> hand){
        
        if (highestHand == 0){
            counter = 0;
            
            for(int i = 0; i <= 4; i++){ 
                for(int j = i + 1; j <= 4; j++){
                    
                    if(hand.get(i).pairsRank(hand.get(j)) == 1){
                        counter++;
                    }
                }
            }
            //if i = j two times
            if(counter == 2){
                highestHand = 8;
            }
        }
    }
    
    //checks for one pair
    public void onePair(ArrayList<Card> hand){
        
        if (highestHand == 0){
            counter = 0;
            
            for (int i = 0; i < hand.size(); i++) {
                for (int j = i + 1; j < hand.size(); j++) {
                    
                    if (hand.get(j).pairsRank(hand.get(i)) == 1) {
                        counter++;
                    }
                }
            }
            //if i = j one time
            if (counter == 1) {
                highestHand = 9;
            } 
        }
    }
    
    //checks for no pair
    public void noPair(ArrayList<Card> hand){
        if (highestHand == 0){
            counter = 0;
            
            for (int i = 0; i < hand.size(); i++) {
                for (int j = 1 + 1; j < hand.size(); j++) {
                    
                    if (hand.get(j).pairsRank(hand.get(i)) == 1) {
                        counter++;
                    }
                }
            }
            if (counter == 0) {
                highestHand = 10;
            } 
        } 
    }
               
	public String checkHand(ArrayList<Card> hand){
		//this method should take an ArrayList of cards
		//as input and then determine what evaluates to and
		//return that as a String 
		
		//sorts hand   
		Collections.sort(hand);
        System.out.println("Your sorted final cards are: " + hand);
        
        //goes through all possible hand methods
        royalFlush(hand);
        straightFlush(hand);
        fourOfAKind(hand);
        fullHouse(hand);
        flush(hand);
        straight(hand);
        threeOfAKind(hand);
        twoPairs(hand);
        onePair(hand);
        noPair(hand);
        
        //returns hand as string for corresponding highestHand
        if (highestHand == 1){
            payout = 250;
            return "Royal Flush";
        }
        
        else if (highestHand == 2){
            payout = 50;
            return "Straight Flush";
        }
        
        else if (highestHand == 3){
            payout = 25;
            return "Four of a Kind";
        }
        
        else if (highestHand == 4){
            payout = 6;
            return "Full House";
        }
        
        else if (highestHand == 5){
            payout = 5;
            return "Flush";
        }
        
        else if (highestHand == 6){
            payout = 4;
            return "Straight";
        }
        
        else if (highestHand == 7){
            payout = 3;
            return "Three of a Kind";
        }
        
        else if (highestHand == 8){
            payout = 2;
            return "Two Pairs";
        }
        
        else if (highestHand == 9){
            payout = 1;
            return "One Pair";
        }  
        else {
            payout = 0;
            return "No Pair";
        }
	}
}
