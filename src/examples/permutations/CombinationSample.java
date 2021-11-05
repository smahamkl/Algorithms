package examples.permutations;

/*
 * Print all possible combinations of r elements in a given array of size n
Given an array of size n, generate and print all possible combinations of r elements in array. For example, if input array is {1, 2, 3, 4} and r is 2, then output should be {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.
Following are two methods to do this.

Method 1 (Fix Elements and Recur)
We create a temporary array ‘data[]’ which stores all outputs one by one. The idea is to start from first index (index = 0) in data[], one by one fix elements at this index and recur for remaining indexes. 
Let the input array be {1, 2, 3, 4, 5} and r be 3. We first fix 1 at index 0 in data[], then recur for remaining indexes, then we fix 2 at index 0 and recur. Finally, we fix 3 and recur for remaining indexes. 
When number of elements in data[] becomes equal to r (size of a combination), we print data[].

https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 */
public class CombinationSample {

	static void printCombinations(char[] arr, int r, int startIdx, String prefix) {
		if (prefix.length() == r) {
			System.out.println(prefix);
		} else if (prefix.length() < r) {
			for (int i = startIdx; i < arr.length; i++) {
				printCombinations(arr, r, i + 1, prefix + String.valueOf(arr[i]));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] arr = new char[] { '1', '2', '3', '4', '5' };
		printCombinations(arr, 2, 0, "");
	}

}
