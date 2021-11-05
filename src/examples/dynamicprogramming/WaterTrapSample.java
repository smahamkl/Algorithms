package examples.dynamicprogramming;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining
 * 
 *  Dynamic Programming
Intuition

In brute force, we iterate over the left and right parts again and again just to find the highest bar size upto that index. 
But, this could be stored. Voila, dynamic programming.

The concept is illustrated as shown:

 * Algorithm

Find maximum height of bar from the left end upto an index i in the array \text{left_max}.
Find maximum height of bar from the right end upto an index i in the array \text{right_max}.
Iterate over the \text{height}height array and update ans:
Add \min(\text{max_left}[i],\text{max_right}[i]) - \text{height}[i] to ansans

 */
public class WaterTrapSample {

	static int trapSample(int[] arr) {
		
        if(arr == null || arr.length < 3)
            return 0;
        
		int[] left_max = new int[arr.length];
		int[] right_max = new int[arr.length];

		left_max[0] = arr[0];
		for (int i = 1; i < arr.length; i++)
			left_max[i] = Math.max(left_max[i - 1], arr[i]);

		right_max[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--)
			right_max[i] = Math.max(right_max[i + 1], arr[i]);

		int totalVol = 0;

		for (int i = 1; i < arr.length; i++)
			totalVol += Math.min(left_max[i], right_max[i]) - arr[i];

		// printArr(left_max);

		// printArr(right_max);

		return totalVol;

	}

	static void printArr(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");

		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		//arr = new int[] { 2, 0, 2 };
		// arr = new int[] { 5, 2, 1, 2, 1, 5 };
		//arr = new int[] { 5, 1, 3, 2 };
		//arr = new int[] { 4, 3, 3, 9, 3, 0, 9, 2, 8, 3 };
		//arr = new int[] { 9, 6, 8, 8, 5, 6, 3 };

		System.out.println(trapSample(arr));

	}

}
