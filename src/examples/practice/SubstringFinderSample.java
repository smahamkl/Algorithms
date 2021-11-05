package examples.practice;

import java.util.ArrayList;

public class SubstringFinderSample {

	static int[] subStr;
	
	//one idea is to take every substring of s and check if its an anagram of concatenated string of strList
	//below method checks the big string one word at a time and form an array thats connects the indices abd values(kind of linked list)

	static void subStringFinder(String s, String[] strList) {

		for (String str : strList) {
			int l = 0;
			while (s.substring(l).contains(str)) {
				int idx = s.indexOf(str, l);
				subStr[idx] = idx + str.length();
				l = idx + str.length();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "barfoofoobarthefoobarman";
		String[] words = new String[] { "bar", "foo", "the" };

		subStr = new int[s.length()];

		subStringFinder(s, words);

		ArrayList<Integer> finalResult = new ArrayList<>();

		for (int i = 0; i < subStr.length; i++) {
			if (subStr[i] > 0) {
				int tmp = subStr[i];
				int counter = 1;
				while (tmp < s.length() && subStr[tmp] > 0) {
					counter++;
					tmp = subStr[tmp];
				}

				if (counter == words.length)
					finalResult.add(i);

				System.out.println(i + " " + subStr[i]);
			}

		}

		System.out.println("Final list size :" + finalResult.size());

	}

}
