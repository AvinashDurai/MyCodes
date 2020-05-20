package javDay4;

import java.util.ArrayList;
import java.util.List;

public class PrintList_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Bugatti Chiron";
		List<Character> lst = new ArrayList<Character>();
		for(int i = 0; i < str.length();i++) {
			lst.add(str.charAt(i));
		}
		
		for (Character eachChar : lst) {
			System.out.print(eachChar);
		}
	}

}
