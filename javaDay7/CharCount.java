package javaDay7;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Write a java program to find the count of the characters in the given string
//		String str = "Karma is powerful than God"
//		{K=1, a=3, r=2, m=1,  =4, i=1, s=1, p=1, o=2, w=1, e=1, f=1, u=1, l=1, t=1, h=1, n=1, G=1, d=1}
		
		String str="Karma is powerful than God";
		char[] ch = str.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		for (char c : ch) {
			if (map.containsKey(c)) {
				Integer value = map.get(c);
				map.put(c, value+1);
			}else {
				map.put(c, 1);
			}
		}
		
		System.out.println(map);
		

	}

}
