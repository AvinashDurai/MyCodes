package javaDay3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateName {

	public static void main(String[] args) {
		String str = "AvinashDurai";
		String str1="Avinash";
		String pattern = "[a-zA-Z0-9._$@]{8,}";
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher(str);
		System.out.println(matcher.matches());
		Matcher matcher1 = compile.matcher(str1);
		System.out.println(matcher1.matches());

	}

}
