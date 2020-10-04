package javDay4;

import java.util.*;

public class PrintList_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Bugatti Chiron";
		List<String> lst = new ArrayList<String>();
		lst.add(str);
		for (String e: lst) {
			System.out.print(lst);
		}
	}

}
