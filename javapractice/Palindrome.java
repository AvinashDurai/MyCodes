package javapractice;

public class Palindrome {

	public static void main(String[] args) {
//		2. Check for the palindrome of the given string:
//			Input: "malayalam"
//			output: Yes, Palindrome
//			Input: "testleaf"
//			output: No, not a palindrome
		
		// Verify the reverse and orginal are same
		String str = "malayalam";
		// Creating an empty String to store the reversed value
		String rev = "";
		// Iterate over the original string
		for (int i = str.length()-1 ; i >=0; i-- ) {
			rev += str.charAt(i);
		}
		// Condition ? True Statement : False Statement
		System.out.println(str.equals(rev)?"Yes, Palindrome":"No, Not a Palindrome");
		

	}

}
