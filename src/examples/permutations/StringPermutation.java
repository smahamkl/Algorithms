package examples.permutations;

public class StringPermutation {

	static void swapElement(String[] arr, int fromIdx, int toIdx) {
		String tmp = arr[fromIdx];
		arr[fromIdx] = arr[toIdx];
		arr[toIdx] = tmp;
	}

	static void printArray(String[] arr) {
		for (String tmp : arr)
			System.out.print(tmp + " ");

		System.out.println();
	}

	static void permute(String[] str, int l, int r) {

		if (l == r)
			printArray(str);
		else {
			for (int i = l; i <= r; i++) {
				swapElement(str, l, i);
				permute(str, l + 1, r);
				//System.out.println("value of i:" + i + " value of l:" + l);
				swapElement(str, l, i);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = new String[] { "A", "B", "C" };
		permute(arr, 0, arr.length - 1);

	}

}
