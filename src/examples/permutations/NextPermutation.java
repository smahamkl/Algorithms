package examples.permutations;

public class NextPermutation {
	static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
