package examples.dynamicprogramming;

import java.util.Stack;

public class ValidParenthesis {

	static boolean validateBrackets(String arr, int l, int r) {
		boolean result = true;

		Stack<Character> s = new Stack<>();

		for (int i = l; i <= r; i++) {
			if (arr.charAt(i) == '(')
				s.push(arr.charAt(i));
			else if (arr.charAt(i) == ')') {
				if (s.isEmpty() || s.peek() == null)
					return false;
				else {
					s.pop();
				}
			}
		}

		return s.empty() ? result : false;
	}

	// brut force way...o(n 3) complexity

	static int longestParenthesis(String arr) {
		int totalLength = 0;

		for (int i = 0; i < arr.length() - 1; i++) {
			for (int j = arr.length() - 1; j > i; j--) {
				if (arr.charAt(i) != ')' && arr.charAt(j) != '(' && totalLength < (j - i + 1)) {
					if (validateBrackets(arr, i, j)) {
						totalLength = Math.max(totalLength, (j - i + 1));
						break;
					}
				}
			}
		}

		return totalLength;
	}

	// debug the program and check how the size is compiled for each iteration of i
	// and check how the i'th dp array value gets updated
	static int longestValidParentheses(String s) {
		int maxans = 0;
		int dp[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		printArr(dp);
		return maxans;
	}

	static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "()()((((()))";

		s = "()()()(()))()()())))((()()()(()()))(()()()((()()))())(((())()())(()(()(()(())(((()())()))(()))()))))()())(()))))()()(())()()((())()()))))((()))))(()()((()(()(()())((())()()()()))()()()(())()()())((((()(())())))(((()(((()((((())())(()()()()(((((()))()(()(())))(((()()()()(()(((())(()(()()(()(()(())()))))))()))()())((()((((()(())(()()()(((((()())()))))())))((((()()()(()(())(((())(((()()((()((()(((()(()))(((())(((()((((()(())(((()((()(()())))))(()(()()(())))))()(()()((()))()))())())((())))()(())((((()((()))))()())()))((()(()())()())()()((()))())(()(()(())((((((()()((((())))())(((()()())))()(((()(()()((((())))))()()((((()(()()())(()(())()()()((()(()((((())))((((((())(()())()))))(()(()))()))))))(()()((()()()())(())))(((()))(()()()(()))((())()()()())()()(((())(()(())()()(()())((()()(((((())(()((((()(()()()(()))(()((((())()())()())())))())(((()(()((())()()((((()()()()))))))())())()(((((()())()(()()()()()(((())((((((()))(())()(()())(()(()())(()(())))())))(()()(()((((()()(())(()))()))(()))(()())())()))))))()()(())))))()))()(()())))((())(()()))()((()))()(())()()((((())()))((()(()))()(((()())()(()()((()())((((())()))))()(())())())())(((()(()())))((()))))()())))))(()((())))()())((()))()()))(())())()))()()((()(((())()()()((()()(()(())(()))())())(((()())(()())(()((()()()())()(()(((((((()()(((()(((((((())(()))))())()))))))))()(()(()((((())(()()(((()))()(())(((((((((()(()())())()(((()((()(((()(()()(()))(())))))))(((";

		s = "(((())))";
		// System.out.println(validateBrackets(s, 0, s.length() - 1));

		// System.out.println(longestParenthesis(s));

		System.out.println(longestValidParentheses(s));

	}

}
