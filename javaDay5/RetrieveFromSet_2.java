package javaDay5;

import java.util.LinkedHashSet;
import java.util.Set;

public class RetrieveFromSet_2 {

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
		for (Integer eachNum : set) {
			if(eachNum == 7) {
				System.out.println(eachNum);
			}
		}
	}

}
