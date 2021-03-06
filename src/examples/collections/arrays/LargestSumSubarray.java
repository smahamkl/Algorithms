package examples.collections.arrays;

/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
Example:
-------------
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
(If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.)
 */

public class LargestSumSubarray {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(maxSubArray1(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
		System.out.println(maxSubArray1(new int[] { 2, -1, 4, 1, -1, 1, -1 }));
		System.out.println(maxSubArray1(new int[] { -2, 1 }));
		System.out.println(maxSubArray1(new int[] { 2, 1 }));
		System.out.println(maxSubArray1(new int[] { -2, -3, -1 }));
		System.out.println(maxSubArray1(new int[] { -2, -1 }));
		System.out.println(maxSubArray1(new int[] { -1, -1, -2, -2 }));
		
		System.out.println(maxSubArray1(new int[] {-2, -3, 4, -1, -2, 1, 5, -3 }));
		
		System.out.println(maxSubArray1(new int[] {-2, -3, -3 }));

	}
	
	
	//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
	/*
	 * Kadane’s Algorithm:

Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far

	 */
	public static int maxSubArray1(int[] nums) {
		
		 int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
		 
		 for(int i=0;i<nums.length;i++)
		 {
			 max_ending_here += nums[i];
			 max_ending_here  = Math.max(nums[i], max_ending_here);
			 max_so_far = Math.max(max_ending_here, max_so_far);
			
		 }
		 
		 return max_so_far;		
		
	}

}
