/* Class to read a dictionary and print out
* words in new file that pass certain methods.
* handles exceptions as well */

import java.util.ArrayList;
import java.io.*;

public class WordLists{
    
    //creates a random access file for dictionary
    private RandomAccessFile dic;

    public WordLists(String fileName) throws IOException{
        
        //declares file as read only
        dic = new RandomAccessFile(fileName, "r");
    }
    
    //method for n length words
    public ArrayList<String> lengthN(int n) throws IOException{
        
        //creates new arraylist for selected words
        ArrayList<String> wordsLengthN = new ArrayList<String>();
        String current;
        
        //while pointer is not past file length
        while(dic.getFilePointer() < dic.length()){
            current = dic.readLine();
            
            if (current.length() == n){
                wordsLengthN.add(current);
            }
        }
        //resets pointer to beginning of file
        dic.seek(0);
        return wordsLengthN;
    }
    
    //method for n length words starting with firstLetter
    public ArrayList<String> startsWith(char firstLetter, int n)
        throws IOException{
        
        ArrayList<String> wordsStartsWith = new ArrayList<String>();
        String current; 
        
        while(dic.getFilePointer() < dic.length()){
            current = dic.readLine();
            
            if (current.length() == n && current.charAt(0) == firstLetter){
                wordsStartsWith.add(current);
            }  
        }
        dic.seek(0);
        return wordsStartsWith;
    }
    
    //method for n length words containing included (not as first letter)
    public ArrayList<String> containsLetter(char included, int n)
        throws IOException{

        ArrayList<String> wordsContainsLetter = new ArrayList<String>();
        String current; 
        
        while(dic.getFilePointer() < dic.length()){
            
            current = dic.readLine();
            int counter = 0;
            
            if (current.length() == n && current.charAt(0) != included){
                
                for (int i = 1; i < current.length(); i++){
                    
                    if (current.charAt(i) == included){
                        counter++;
                    }
                }
                //if contains more than one included
                if(counter >= 1){
                   wordsContainsLetter.add(current); 
                }
            } 
        }
        dic.seek(0);
        return wordsContainsLetter;
    }

    //method for words with included, m times
    public ArrayList<String> multiLetter(char included, int m)
        throws IOException{

        ArrayList<String> wordsMultiLetter = new ArrayList<String>();
        String current; 
        
        while(dic.getFilePointer() < dic.length()){
            
            current = dic.readLine();
            int counter = 0;
                    
            for (int i = 0; i < current.length(); i++){
                        
                if (current.charAt(i) == included){
                    counter++;
                }
            }
            //if contains exactly m included
            if(counter == m){
                wordsMultiLetter.add(current);
            } 
        }
        dic.seek(0);
        return wordsMultiLetter; 
    }
} // end of class
