package examples.collections.arrays;

import java.util.HashSet;

public class ArraySumSample1 {

	static boolean arraySum(int[] arr) {
		int maxNum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxNum)
				maxNum = arr[i];
		}
		HashSet<Integer> numSet = new HashSet<>();

		int diff = maxNum;
		for (int i = 0; i < arr.length; i++) {
			if (!numSet.contains(arr[i]))
				numSet.add(arr[i]);
			
			if (arr[i] != maxNum)
				diff = diff - arr[i];
			
			if(diff == 0)
				return true;
			else if (diff < 0 && numSet.contains(Math.abs(diff)))
				return true;
			
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(arraySum(new int[] { 3, 5, -1, 8, 12 }));

		//System.out.println(arraySum(new int[] { 5, 7, 16, 1, 2 }));
		
		//System.out.println(arraySum(new int[] { 1,2,3,4,-3,7 }));
		
		//System.out.println(arraySum(new int[] { 10,20,30,40,100 }));
		
		//System.out.println(arraySum(new int[] { 54,49,1,0,7,4 }));
		
		System.out.println(arraySum(new int[] { 31,2,90,50,7 }));
	}

}
