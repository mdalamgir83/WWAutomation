package test;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class NthSmallestNumber {

	public static void main(String[] args) {
	    Random randomNumber = new Random(); 
	    int[] numbersArray = new int[500]; 
	    int nth = 0;
	    
	    for (int a = 0; a< numbersArray.length; a++) {
	    	numbersArray[a] = randomNumber.nextInt(); //storing 500 random numbers in an numbersArray, can set desire number range using nextInt() 
	    }
	    System.out.println("\nRandom numbers: " + Arrays.toString(numbersArray)); // print all 500 random numbers  
	    
	    // ask user to input nth number
	    Scanner input = new Scanner(System.in);
	    do { 
	        try {
	        	System.out.println("\nPlease enter the nth number between 1 to 500 that you like to see");
	        	nth = input.nextInt();
	        } catch(InputMismatchException exception) {
	        	System.out.println("Wrong Input"); 			//when user put anything other than integer
	        }
	    } while (nth <= 0 || nth > 500);
      
	    findNthSmallest(numbersArray, nth);
	}
	//find the nth smallest number  
	public static void findNthSmallest(int[] array, int n) {
	    Arrays.sort(array);
	    System.out.println("\nAfter Ascending:  " + Arrays.toString(array));
	    System.out.println(n + "th smallest number: " +array[n-1]);
	     
	    //System.out.println("largest: " + array[array.length - 1]);
	    //System.out.println("smallest: " + array[0]);
	}
	
	
}
