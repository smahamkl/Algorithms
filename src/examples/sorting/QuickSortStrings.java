package examples.sorting;

public class QuickSortStrings {

	static void quickSort(char[] arr, int low, int high) {
		if (low < high) {
			int pivot = partitionElements(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	static int partitionElements(char[] arr, int low, int high) {
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

	static void swapElements(char[] arr, int from, int to) {
		char tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
	}

	static void printArray(char[] arr) {
		for (char tmp : arr)
			System.out.print(tmp + " ");

		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "BADC";
		char[] arr = str.toCharArray();

		quickSort(arr, 0, str.length() - 1);

		printArray(arr);

	}

}
