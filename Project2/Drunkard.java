// A drunk boi.

public class Drunkard {
    
    // declaring instance variables
    public int initialAvenue;
    public int initialStreet;
    public int currentAvenue;
    public int currentStreet;
    
    public Drunkard(int x, int y) {
        
        // initializing instance variables
        initialAvenue = currentAvenue = x;
        initialStreet = currentStreet = y;
    }
    
    public void step() {
        
        // drawing random number: 1, 2, 3, 4
        int initialDirection = (int) (Math.random() * 4) + 1;
        
        // number is 1: drunkard moves 1 block east
        if (initialDirection == 1) {
            currentAvenue += 1;
        }
        
        // number is 2: drunkard moves 1 block west
        else if (initialDirection == 2) {
            currentAvenue -= 1;
        }
        
        // number is 3: drunkard moves 1 block north
        else if (initialDirection == 3) {
            currentStreet += 1;
        }
        
        // number is 4: drunkard moves 1 block south
        else if (initialDirection == 4) {
            currentStreet -= 1;
        }   
    }    
    
    public void fastForward(int steps) {
        
        // calls step method for each # of steps
        for (int i = 0; i < steps; i++){
            step();
        }  
    }
    
    public String getLocation() {
        
        //returns final location (avenue, street)
        return "(" + currentAvenue + ", " + currentStreet + ")";   
    }
    
    public int howFar() {
        
        // distance calculated by Manhattan distance metric
        return Math.abs(initialAvenue - currentAvenue) 
               + Math.abs(initialStreet - currentStreet);
    }
}
