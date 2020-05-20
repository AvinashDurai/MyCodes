package javaDay5;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates_1 {

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
		Set<String> set = new LinkedHashSet<String>(str);
		System.out.println(set);
	}

}
