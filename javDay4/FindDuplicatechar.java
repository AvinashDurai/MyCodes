package javDay4;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindDuplicatechar {

	public static void main(String[] args) {
//		1. Write a java program to print the duplicate character using Collections Framework.
//		Input: "When life gives you lemons, make lemonade"

		Set<Character> set = new LinkedHashSet<Character>();
		String str = "When life gives you lemons, make lemonade";
		for (int i = 0; i < str.length(); i++) {
			if(!set.add(str.charAt(i))) {
				System.out.print(str.charAt(i)+",");
			}
		}
	}

}
