package org.performance.ds;

import java.util.Stack;

/*
 * Sort a stack using a temporary stack
Given a stack of integers, sort it in ascending order using another temporary stack.
 */
public class StackSort {

	static Stack<Integer> sortStack(Stack<Integer> s) {

		Stack<Integer> tmpStack = new Stack<Integer>();

		while (!s.isEmpty()) {
			int a = s.pop();
			while (!tmpStack.isEmpty() && tmpStack.peek() > a)
				s.push(tmpStack.pop());

			tmpStack.push(a);
		}

		return tmpStack;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> input = new Stack<Integer>();
		input.add(34);
		input.add(3);
		input.add(31);
		input.add(98);
		input.add(92);
		input.add(23);

		// This is the temporary stack
		Stack<Integer> tmpStack = sortStack(input);
		System.out.println("Sorted numbers are:");

		while (!tmpStack.empty()) {
			System.out.print(tmpStack.pop() + " ");
		}

	}

}
