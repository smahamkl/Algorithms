package examples.collections.arrays;

/*
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two 
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

Note: You may not slant the container and n is at least 2.
 */
public class MostWaterSample {

	// o(n*n) which is not efficient
	static int getMaxAreaArr(int[] arr) {
		int result = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				result = Math.max(result, (Math.min(arr[i], arr[j]) * (j - i)));
			}
		}
		return result;
	}

	static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		System.out.println(getMaxAreaArr(arr));

		System.out.println(maxArea(arr));
	}

	// below solution produces the output in o(n) time complexity
	static int maxArea(int[] height) {
		int max = 0, s = 0;

		for (int i = 0, j = height.length - 1; i < j;) {
			if (height[i] > height[j]) {
				s = height[j] * (j - i);
				j--;
			} else {
				s = height[i] * (j - i);
				i++;
			}
			if (s > max)
				max = s;
		}

		return max;
	}

}
