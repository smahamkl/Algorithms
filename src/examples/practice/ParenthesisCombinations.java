package examples.practice;

public class ParenthesisCombinations {
	
	static int N = 2;
	//https://algorithms.tutorialhorizon.com/generate-all-valid-parenthesis-strings-of-length-2n-of-given-n/

	static void printParenthesisCombinations(String prefix, int open, int close) {

		if (open > close || open < 0 || close < 0)
			return;

		if (prefix.length() == N * 2)
			System.out.println(prefix);
		else {
			printParenthesisCombinations(prefix + "(", open - 1, close);
			printParenthesisCombinations(prefix + ")", open, close-1);
		} 

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printParenthesisCombinations("", N, N);
	}

}
