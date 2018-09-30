// The hand for the user!

import java.util.ArrayList;

public class Player {
    
	private ArrayList<Card> hand; //the player's cards
	private double bankroll = 50.0;
    private double bet;
		
	public Player(){	
        
	    //create a player here
        hand = new ArrayList<Card>();
	}

	public void addCard(Card c){
	    //add the card c to the player's hand
	    hand.add(c);
	}

	public void removeCard(Card c){
	    //remove the card c from the player's hand
	    System.out.println("Not Implemented.");
	    hand.remove(c);
    }
    
    //replaces card at index with card c from deck
    public void replace(int index, Card c){
        hand.set(index, c);
    }
    
    //clears elements of hand
    public void clearHand(){
        hand.clear();
    }
    
    public ArrayList<Card> getHand(){
        return hand;
    }
		
    public void bets(double amt){
        
        //player makes a bet 
        if (amt > 0 && amt < 6){
            bet = amt;
            bankroll -= bet;
        }
    }

    public void winnings(double odds){
        //adjust bankroll if player wins
        bankroll += bet * odds;
    }

    public double getBankroll(){
        //return current balance of bankroll
        return bankroll;
    }
}
