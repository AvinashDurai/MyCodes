package javaDay7;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CharCount1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Avinash";
		// Creating a HashMap containing char 
        // as a key and occurrences as  a value 
		HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
		
		// Converting given string to char array		  
        char[] strArray = str.toCharArray(); 
        
     // checking each char of strArray 
        for (char c : strArray) { 
            if (map.containsKey(c)) { 
  
                // If char is present in charCountMap, 
                // incrementing it's count by 1 
            	Integer value = map.get(c);
            	map.put(c, value+1); 
            }
            	else { 
            		  
                    // If char is not present in charCountMap, 
                    // putting this char to charCountMap with 1 as it's value 
                    map.put(c, 1); 
                } 
         // Printing the charCountMap 
//            for (Map.Entry entry : map.entrySet()) { 
//                System.out.println(entry.getKey() + " " + entry.getValue()); 
            for (Entry<Character, Integer> entry : map.entrySet()) {
            	System.out.print(entry.getKey()+ "=" +entry.getValue());
            }
				
			}
            } 
            } 
            
		

	

