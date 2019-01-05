package examples.strings;

import java.util.Arrays;
import java.util.Comparator;
/*
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330. 
(Note: The result may be very large, so you need to return a string instead of an integer.)

This problem can be solved by sorting strings, not sorting integer. 
Define a comparator to compare strings by concat() right-to-left or left-to-right.
 */

public class LargestNumberString {

	static String largestString(int[] arr) {

		String[] strArr = new String[arr.length];

		for (int i = 0; i < arr.length; i++)
			strArr[i] = String.valueOf(arr[i]);

		Arrays.sort(strArr, new Comparator<String>() {

			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		});

		StringBuilder s = new StringBuilder();

		for (String tmp : strArr) {
			s.append(tmp);
		}

		return s.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] { 3, 30, 34, 5, 9 };

		System.out.println(largestString(arr));

	}

}
