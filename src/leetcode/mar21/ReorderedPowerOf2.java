package leetcode.mar21;

import java.util.*;

/*
 * Reordered power of 2
 * --------------------------
 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this in a way such that the resulting number is a power of 2.

 

Example 1:

Input: 1
Output: true
Example 2:

Input: 10
Output: false
Example 3:

Input: 16
Output: true
Example 4:

Input: 24
Output: false

Solution:
------------------------
Approach 1:
The very first approach is to do exactly what the problem requires us to do.

Find all possible combinations of N
Check each combination whether it is a power of N or not
But since the maximum value of N can be 10^9, creating combinations and checking whether it is a power of 2 will be time consuming

Approach 2:
Instead of creating the combinations first, we can create all the numbers which are a power of 2 (let's call it set S) and store them in an array list
We then sort the digits in ascending order of the number we are trying to reorder and the powers of 2 and do the match
To simplify further, we only need to check those numbers in S that have the same length as N. (Even if the number N is not in order, the length of the given number and the length of the power of 2 has to match. )
 */
public class ReorderedPowerOf2 {

//	public boolean checkIfPower2(int num)
//	{
//		int tmp = 1;
//		while(tmp <= num)
//		{
//			tmp = tmp << 1;
//			if((tmp & num) == num)
//				return true;
//		}
//		
//		return false;
//	}
	List<Integer> powers2;

	public ReorderedPowerOf2() {
		powers2 = new ArrayList<Integer>();
		double pow = 0;
		int tmp = 1;
		while (tmp <= Math.pow(10, 9)) {
			tmp = (int) Math.pow(2, pow);
			powers2.add(tmp);
			pow++;
		}
	}

	public void printPowersArr() {
		System.out.println(powers2);
	}

	public boolean reorderedPowerOf2(int N) {
		char[] inputStr = Integer.toString(N).toCharArray();
		Arrays.sort(inputStr);
		System.out.println(inputStr);

		int tmp = 0;

		while (tmp < powers2.size()) {
			char[] itemStr = Integer.toString(powers2.get(tmp)).toCharArray();
			if (itemStr.length == inputStr.length) {
				Arrays.sort(itemStr);
				if (Arrays.equals(itemStr, inputStr))
					return true;
			}

			if (itemStr.length > inputStr.length)
				break;

			tmp++;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorderedPowerOf2 sol = new ReorderedPowerOf2();
		// sol.printPowersArr();
		System.out.println(sol.reorderedPowerOf2(821));
//		System.out.println(sol.checkIfPower2(8));
//		System.out.println(100 ^ (20 ^ 8));
//		int num = 46;
//		//sol.printCombination(arr.toArray(new Integer[arr.size()]), arr.size(), arr.size()-1);
//		List<List<Integer>> res = sol.generatePerm(arr);
//		for(List<Integer> item: res)
//		{
//			System.out.println(item);
//		}
	}

}
