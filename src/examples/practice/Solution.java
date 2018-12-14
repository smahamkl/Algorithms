package examples.practice;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permutate(nums, 0, nums.length-1);
    }
    
    public List<List<Integer>> permutate(int[] arr, int l, int r) {

		List<List<Integer>> l1;

		l1 = new ArrayList<>();

		if (l == r) {
			ArrayList<Integer> l2 = new ArrayList<>();
			for (int i : arr)
				l2.add(i);
			l1.add(l2);

		} else {
			for (int i = l; i <= r; i++) {
				swapElement(arr, l, i);
				permutate(arr, l + 1, r);
				swapElement(arr, l, i);
			}
		}

		return l1;

	}
    
  public void swapElement(int[] arr, int l, int r) {
		int tmp = arr[l];
		arr[l] = arr[r];
		arr[r] = tmp;
	}
}