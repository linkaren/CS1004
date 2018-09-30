//Test to see if cards shuffle and deal correctly!

public class TestCard {
    
    public static void main(String[] args){
        
        Deck d = new Deck();
        
        for(int i = 0; i < d.getCards().length; i++){
            Card newCard = d.getCards()[i];
            System.out.println(newCard);
        }
        
        System.out.println("************************");
        
        d.shuffle();
        
        for(int i = 0; i < d.getCards().length; i++){
            Card newCard = d.getCards()[i];
            System.out.println(newCard);
        }
        
        System.out.println("************************");
        
        for (int i = 0; i < 5; i++){
        System.out.println(d.deal());
        }
    }
}
