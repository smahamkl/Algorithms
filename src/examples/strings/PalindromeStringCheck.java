package examples.strings;

import java.util.Scanner;

public class PalindromeStringCheck {

	public static void main(String args[]) {

		// Scanner scanner = new Scanner(System.in);

		String s = "A war at Tarawa!";

		System.out.println("Does " + s + ": is a palindrome? " + isPalindrome(s));
	}

	private static boolean isPalindrome(String str) {
		
		str = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
		
		
		if (str.equals(reverse(str))) {
			return true;
		}
		return false;
	}

	private static String reverse(String str) {

		if (str.length() > 1)
			return reverse(str.substring(1)) + str.charAt(0);
		else
			return str;
	}

}
