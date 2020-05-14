package javapractice;

public class AlphaNumeric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Difficulty level: Medium
//		1. Write a java code to find the sum of the given numbers
//		Input: "asdf1qwer9as8d7"
//		output: 1+9+8+7 = 25
		
		String text="asdf1qwer9as8d7";
		String rep= text.replaceAll("\\D","");
//		System.out.println("Digits alone in the given string " +rep.trim());
//		int total= Integer.parseInt(rep);
//		System.out.println(total);
	    char[] ch= rep.toCharArray();
	    int s=0;
		for (int i=0;i<=ch.length-1;i++)
		{
			if (Character.isDigit(ch[i]))	
			s=s+Character.getNumericValue(ch[i]);
		}
		System.out.println("Sum of digits alone in the given string " +text+ " is " +s); 
	}

}
