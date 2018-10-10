package examples.strings;

public class PalindromeEdit1 {
	static int charIdxToRemove = -1;

	static boolean checkIfPalindrome(String s) {
		int startIdx = 0;
		int endIdx = s.length() - 1;
		while (startIdx < endIdx) {
			if (s.charAt(startIdx) != s.charAt(endIdx))
				return false;

			startIdx += 1;
			endIdx -= 1;
		}
		return true;
	}

	static int editDistance(String s, int startIdx, int endIdx) {

		if (startIdx >= endIdx)
			return 0;

		if (s.charAt(startIdx) == s.charAt(endIdx))
			return editDistance(s, startIdx + 1, endIdx - 1);

		if (s.charAt(startIdx) != s.charAt(endIdx)) {

			if (checkIfPalindrome(s.substring(startIdx + 1, endIdx+1)))
			{
				charIdxToRemove = startIdx;
				return 0;
			}

			if (checkIfPalindrome(s.substring(startIdx, endIdx)))
			{
				charIdxToRemove = endIdx;
				return 0;
			}

			return 0;
		}

		return 0;
	}

	public static void main(String[] args) {
		String a = "aaab";

		if (checkIfPalindrome(a))
			System.out.println(-1);
		else {
			int ret = editDistance(a, 0, a.length() - 1);
			System.out.println(charIdxToRemove);
		}

	}

}
