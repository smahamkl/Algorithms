package examples.strings;

/*
 * Examples:
1) Consider the input strings “AGGTAB” and “GXTXAYB”. Last characters match for the strings. So length of LCS can be written as:
L(“AGGTAB”, “GXTXAYB”) = 1 + L(“AGGTA”, “GXTXAY”)
2) Consider the input strings “ABCDGH” and “AEDFHR. Last characters do not match for the strings. So length of LCS can be written as:
L(“ABCDGH”, “AEDFHR”) = MAX ( L(“ABCDG”, “AEDFHR”), L(“ABCDGH”, “AEDFH”) )

So the LCS problem has optimal substructure property as the main problem can be solved using solutions to subproblems.
 */
public class LCSSample2 {

	static int lcs(String str1, String str2) {
		int l = 0;
		if (str1.isEmpty() || str2.isEmpty())
			return 0;

		if (str1.charAt(str1.length() - 1) == str2.charAt(str2.length() - 1))
			return 1 + lcs(str1.substring(0, str1.length() - 1), str2.substring(0, str2.length() - 1));
		else
			return Math.max(lcs(str1.substring(0, str1.length()), str2.substring(0, str2.length() - 1)),
					lcs(str1.substring(0, str1.length() - 1), str2.substring(0, str2.length())));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "ABCDGH";
		String str2 = "AEDFHR";
		
		str1 = "AGGTAB";
		str2 = "GXTXAYB";

		System.out.println(lcs(str1, str2));

	}

}
