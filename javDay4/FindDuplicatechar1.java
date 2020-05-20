package javDay4;

import java.util.Arrays;

public class FindDuplicatechar1 {

	public static void main(String[] args) {
		String str = "When life gives you lemons, make lemonade";
		char[] ch = str.toCharArray();
		int length = ch.length;
		//Arrays.sort(ch);
		System.out.println(ch);
		for(int i=0;i<length-1;i++) {
			//if(ch[i]==ch[i+1]);
			System.out.println(ch[i]);
	}

}
}