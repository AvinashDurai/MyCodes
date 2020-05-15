package javaDay2;

public class CountSpace {

	public static void main(String[] args) {
	
		String str = "1. It is Work from Home  not Work for Home";
		
		String strNumbers = str.replaceAll("\\D", "");
		System.out.println(strNumbers);
		System.out.println("No of numbers  = "+strNumbers.length());
		
		String strRemovedSpaces = str.replaceAll(" ", "");
		System.out.println(strRemovedSpaces);
		System.out.println("No of spaces  = "+(str.length()-strRemovedSpaces.length()));
		
		String strRemoveUpperCase = str.replaceAll("[A-Z]", "");
		System.out.println(strRemoveUpperCase);
		System.out.println("No of Upper cases  = "+(str.length() - strRemoveUpperCase.length()));
		
		
		String strRemoveLowerCase = str.replaceAll("[a-z]", "");
		System.out.println(strRemoveLowerCase);
		System.out.println("No of Lower cases  = "+(str.length() - strRemoveLowerCase.length()));

	}

}
