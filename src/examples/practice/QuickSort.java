package examples.practice;

public class QuickSort {

	static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			int partElement = getPartitionElement(arr, l, r);
			quickSort(arr, l, partElement - 1);
			quickSort(arr, partElement + 1, r);
		}
	}

	static int getPartitionElement(int[] arr, int l , int r) {
		int pivot = arr[r];

		int j = l-1;

		for (int i = l; i <= r; i++) {
			if (arr[i] <= pivot) {
				j++;
				swapElement(arr, i, j);
			}
		}

		return j;
	}

	static void swapElement(int[] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}

	static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] { 8, 6, 1, 4, 7, 3, 2, 5 };

		quickSort(arr, 0, arr.length - 1);

		printArr(arr);

	}

}
