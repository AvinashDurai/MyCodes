package javaDay5;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Consumer;

public class RetrieveFromSet_3 {

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
		set.forEach(new Consumer<Integer>() {
			public void accept(Integer eachNum) {
				if (eachNum == 7)
					System.out.println(eachNum);
			}
		});
	}

}
