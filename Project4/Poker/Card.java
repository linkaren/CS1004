//Making a poker card and a way to compare them with each other!

public class Card implements Comparable<Card>{
	
	private int suit; //use integers 1-4 to encode the suit
	private int rank; //use integers 1-13 to encode the rank
    private static String[] suitValue = { "Clubs", "Diamonds", 
                                         "Hearts", "Spades" };
    private static String[] rankValue = { "Ace", "2", "3", "4", "5", 
                                         "6", "7", "8", "9", "10", 
                                         "Jack", "Queen", "King" };

	public Card(int s, int r){
		//make a card with suit s and value v
		suit = s;
        rank = r;
	}
	public int compareTo(Card c){
		//use this method to compare cards so they 
		//may be easily sorted
		
        //first sorts by rank
        if (this.rank < c.rank){
            return -1;
        }
        else if (this.rank > c.rank){
            return 1;
        }
        //if ranks are equal, sort by suit
        else{
            if (this.suit < c.suit)
                return -1;
            else if (this.suit > c.suit)
                return 1;
            else
                return 0;
        }
    }
    
    //if ranks are equal
	public int pairsRank(Card c){
        
		if (this.rank == c.rank)
			return 1;
		else
			return 0;
  }
        
    //if suits are equal
	public int pairsSuit(Card c){
        
		if (this.suit == c.suit)        
			return 1;
		else
			return 0;
  }

	public String toString(){
        
		// use this method to easily print a Card object
		return rankValue[rank - 1] + " of " + suitValue[suit - 1];
	}
    
    public int getRank(){
        return rank;
    }
    
    public int getSuit(){
        return suit;
    }
}
