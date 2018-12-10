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
				if(i == arr.length-1)
					totalVol += findWaterVol(arr, slowPtr, i);
				declineStart = false;
			}
		}

		System.out.println("total volume of water trapped=" + totalVol);
	}

	static int findWaterVol(int[] arr, int from, int to) {
		int result = 0;
		int maxHeight = Math.min(arr[from], arr[to]);

		while (arr[from] >= arr[from + 1]) {
			result = result + (maxHeight - arr[from + 1]);
			from = from + 1;
		}

		while (arr[to] >= arr[to - 1] && (to-1) > from) {
			result = result + (maxHeight - arr[to - 1]);
			to = to - 1;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		arr = new int[] { 2,0,2};
		arr = new int[] { 5,2,1,2,1,5};
		trapSample(arr);

	}

}
