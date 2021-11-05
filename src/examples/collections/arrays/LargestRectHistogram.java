package examples.collections.arrays;
/*
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
largest-rectangle-in-histogram
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 */

public class LargestRectHistogram {

	static int macRectArea(int[] arr) {
		int result = 0;

		int l = 0;
		int r = arr.length - 1;

		while (l < r) {
			int area = (r - l) * Math.min(arr[l], arr[r]);

			if (l < r)
				l++;
			else
				r--;
			result = Math.max(area, result);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] { 2, 1, 5, 6, 2, 3 };

		System.out.println(macRectArea(arr));

	}

}
