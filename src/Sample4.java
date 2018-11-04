

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sample4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String auNm = "PATELCO CREDIT UNION";
		// String mlidNm = "PATELCO CREDIT UNION";
		// String auClnsdNm = "PATEL CREDIT UNION";
		// if (auNm.substring(0, Math.min(auNm.length(), 7))
		// .equals(mlidNm.substring(0, Math.min(mlidNm.length(), 7)))
		// || auClnsdNm.substring(0, Math.min(auClnsdNm.length(), 7))
		// .equals(mlidNm.substring(0, Math.min(mlidNm.length(), 7))))
		// {
		// System.out.println("Matching");
		//
		// }
	//	int[] i = getMinimumDifference(new String[] { "india", "sever" }, new String[] { "diana", "seven" });

		System.out.println(checkAnagram("samben", "samber"));
		
		//System.out.println(getLongestCommonSubsequence("madam", "madras"));

//		System.out.println(i[0]);
//		System.out.println(i[1]);
	}

	//Praveens code
//	static int[] getMinimumDifference(String[] a, String[] b) {
//		int[] answers = new int[a.length];
//		for (int i = 0; i < a.length; i++)
//			if (a[i].length() != b[i].length())
//				answers[i] = -1;
//			else {
//				int count_a = 0;
//				for (int j = 0; j < a[i].length(); j++)
//					if (b[i].indexOf(a[i].charAt(j)) == -1)
//						count_a++;
//				int count_b = 0;
//				for (int j = 0; j < b[i].length(); j++)
//					if (a[i].indexOf(b[i].charAt(j)) == -1)
//						count_b++;
//				answers[i] = count_a > count_b ? count_a : count_b;
//			}
//		return answers;
//	}

	 static int[] getMinimumDifference(String[] a, String[] b) {
	
	 int[] i = new int[a.length];
	 for (int k = 0; k < a.length; k++) {
	 i[k] = checkAnagram(a[k], b[k]);
	 System.out.println(i[k]);
	 }
	
	 return i;
	 }

	public static int getLongestCommonSubsequence(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n];
	}

	static int checkAnagram(String a, String b) {
		int totDiff = 0;
		if (a.length() != b.length())
			return -1;

		char[] charsA = a.toCharArray();
		char[] charsB = b.toCharArray();
		Arrays.sort(charsA);
		Arrays.sort(charsB);

		a = new String(charsA);
		b = new String(charsB);
		System.out.println(new String(charsA));
		System.out.println(new String(charsB));

		System.out.println("LSS is " + getLongestCommonSubsequence(a, b));

		totDiff = a.length() - getLongestCommonSubsequence(a, b);

		System.out.println("Total modifications to make is:" + totDiff);

		return totDiff;
	}
}
