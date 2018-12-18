package examples.sorting;

public class QuickSort {

	static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot = partitionElements(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	static int partitionElements(int[] arr, int low, int high) {
		int pivot = arr[high];

		int i = low - 1;

		for (int j = low; j <= high; j++) {
			if (arr[j] <= pivot) {
				i++;
				swapElements(arr, i, j);
			}
		}

		return i;

	}

	static void swapElements(int[] arr, int from, int to) {
		int tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
	}

	static void printArray(int[] arr) {
		for (int tmp : arr)
			System.out.print(tmp + " ");

		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] { 10, 80, 30, 90, 40, 50, 70, 20 };

		quickSort(arr, 0, 7);

		printArray(arr);

	}

}
