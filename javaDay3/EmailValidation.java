package javaDay3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

	public static void main(String[] args) {
//		1. Write a java program to verify whether the given String is valid email address.
//		Input: "balaji.chandrasekaran@testleaf.com"
//		output: true
//		Input: "balaji.c@tunatap.co.uk"
//		output: true
//		Input: "naveen e@tl.com"
//		output: false
//		Note: Spl characters like . _ are only allowed
		
		String email="balaji.chandrasekaran@testleaf.com";
		String email1="balaji.c@tunatap.co.uk";
		String email2="naveen e@tl.com";
		String regex="[a-zA-z0-9._]+@[a-z0-9]+.[a-z.]{2,}";
		Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(email);
		Matcher matcher2 = compile.matcher(email1);
		Matcher matcher3 = compile.matcher(email2);
		System.out.println(matcher.matches());
		System.out.println(matcher2.matches());
		System.out.println(matcher3.matches());
	}

}
