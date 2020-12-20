package leetcode.dec20problems;

import java.util.*;

/*
 * 
 Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

Solution:
-------------
A+B+C+D = 0
A+B = -(C+D)
 */

public class FourSum2 {

	public void printMap(Map<Integer, Integer> nummap) {
		Iterator<Integer> iter = nummap.keySet().iterator();

		while (iter.hasNext()) {
			int key = iter.next();
			System.out.println(key + ":" + nummap.get(key));
		}

	}

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> nummap = new HashMap<Integer, Integer>();

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int tmp = A[i] + B[j];
				if (nummap.containsKey(tmp))
					nummap.put(tmp, nummap.get(tmp) + 1);
				else
					nummap.put(tmp, 1);
			}
		}

		printMap(nummap);
		
		int res = 0;

		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int tmp = -1 * (C[i] + D[j]);
				if (nummap.containsKey(tmp))
					res += nummap.get(tmp);
			}
		}

		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourSum2 obj = new FourSum2();
		//System.out.println(
		//		obj.fourSumCount(new int[] { 1, 2 }, new int[] { -2, -1 }, new int[] { -1, 2 }, new int[] { 0, 2 }));
		System.out.println(
				obj.fourSumCount(new int[] { -1,-1 }, new int[] { -1, 1 }, new int[] { -1, 1 }, new int[] { 1,-1 }));
	}

}
