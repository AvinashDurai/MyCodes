package javaDay5;

import java.util.HashSet;
import java.util.Set;

public class RetrivefromSet {

	public static void main(String[] args) {

//2. How to retrieve a value from a Set? Set = "1,2,3,4,5,6,7,8,9" retrieve and print only the value - 7
		 Set<String> set = new HashSet<String>();
		 	set.add("1"); 
	        set.add("2"); 
	        set.add("3"); 
	        set.add("4"); 
	        set.add("5"); 
	        set.add("6"); 
	        set.add("7"); 
	        set.add("8"); 
	        set.add("9");
	        System.out.println("Set: " + set); 

	        // Check for "4" in the set 
//	        System.out.println("Does the Set contains '7'? "
//	                           + set.contains("7")); 
	        if(set.contains("7")) {
	        	System.out.println("7");
	        }
		
	}

}
