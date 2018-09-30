//Putting all the cards together~

public class Deck {
	
	private Card[] cards;
	private int top = 0; // the index of the top of the deck
	
	public Deck(){
        
		// make a 52 card deck here
	    cards = new Card[52];
        
        int current = 0;
        
        for(int j = 1; j < 5; j++){
            for(int k = 1; k < 14; k++){
                
                //new card for every rank and suit combo
                cards[current] = new Card(j, k);
                current++;
            }
        }
    }
	
	public void shuffle(){
        
		// shuffle the deck here
		for(int i = 0; i < 200; i++){
            
            int firstCard = (int)(Math.random() * 52);
            int secondCard = (int)(Math.random() * 52);
            
            Card temp = cards[firstCard];
            cards[firstCard] = cards[secondCard];
            cards[secondCard] = temp;
        }	
	}
	
	public Card deal(){
        
		// deal the top card in the deck
        Card c = cards[top++];
        
        //if top reaches end of deck, reshuffle and reset top
        if (top > 51){
            shuffle();
            top = 0;
        }
        return c;
	}
}
