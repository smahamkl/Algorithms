package examples.practice;

public class QuickSorting {

	static void nextPermutation(int[] arr) {

		boolean found = false;

		int prevEle = arr[arr.length - 1];

		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] < prevEle) {
				int nextHighestElement = nextHighestElement(arr, i, arr[i]);
				swapElement(arr, i, nextHighestElement);
				reverseElements(arr, i + 1);
				found = true;
				break;
			}
			prevEle = arr[i];
		}

		if (!found)
			quickSort(arr, 0, arr.length - 1);
	}

	static void reverseElements(int[] arr, int from) {

		int lastEle = arr.length - 1;

		for (int i = from; i < (from + (arr.length - from) / 2); i++) {
			swapElement(arr, i, lastEle);
			lastEle--;
		}

	}

	static int nextHighestElement(int[] arr, int from, int ele) {
		int result = Integer.MAX_VALUE;
		int resultIdx = 0;
		for (int i = from; i < arr.length; i++) {
			if (arr[i] > ele && arr[i] <= result) {
				result = arr[i];
				resultIdx = i;
			}
		}

		return resultIdx;
	}

	static void quickSort(int[] arr, int l, int h) {
		if (l < h) {
			int pivot = partitionData(arr, l, h);
			quickSort(arr, l, pivot - 1);

			quickSort(arr, pivot + 1, h);

		}
	}

	static int partitionData(int[] arr, int start, int end) {
		int i = start - 1;
		int pivot = arr[end];

		for (int j = start; j <= end; j++) {
			if (arr[j] <= pivot) {
				i++;
				swapElement(arr, i, j);
			}
		}

		return i;
	}

	static void swapElement(int[] arr, int l, int r) {
		int tmp = arr[l];
		arr[l] = arr[r];
		arr[r] = tmp;
	}

	static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 5, 8, 4, 7, 6, 5, 3, 1 };

		arr = new int[] { 2,3,1,3,3 };

		nextPermutation(arr);
		printArr(arr);
	}

}
