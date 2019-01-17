package examples.collections.arrays;
/*
 * 
 * 
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

 */

public class ArrayPositionFinder {

	static int findPosition(int[] arr, int target, int l, int r) {

		if (target == arr[l])
			return l;
		if (l < r) {
			int m = ((l + r) / 2) - 1;

			if (target == arr[m])
				return m;
			else if (target < arr[m])
				return findPosition(arr, target, l, m - 1);
			else if (target > arr[m])
				return findPosition(arr, target, m + 1, r);

		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] { 1,5,2,5,5,9 };

		System.out.println(findPosition(arr, 5, 0, arr.length - 1));
	}

}
