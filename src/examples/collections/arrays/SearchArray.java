package examples.collections.arrays;

/*
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 */
public class SearchArray {
	
	

	static int divideSearch(int[] arr, int target, int from, int to) {

		if (from < to) {
			int middleElement = from + ((to - from) / 2);
			if (arr[middleElement] == target)
				return middleElement;
			else {
				return Math.max(divideSearch(arr, target, from, middleElement - 1),
						divideSearch(arr, target, middleElement + 1, to));
			}
		} else if (from == to && arr[from] == target)
			return from;
		else
			return -1;
	}

	static int search(int[] arr, int target) {
		return divideSearch(arr, target, 0, arr.length - 1);
	}

	static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr;

		arr = new int[] { 4, 5, 6, 7, 0, 1, 2 };

		System.out.println(search(arr, 3));
	}

}
