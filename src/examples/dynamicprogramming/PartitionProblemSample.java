package examples.dynamicprogramming;

import java.util.ArrayList;

/*
 * 
 * Following are the two main steps to solve this problem:
1) Calculate sum of the array. If sum is odd, there can not be two subsets with equal sum, so return false.
2) If sum of array elements is even, calculate sum/2 and find a subset of array with sum equal to sum/2.

The first step is simple. The second step is crucial, it can be solved either using recursion or Dynamic Programming.

Recursive Solution
Following is the recursive property of the second step mentioned above.

Let isSubsetSum(arr, n, sum/2) be the function that returns true if 
there is a subset of arr[0..n-1] with sum equal to sum/2

The isSubsetSum problem can be divided into two subproblems
 a) isSubsetSum() without considering last element 
    (reducing n to n-1)
 b) isSubsetSum considering the last element 
    (reducing sum/2 by arr[n-1] and n to n-1)
If any of the above the above subproblems return true, then return true. 
isSubsetSum (arr, n, sum/2) = isSubsetSum (arr, n-1, sum/2) ||
                              isSubsetSum (arr, n-1, sum/2 - arr[n-1])
 */

public class PartitionProblemSample {

	static ArrayList<Integer> numList = new ArrayList<>();

	static boolean findPartitions(int[] arr, int totSum, int n) {

		if (n < 0 && totSum != 0)
			return false;
		else if (n <= 0 && totSum == 0) {
			return true;
		}

		if (arr[n] > totSum) {
			return findPartitions(arr, totSum, n - 1);
		} else {
			if (findPartitions(arr, totSum, n - 1)) {
				numList.add(arr[n]);
				return true;
			} else if (findPartitions(arr, (totSum - arr[n]), n - 1)) {
				numList.add(arr[n]);
				return true;
			}

			return false;

		}

	}

	/*
	 * Dynamic Programming Solution
The problem can be solved using dynamic programming when the sum of the elements is not too big. 
We can create a 2D array part[][] of size (sum/2)*(n+1). And we can construct the solution in bottom 
up manner such that every filled entry has following property

part[i][j] = true if a subset of {arr[0], arr[1], ..arr[j-1]} has sum 
             equal to i, otherwise false
  https://www.youtube.com/watch?v=s6FhG--P7z0
	 */
	static boolean findPartition(int arr[], int n) {
		int sum = 0;
		int i, j;

		// Caculcate sun of all elements
		for (i = 0; i < n; i++)
			sum += arr[i];

		if (sum % 2 != 0)
			return false;

		boolean part[][] = new boolean[sum / 2 + 1][n + 1];

		// initialize top row as true
		for (i = 0; i <= n; i++)
			part[0][i] = true;

		// initialize leftmost column, except part[0][0], as false
		for (i = 1; i <= sum / 2; i++)
			part[i][0] = false;

		// Fill the partition table in botton up manner
		for (i = 1; i <= sum / 2; i++) {
			for (j = 1; j <= n; j++) {
				part[i][j] = part[i][j - 1];
				if (i >= arr[j - 1])
					part[i][j] = part[i][j] || part[i - arr[j - 1]][j - 1];
			}
		}
		
		printArr(part);

		return part[sum / 2][n];
	}

	static void printArr(boolean[][] arr) {
		for (boolean[] i : arr) {
			for (boolean j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	static void printArr(ArrayList<Integer> arr) {
		for (int j : arr) {
			System.out.print(j + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[] arr = new int[] { 3, 1, 1, 2, 2, 1 };

		int[] arr = new int[] { 2, 2, 1, 1, 3, 1 };

		//System.out.println(findPartitions(arr, 5, arr.length - 1));

		//printArr(numList);
		
		System.out.println(findPartition(arr, arr.length));

	}

}
