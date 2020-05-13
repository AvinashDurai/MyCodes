package javapractice;

public class ReverseString {

	public static void main(String[] args) {
		
		String str = "Welcome To USA";
		
		StringBuffer stb = new StringBuffer(str);
		StringBuffer reverse = stb.reverse();
		String rev = reverse.toString();
		
		System.out.println("The reversed String is : " +rev);
		
//		if(rev.equals(str)) {
//			System.out.println("Yes, Palindrome");
//		}
//		else {
//			System.out.println("No, Not a Palindrome");
		//}

	}

}
