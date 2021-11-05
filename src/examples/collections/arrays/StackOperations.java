package examples.collections.arrays;

import java.util.Stack;

public class StackOperations {

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

	public int solution(String S) {
		// write your code in Java SE 8
		String[] operArr = S.split(" ");
		Stack<Integer> myStack = new Stack<Integer>();
		final int INT_MAX_LIMIT = 1048575; // pow(2,20) -1
		final int ERR_RES = -1;

		for (int i = 0; i < operArr.length; i++) {

			String curOper = operArr[i].trim();

			if (curOper.equals("POP")) {
				if (myStack.isEmpty())
					return ERR_RES;
				else
					myStack.pop();

			} else if (curOper.equals("DUP")) {
				if (myStack.isEmpty())
					return ERR_RES;
				else
					myStack.push(myStack.peek());

			} else if (curOper.equals("+")) {
				if (myStack.size() < 2)
					return ERR_RES;
				else {
					int res = myStack.pop() + myStack.pop();
					if (res > INT_MAX_LIMIT)
						return ERR_RES;
					else
						myStack.push(res);
				}

			} else if (curOper.equals("-")) {
				if (myStack.size() < 2)
					return ERR_RES;
				else {
					int res = myStack.pop() - myStack.pop();
					if (res >= 0)
						myStack.push(res);
					else
						return ERR_RES;
				}

			} else if (isInteger(curOper)) {
				int num = Integer.parseInt(curOper);
				if (num > INT_MAX_LIMIT || num < 0)
					return -1;
				else
					myStack.push(num);
			} else {
				return -1;
			}
		}

		if (myStack.isEmpty() || myStack.peek() > INT_MAX_LIMIT)
			return -1;
		else
			return myStack.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackOperations sol = new StackOperations();
		System.out.println(sol.solution("4 5 6 - 7 +"));
		System.out.println(sol.solution("13 DUP 4 POP 5 DUP + DUP + -"));
		System.out.println(sol.solution("5 6 + -"));
		System.out.println(sol.solution("4 DUP 5 - -"));
		System.out.println(sol.solution("1048574 1 +"));
		System.out.println(sol.solution("1048574 2 +"));
		System.out.println(sol.solution("1 DUP POP DUP POP DUP POP DUP +"));
		System.out.println(sol.solution("1048576"));
		System.out.println(sol.solution("0"));
		System.out.println(sol.solution("-2"));
	}

}
