package javapractice;

public class SumofDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text="asdf1qwer9as8d7";
		char[] ch=text.toCharArray();
		int s=0;
		for (int i=0;i<=text.length()-1;i++)
		{
			if (Character.isDigit(ch[i]))
			  s=s+Character.getNumericValue(ch[i]);
		}
		System.out.println("Sum of Digits in asdf1qwer9as8d7 is  "+s);
	}

}
