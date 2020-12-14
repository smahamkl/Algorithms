package leetcode.dec20problems;

/*
 Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. 
 If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. 
 After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:
-----
You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
             
Solution:
------------
 Code below is recursion with memorization simple as possible.
For the above soln we have nums[i-1]*nums[i]*nums[i+1] for the below soln we have nums[-1]*nums[i]*nums[n]. .there are n balloons and i will be the last one to burst.

We can see that the balloons is again separated into 2 sections. But this time since the balloon i is the last balloon of all to burst, 
the left and right section now has well defined boundary and do not affect each other.

 */
public class BaloonsBursting {

	public int maxCoins(int[] nums) {
		int n = nums.length;
		int[] extended = new int[n + 2];
		extended[0] = extended[n + 1] = 1;
		for (int i = 1; i < n + 1; i++)
			extended[i] = nums[i - 1];

		int[][] memoriz = new int[n + 2][n + 2];
		return getMaxCoins(extended, memoriz, 0, n + 1);
	}

	public int getMaxCoins(int[] extended, int[][] memoriz, int left, int right) {
		if (left == right)
			return 0;
		if (memoriz[left][right] > 0)
			return memoriz[left][right];
		int max = 0;
		for (int i = left + 1; i < right; i++)
			max = Math.max(max, extended[left] * extended[i] * extended[right] + getMaxCoins(extended, memoriz, left, i)
					+ getMaxCoins(extended, memoriz, i, right));

		memoriz[left][right] = max;
		return max;
	}

	public static void main(String[] args) {
		BaloonsBursting b = new BaloonsBursting();
		System.out.println(b.maxCoins(new int[] { 3, 1, 5, 8 }));
	}
}
