package javapractice;

public class CharOccurance2 {

	public static void main(String[] args) {
		String str="You have no choice other than following me!";
		String replacedstring = str.replaceAll("[^o]", "");
		System.out.println("Occurancce of o is :" + replacedstring.length());

	}

}
