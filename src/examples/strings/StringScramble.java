package examples.strings;

public class StringScramble {

	// For this challenge you will determine if a portion of string 1 can be rearranged into
	// string 2.

	public static boolean stringCheck(String str1, String str2) {
		str1 = str1.replaceAll("[^A-Za-z0-9]", "").toUpperCase();
		str2 = str2.replaceAll("^A-Za-z0-9", "").toUpperCase();
		int baseArr1[] = new int[35];
		int baseArr2[] = new int[35];
		for (int i = 0; i < str1.length() || i < str2.length(); i++) {
			if (i < str1.length()) {
				if (Character.isDigit(str1.charAt(i)))
					baseArr1[26 + Integer .parseInt(String.valueOf(str1.charAt(i)))]++;
				else
					baseArr1[str1.charAt(i) - 'A']++;
			}

			if (i < str2.length()) {
				if (Character.isDigit(str2.charAt(i)))
					baseArr2[26 + Integer .parseInt(String.valueOf(str2.charAt(i)))]++;
				else
					baseArr2[str2.charAt(i) - 'A']++;
			}
		}

		for (int i = 0; i < 35; i++) {
			if (baseArr2[i] > 0 && baseArr1[i] < baseArr2[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "coodrebtqqkye";
		String str2 = "coderbyte";

		if (stringCheck(str1, str2))
			System.out.println("The string:" + str1 + " can be rearranged to form " + str2);
		else
			System.out.println("The string:" + str1 + " cannot be rearranged to form " + str2);

	}

}
