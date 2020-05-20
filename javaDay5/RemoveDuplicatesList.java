package javaDay5;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesList {

	public static void main(String[] args) {
		
//		1. How to remove duplicates from a list? 
//				List = "A,B,C,D,A,D,E,F"
		
		List<String> L = new ArrayList<String>();
		L.add("A");
		L.add("B");
		L.add("C");
		L.add("D");
		L.add("A");
		L.add("E");
		L.add("F");
		Set<String> s = new LinkedHashSet<String>(L); 
		System.out.println(s);
	}

}
