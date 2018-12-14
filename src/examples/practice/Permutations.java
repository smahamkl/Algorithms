package examples.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	
	static List<List<Integer>> l1 = new ArrayList<>();
	
    static List<List<Integer>> permute(int[] nums) {
    	l1.clear();
    	
        return permutate(nums, 0, nums.length-1);
    }

	static List<List<Integer>> permutate(int[] arr, int l, int r) {

		

		if (l == r) {
			printArr(arr);
			ArrayList<Integer> l2 = new ArrayList<>();
			for (int i : arr)
				l2.add(i);
			l1.add(l2);

		} else {
			for (int i = l; i <= r; i++) {
				swapElement(arr, l, i);
				permutate(arr, l + 1, r);
				swapElement(arr, l, i);
			}
		}

		return l1;

	}

	static void swapElement(int[] arr, int l, int r) {
		int tmp = arr[l];
		arr[l] = arr[r];
		arr[r] = tmp;
	}

	static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4 };
		permute(arr);
	}

}
