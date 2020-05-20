package javaDay5;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RetrieveFromSet_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set = new LinkedHashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(6);
		set.add(7);
		set.add(8);
		set.add(9);
		List<Integer> list = new ArrayList<Integer>(set);
		System.out.println(list.get(6));
	}

}
