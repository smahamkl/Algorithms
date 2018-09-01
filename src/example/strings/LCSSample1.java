package example.strings;


//longest common subsequence
public class LCSSample1 {
	
	static int findLCS(char[] s1, char[] s2, int m, int n) {

		if (m == -1 || n == -1)
			return 0;

		if (s1[m] == s2[n]) {
			return 1 + findLCS(s1, s2, m - 1, n - 1);

		} else
			return Math.max(findLCS(s1, s2, m, n - 1), findLCS(s1, s2, m - 1, n));

	}

	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		System.out.println(findLCS(s1.toCharArray(), s2.toCharArray(), s1.length() - 1, s2.length() - 1));

	}
}
