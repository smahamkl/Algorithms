package examples.practice;

public class PermutationSample {

	static void swapElement(String[] arr, int from, int to) {
		String tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
	}

	static void permute(String[] arr, int l, int r) {
		if (l == r) {
			printArr(arr);
		} else {

			for (int i = l; i <= r; i++) {
				swapElement(arr, i, l);
				permute(arr, l + 1, r);
				swapElement(arr, i, l);
			}

		}
	}

	static void printArr(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] arr = new String[] { "A", "B", "C" };

		permute(arr, 0, arr.length - 1);

	}

}
