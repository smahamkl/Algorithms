package examples.practice;

public class ParenthesisCombinations {

	static void printParenthesisCombinations(String prefix, int open, int close) {

		if (open > close || open < 0 || close < 0)
			return;

		if (prefix.length() == 4)
			System.out.println(prefix);
		else if (open == close) {
			printParenthesisCombinations(prefix + "(", open - 1, close);
			printParenthesisCombinations(prefix + "(", open - 1, close);
		} else {
			printParenthesisCombinations(prefix + ")", open, close - 1);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printParenthesisCombinations("", 2, 2);
	}

}
