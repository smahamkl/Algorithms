package examples.strings;
/*
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LSubStrNoRepititionsSample1 {
	
	static int[] ASCII;

	static int checkSubstrings(String str) {

		int slowIdx = 0;
		int maxLength = 0;

		for (int i = 0; i < str.length() - 1; i++) {

			ASCII = new int[128];
			ASCII[str.charAt(i)]++;
			slowIdx = i;
			
			for (int j = i+1; j < str.length(); j++) {
				if (ASCII[str.charAt(j)] == 0) {
					ASCII[str.charAt(j)]++;
				} else {
					slowIdx = j;
				}
				if ((j - slowIdx + 1) > maxLength)
					maxLength = j - slowIdx + 1;
			}		

		}

		return maxLength;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "bbbabbb**$~";

		System.out.println(checkSubstrings(str));

		// System.out.println(getLSSuffix(str.toLowerCase(), 0));
		// System.out.println(Math.max(getLSSuffix(str.toLowerCase(), 0).length(),
		// getLSPrefix(str.toLowerCase(), str.length()).length()));
	}

}
