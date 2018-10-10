package examples.strings;

public class CheckAnagram {

	//Covert string 1 to an anagram of string 2 with minimum replacements
	//find frequency of each letter from string 1 & 2
	//total min replaces in String 1 to make it anagram of String 2
	//is sum(|count1(x)-count2(x))/2. Fine the letters in string 1 not present in string 2
	//and letters from string 2 not present in string 1
	//iterate through string 1 and replace the characters found from above
	static int MAX = 26;


	public String checkAnagramCharDiff(String str1, String str2) {
		int baseArr1[] = new int[MAX];
		int baseArr2[] = new int[MAX];

		for (int i = 0; i < str1.length() && i < str2.length(); i++) {
			baseArr1[str1.charAt(i) - 'A']++;
			baseArr2[str2.charAt(i) - 'A']++;
		}

		String diffB = "";
		String diffA = "";
		int diff = 0;

		for (int i = 0; i < MAX; i++) {
			diff += Math.abs(baseArr1[i] - baseArr2[i]);

			if (baseArr2[i] - baseArr1[i] > 0) {
				for (int j = 0; j < (baseArr2[i] - baseArr1[i]); j++)
					diffB += String.valueOf((char) ((int) 'A' + i));
			}

			if (baseArr1[i] - baseArr2[i] > 0) {
				for (int j = 0; j < (baseArr1[i] - baseArr2[i]); j++)
					diffA += String.valueOf((char) ((int) 'A' + i));
			}
		}
		//System.out.println("2 not in 1: " + diffB);
		//System.out.println("1 not in 2: " + diffA);
		System.out.println("diff: " + diff / 2);

		int incr = 0;
		String finalStr = "";

		for (int i = 0; i < MAX; i++) {
			if (baseArr1[i] == 0)
				continue;
			for (int j = 0; j < baseArr1[i]; j++) {
				char curChar = (char) ((int) 'A' + i);
				if (incr < (diff / 2) && curChar == diffA.charAt(incr)) {
					finalStr += diffB.charAt(incr);
					incr++;
				} else
					finalStr += curChar;
			}
		}

		return finalStr;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckAnagram ca = new CheckAnagram();

		System.out.println(ca.checkAnagramCharDiff("PJPOJOVMAK", "FVACRHLDAP"));
		
		System.out.println(ca.checkAnagramCharDiff("CDBABC", "ADCABD"));
		
	}

}
