// The computer player! 

public class Computer{
    
    //Instance variables
    private int mode; //Smart or stupid
    private int choice;
    private int marblesResult;
    
    public Computer(int m){
        
        //Initialize variables
        mode = m;
        choice = -1;
    }
    
    public void move(int marblesLeft){
        
        //Computer move for stupid mode
        if (mode == 0){
            choice = (int) (Math.random() * (marblesLeft / 2) + 1);
        }
        
        //Computer move for smart mode
        else{
            
            //When marbles equal a power of two minus one
            if (marblesLeft == 3 || marblesLeft == 7 || marblesLeft == 15
                || marblesLeft == 31 || marblesLeft == 63){ 
                
                //Does random integer between one and marbles/2
                choice = (int) (Math.random() * (marblesLeft / 2) + 1);
            }   
            
            //Takes until marbles left equals a power of two minus one
            else{
                if (marblesLeft > 63){
                    marblesResult = 63;
                }
                
                else if (marblesLeft > 31){
                    marblesResult = 31;
                }
                
                else if (marblesLeft > 15){
                    marblesResult = 15;
                }
                
                else if (marblesLeft > 7){
                    marblesResult = 7;
                }
                
                else if (marblesLeft > 3){
                    marblesResult = 3;
                }
                
                else if (marblesLeft == 2){
                    marblesResult = 1;
                }
                
                choice = marblesLeft - marblesResult;
            }
        }
    }
    
    //Returns final choice for turn
    public int getChoice(){
        return choice;
    }
}
