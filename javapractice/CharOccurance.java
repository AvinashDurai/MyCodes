package javapractice;

public class CharOccurance {

	public static void main(String[] args) {
		
		//1. Write a Java Program to find the occurance of the character 'o' in the following String.
		//Input: "You have no choice other than following me!"
			//output: Occurance of o is: 6
		String str="You have no choice other than following me!";
		char[] ch = str.toCharArray();
		int count=0;
		for(int i=0;i<ch.length;i++) {
			if(ch[i]=='o') {
				count=count+1;
			}
		}
		System.out.println("Occurance of o is :"+ count);
	}

}
