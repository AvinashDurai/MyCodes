package javaDay5;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> str = new ArrayList<String>();
		str.add("A");
		str.add("B");
		str.add("C");
		str.add("D");
		str.add("A");
		str.add("D");
		str.add("E");
		str.add("F");
		List<String> strDup = new ArrayList<String>(str);
		for (int i = 0; i < str.size(); i++) {
			String eachStr = str.get(i);
			int count = 0;
			for(int j = 0; j < strDup.size(); j++) {
				if(strDup.get(j)==eachStr) {
					count++;
				}
			}
			if(count>1) {
				strDup.remove(eachStr);
			}
		}
		System.out.println(strDup);
	}

}
