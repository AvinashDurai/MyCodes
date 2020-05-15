package javaDay2;

public class CountSpace2 {

	public static void main(String[] args) {
		
		String input = "1. It is Work from Home  not Work for Home";
		int upper =0, lower=0,number=0, space =0;
		char[] charArray = input.toCharArray();
		for (int i = 0; i < charArray.length; i++) 
		{
			if(charArray[i] == ' ')
			{
				space = space+1;
			}
			else if(Character.isUpperCase(charArray[i]))
			{
				upper = upper+1;
			}
			else if(Character.isLowerCase(charArray[i]))
			{
				lower=lower+1;
			}
			else if(Character.isDigit(charArray[i]))
			{
				number = number+1;
			}
		}
		
		System.out.println("UpperCase : "+upper);
		System.out.println("LowerCase : "+lower);
		System.out.println("Number : "+number);
		System.out.println("space : "+space);

	}

}
