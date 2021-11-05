package leetcode.dec20problems;

/*
 Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

 

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 */

public class IncreasingTripletSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IncreasingTripletSeq obj = new IncreasingTripletSeq();
		System.out.println(obj.increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(obj.increasingTriplet(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(obj.increasingTriplet(new int[] { 5, 1, 2, 1, 6, 0 }));
		System.out.println(obj.increasingTriplet(new int[] { 2, 1, 5, 0, 3 }));
		System.out.println(obj.increasingTriplet(new int[] { 2, 5, 3, 4, 5 }));
		System.out.println(obj.increasingTriplet(new int[] {0,4,2,1,0,-1,-3}));
		System.out.println(obj.increasingTriplet(new int[] {1,2,-10,-8,-7}));
		System.out.println(obj.increasingTriplet(new int[] { 2, 1, 5, 0, 3, 4 }));
		System.out.println(obj.increasingTriplet(new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, 3 }));

	}

	public boolean increasingTriplet(int[] nums) {
		int first = Integer.MAX_VALUE, sec = Integer.MAX_VALUE;
		for (int j : nums)
			if (j <= first)
				first = j;
			else if (j <= sec)
				sec = j;
			else
				return true;
		return false;
	}

}
