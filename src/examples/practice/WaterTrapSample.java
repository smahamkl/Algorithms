package examples.practice;

public class WaterTrapSample {

	static void trapSample(int[] arr) {
		int slowPtr = -1;
		int totalVol = 0;
		boolean declineStart = false;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {

				if (!declineStart) {
					if (slowPtr != -1)
						// this is where we need to find the volume of water trapped between blocks
						totalVol += findWaterVol(arr, slowPtr, i - 1);

					slowPtr = i - 1;
					declineStart = true;
				}

			} else if (arr[i] > arr[i - 1]) {
				if (i == arr.length - 1)
					totalVol += findWaterVol(arr, slowPtr, i);
				declineStart = false;
			}
		}

		System.out.println("total volume of water trapped=" + totalVol);
	}

	static int findWaterVol(int[] arr, int from, int to) {

		int maxHeight = Math.min(arr[from], arr[to]);
		int result = maxHeight * Math.max(0, (arr.length - 2));

		for (int i = from + 1; i < to; i++) {
			result -= arr[i];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		//arr = new int[] { 2, 0, 2 };
		//arr = new int[] { 5, 2, 1, 2, 1, 5 };
		// trapSample(arr);

		int l = 0, r = arr.length - 1;
		int totalVolume = 0;
		while (l < r) {
			totalVolume = Math.max(totalVolume, findWaterVol(arr, l, r));
			System.out.println("Total volume of water trapped: " + totalVolume);

			if (l > r)
				r--;
			else
				l++;
		}

	}

}
