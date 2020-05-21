package javaDay6;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PrintMap_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1. Write a Java Program to print the keys and values from the Map
//		map = {A=1, B=2, C=3, D=4, E=5}
//		(Min 3 ways)
//		Note: Even if you google understand what you are doing!
		
		Map <String, Integer> map= new HashMap<String, Integer>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put("D", 4);
		map.put("E", 5);
		for (Entry<String, Integer> eachentry : map.entrySet()) {
			System.out.println(eachentry.getKey()+"-->"+eachentry.getValue());
		}
		
	}

}
