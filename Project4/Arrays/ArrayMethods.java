import java.util.Arrays;
import java.util.ArrayList;

public class ArrayMethods {

	// private instance variables
	private int[] values;
	// this is for resetting purposes, otherwise not needed
	private int[] originalValues; 

	// constructor
	public ArrayMethods(int[] initialValues) {
		values = initialValues;
		originalValues = Arrays.copyOf(values, values.length);
	}

	// pretty printing for testing purposes
	public void printArray() {
		for (int i : values) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	// resetting back to original values for testing purposes
	public void resetValues() {
		values = Arrays.copyOf(originalValues, originalValues.length);
	}

	// a. swap the first and last elements
	public void swapFirstAndLast() {
        
		int temp = values[0];
        values[0] = values[values.length - 1];
        values[values.length - 1] = temp;	
	}

	// b. shift all element to right and wraparound
	public void shiftRight() {
        
        int lastElement = values[values.length - 1];
        
        //for every element, value current takes on the value before
		for (int i = values.length - 1; i > 0; i--){
            
                values[i] = values[i - 1];
        }
        values[0] = lastElement;
	}

	// c. replace even elements with zero
	public void replaceEven() {
        
		for (int i = 0; i < values.length; i++){
            
            if (values[i] % 2 == 0){
                values[i] = 0;
            }
        }
	}

	// d. replace middle elements with larger of two neighbors
	public void replaceMiddle() {
        
        if(values.length > 2){
            
            int tempBefore = values[0];
            int tempAfter = values[2];
            
            for (int i = 1; i <= values.length - 2; i++){
            
                // value before < value after
                if (tempBefore < tempAfter){
                    tempBefore = values[i];
                    values[i] = tempAfter;
                }
            
                // else value before >= value after
                else {
                    int before = values[i];
                    values[i] = tempBefore;
                    tempBefore = before;
                }
            
                // resets tempAfter to 2 values after current value
                if(i < values.length - 2){
                    tempAfter = values[i + 2]; 
                }
            
                // resets tempAfter to 1 value after current value
                else{
                    tempAfter = values[i + 1];
                }
            }
        }
	}

	// e. Remove middle one or two elements
	public void removeMiddle() {
        
        // for odd numbered arrays
		if (values.length % 2 != 0){
            
            for (int i = (values.length / 2) + 1; i < values.length; i++){
                values[i - 1] = values[i];
            }
            // new array without middle number
            values = Arrays.copyOf(values, values.length - 1);
        }
        // for even numbered arrays
        else {
            
            for (int i = (values.length / 2) + 1; i < values.length; i++){
                values[i - 2] = values[i];
            }
            // new array without 2 middle numbers
            values = Arrays.copyOf(values, values.length - 2);
        }
	}

	// f. Move even elements to the front
	public void moveEven() {
		
        int evenEnd = 0;
        
        for (int i = 0; i < values.length; i++){
            
            if (values[i] % 2 == 0){
                
                int temp = values[i];
                
                for (int j = i; j > evenEnd; j--){
                    values[j] = values[j - 1];
                }
                values[evenEnd] = temp;
                evenEnd++;
            }
        }
	}

	// g. Return second-largest element
	public int secondLargest() {
        
        //create identical array
        int[] newValues = Arrays.copyOf(values, values.length);
        
        // insertion sort
		for (int i = 0; i < newValues.length; i++){
            
            int temp = newValues[i];
            int j = i - 1;
            
            while (j >= 0 && temp < newValues[j]){
                newValues[j + 1] = newValues [j];
                j -= 1;
            }
            newValues[j + 1] = temp;
        }
        // returns second largest
        return newValues[values.length - 2];
	}

	// h. Check if sorted in increasing order
	public boolean sortedIncreasing() {

		for (int i = 1; i < values.length; i++){
            
            if (values[i - 1] > values[i]){
                return false;
            }
        }
        return true;
	}

	// i. Check if contains two adjacent duplicate elements
	public boolean adjacentDups() {
		        
		for (int i = 1; i < values.length; i++){
            
            if (values[i - 1] == values[i]){
                return true;
            }
        }
        return false;
	}

	// j. Check if contains any duplicate elements
	public boolean containsDups() {
        
        // duplicate found if value current == value later
        for (int i = 0; i < values.length; i++){
                
            for (int j = i; j < values.length; j++){

                if (i != j && values[i] == values[j]) {
                    return true;
                }
            }
        }
        return false;
	}
}
