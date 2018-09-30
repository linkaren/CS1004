// prints out results in separate files!

import java.io.*;

public class WordTest{
    
    public static void main(String[] args){
        
        try{
            //creates new WordList
            WordLists myWords = new WordLists("test.txt");
            //creates new PrintWriter for lengthN method
            PrintWriter output1 = new PrintWriter("outputLengthN.txt");
            //creates string of array of selected words
            String result1 = String.join("\n", myWords.lengthN(3));
            
            //prints answer in new text file
            output1.println("Words of length 3:");
            output1.println(result1);
            output1.close();

            //creates new PrintWriter for startsWith method
            PrintWriter output2 = new PrintWriter("outputStartsWith.txt"); 
            String result2 = String.join("\n", myWords.startsWith('b', 4));
            
            output2.println("Words of length 4 that start with 'b':");
            output2.println(result2);
            output2.close();

            //creates new PrintWriter for containsLetter method
            PrintWriter output3 = new PrintWriter("outputContainsLetter.txt"); 
            String result3 = String.join("\n", myWords.containsLetter('e', 5));
            
            output3.println("Words of length 5 that contain 'e' but" +
                            " don't start with it:");
            output3.println(result3);
            output3.close();

            //creates new PrintWriter for multiLetter method
            PrintWriter output4 = new PrintWriter("outputMultiLetter.txt"); 
            String result4 = String.join("\n", myWords.multiLetter('o', 2));
            
            output4.println("Words that contain the letter 'o' 2 times:");
            output4.println(result4);
            output4.close();
        }
        
        //catches IO exception thrown in WordLists.java file
        catch(IOException fred){
            System.out.println("Could not find file :(");
            System.out.println(fred);
        }
    }
}
