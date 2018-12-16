package examples.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Permutations {

	static List<List<String>> l1 = new ArrayList<>();

	static List<List<String>> permute(String[] nums) {
		l1.clear();

		return permutate(nums, 0, nums.length - 1);
	}

	static List<List<String>> permutate(String[] arr, int l, int r) {

		if (l == r) {
			if (validateBrackets(arr)) {
				printArr(arr);
				ArrayList<String> l2 = new ArrayList<>();
				for (String i : arr)
					l2.add(i);
				l1.add(l2);
			}

		} else {
			for (int i = l; i <= r; i++) {
				swapElement(arr, l, i);
				permutate(arr, l + 1, r);
				swapElement(arr, l, i);
			}
		}

		return l1;

	}

	static void swapElement(String[] arr, int l, int r) {
		String tmp = arr[l];
		arr[l] = arr[r];
		arr[r] = tmp;
	}

	static void printArr(String[] arr) {
		for (String i : arr) {
			System.out.print(i + " ");
		}

		System.out.println();
	}

	static boolean validateBrackets(String[] arr) {
		boolean result = true;

		Stack<String> s = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == "(")
				s.push(arr[i]);
			else if (arr[i] == ")") {
				if (s.isEmpty() || s.peek() == null)
					return false;
				else
					s.pop();
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String[] arr = new String[] { "(", "(", ")", ")" };
		permute(arr);
	}

}
