package examples.strings;

/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

KMP algorithm for pattern matching

 */
public class RepeatedString {

    public boolean repeatedSubstringPattern(String s) {

        String result = "";
        if (s == null || s.length() == 0) {
            return false;
        }
        int lps[] = computeLPSArray(s);
        int n = s.length();
        int len = lps[n - 1];

        if (len > 0 && n % (n - len) == 0) {
            int lastIndex = lps[s.length() - 1];
            if (lastIndex == 0) {
                return false;
            } else {
                result = s.substring(lastIndex, s.length());
                String res = "";
                for(int i=1;i<= (n/(n-len));i++)
                {
                    res += result;
                }
                System.out.println(res);
                if(res.equals(s))
                    return true;
            }
        }

        return false;
    }

    public static int[] computeLPSArray(String pat) {
        int i = 0;
        int j = i + 1;
        int M = pat.length();
        int lps[] = new int[M];
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for j = 1 to M-1
        while (j < M) {
            if (pat.charAt(i) == pat.charAt(j)) {
                lps[j] = i + 1;
                j++;
                i++;
            } else {
                if (i != 0) {
                    i = lps[i - 1];
                } else // if (i == 0)
                {
                    lps[j] = i;
                    j++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {

        RepeatedString rss = new RepeatedString();

        System.out.println(rss.repeatedSubstringPattern("abcd"));
    }

}
