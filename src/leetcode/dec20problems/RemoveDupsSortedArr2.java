package leetcode.dec20problems;

/*
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.

Clarification:

Confused why the returned value is an integer, but your answer is an array?

Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller.

Internally you can think of this:

//nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

Example 1:

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3]
Explanation: Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively. 
It doesn't matter what you leave beyond the returned length.

 * 
 */
public class RemoveDupsSortedArr2 {
	
	public void printArr(int[] nums)
	{
		for(int n:nums)
			System.out.print(n + " ");
		
		System.out.println();
		
	}
	
	public int removeDuplicates(int[] nums) {
		
		int slow = 2, fast = 2;
		
		while(fast < nums.length)
		{
			System.out.println("Slow-2: " + nums[slow-2] + " Fast: " + nums[fast]);
						
			if(nums[slow-2] != nums[fast]) {
				nums[slow] = nums[fast];
				slow++;
			}
			printArr(nums);
			System.out.println("---------------");
			fast++;			
		}
		return slow;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1,1,1,1,2,2,3};
		// TODO Auto-generated method stub
		System.out.println(new RemoveDupsSortedArr2().removeDuplicates(nums));

	}

}
