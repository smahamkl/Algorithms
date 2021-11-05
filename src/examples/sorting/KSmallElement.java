package examples.sorting;

public class KSmallElement {

	static void merge(int arr[], int left, int middle, int right) {
		int n1 = middle - left + 1;
		int n2 = right - middle;

		int temp1[] = new int[n1];
		int temp2[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			temp1[i] = arr[left + i];
		
		for (int j = 0; j < n2; ++j)
			temp2[j] = arr[middle + 1 + j];
		
		int i = 0, j = 0;

		int k = left;
		while (i < n1 && j < n2) {
			if (temp1[i] <= temp2[j]) {
				arr[k] = temp1[i];
				i++;
			} else {
				arr[k] = temp2[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = temp1[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = temp2[j];
			j++;
			k++;
		}
	}

	static void sortArray(int arr[], int leftIdx, int rightIdx) {
		if (leftIdx < rightIdx) {
			int middleIdx = (leftIdx + rightIdx) / 2;
			sortArray(arr, leftIdx, middleIdx);
			sortArray(arr, middleIdx + 1, rightIdx);

			merge(arr, leftIdx, middleIdx, rightIdx);
		}
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 7, 5, 4, 1, 2, 3 };
		sortArray(arr, 0, arr.length - 1);
		
		for (int i=0;i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
	   System.out.println();
	   
	   System.out.println("2nd smallest element: " + arr[1]);
	   
	   System.out.println("4th smallest element: " + arr[3]);

	}
}
