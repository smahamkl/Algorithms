package examples.practice;

public class Permutations {

	static void permute(int[] arr, int l, int r) {

		if (l == r) {
			printArr(arr);

		} else {
			for (int i = l; i <= r; i++) {
				swapElement(arr, l, i);
				permute(arr, l + 1, r);
				swapElement(arr, l, i);
			}
		}

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
		int[] arr = new int[] { 1,2,3,4};
		permute(arr, 0, arr.length - 1);
	}

}
