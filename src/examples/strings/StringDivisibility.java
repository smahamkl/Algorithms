package examples.strings;

import java.util.*;
/*
 * Two strings s1 = abdabdabdabd s2 = abdabd are considered divisible if S2 can be concatenated
 * multiple times to get S1. As far as the string S1, the longest substring that is repeating is "abd"
 * So the question is to find the length of the longest substring pattern of S2 that can be concatenated to
 * form both s1 an s2 and where S2 can be concatenated to form S1 * 
 * Hacker rank question for capital one
 * References:
 * ----------------
 * https://www.geeksforgeeks.org/find-given-string-can-represented-substring-iterating-substring-n-times/
 * https://leetcode.com/problems/longest-happy-prefix/discuss/549411/javakmpsolution-with-kmp-and-lps-explanation
 * using KMP algorithm of finding a prefix which is also a suffix
 */

public class StringDivisibility {

	public static String longestPrefix(String s) {
        String result = "";
        if (s == null || s.length() == 0) {
            return result;
        }
        int lps[] = computeLPSArray(s);
        int n = s.length(); 
        int len = lps[n-1]; 
       
        if(len > 0 && n%(n-len) == 0) {
        
        int lastIndex = lps[s.length() - 1];
        if (lastIndex == 0) {
            return result;
        } else {
           // result = s.substring(0, lastIndex);
            result = s.substring(lastIndex, s.length());
        }
        return result;
        }
        return s;
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
                }
                else // if (i == 0)
                {
                    lps[j] = i;
                    j++;
                }
            }
        }
        return lps;
    }

	public static void main(String[] args) {
     
	    String s1 = "lrbb";
	    String s2 = "lrbb";
	      
	    System.out.println(longestPrefix(s1));
	    System.out.println(longestPrefix(s2));
	}

}
