package examples.collections.arrays;

import java.util.HashSet;

public class ThreeeSumSample {

	static HashSet<Integer> hs = new HashSet<>();

	static void threeSum(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int firstN = arr[0];
			int pairSum = (0 - firstN);

			for (int j = i + 1; j < arr.length; j++) {
				hs.add(arr[j]);

				int tmp = pairSum - arr[j];

				if (hs.contains(tmp)) {
					System.out.println("found 3 sum: " + firstN + " " + arr[j] + " " + tmp);
				}
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] { -1, 0, 1, 2, -1, -4 };
		
		threeSum(arr);

	}

}
