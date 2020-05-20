package javDay4;

import java.util.ArrayList;
import java.util.List;

public class PrintList_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Bugatti Chiron";
		List<Character> lst = new ArrayList<Character>();
		for(int i = 0; i < str.length();i++) {
			lst.add(str.charAt(i));
		}
		int count = 0;
		while(count<lst.size()) {
			System.out.print(lst.get(count));
			count++;
		}
	}

}
