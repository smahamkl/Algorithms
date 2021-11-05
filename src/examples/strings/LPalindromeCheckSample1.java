package examples.strings;

/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */

//currently the code is running only 10% faster than other submissions
//need to optimize it

public class LPalindromeCheckSample1 {

	static boolean checkIfPalindrome(String s, int startIdx, int endIdx) {

		if (startIdx == endIdx) {
			if (s.charAt(startIdx) == s.charAt(endIdx))
				return true;
			else
				return false;
		} else if (startIdx > endIdx)
			return true;

		if (s.charAt(startIdx) == s.charAt(endIdx))
			return checkIfPalindrome(s, startIdx + 1, endIdx - 1);
		else
			return false;

	}

	static String longestPalindrome(String s) {

		String tmp = "";

		if (s.length() == 1)
			return s;
		else if (checkIfPalindrome(s, 0, s.length() - 1))
			return s;

		for (int i = 0; i < s.length() - 1; i++) {

			
			for (int j = s.length() - 1; j >= i; j--) {
				if (checkIfPalindrome(s, i, j)) {
					if (s.substring(i, j + 1).length() > tmp.length())
						tmp = s.substring(i, j + 1);

					break;
				}
			}
			
            if(tmp.length() >= s.length() - i + 1)
                break;

		}
		return tmp;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(longestPalindrome("babad"));
		// System.out.println(longestPalindrome("cbbd"));
		// System.out.println(checkIfPalindrome("ii", 0, 1));
		System.out.println(longestPalindrome(
				"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"));
	}

}
