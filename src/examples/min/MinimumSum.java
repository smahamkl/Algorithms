package examples.streams;

import java.util.*;
/*
 * Given an array of length n and given k number of operations
 * where each operation corresponds to choosing an item from the array dividing it by 2, and ceil it
 * to the next nearest integer and place it back into the array to the corresponding index
 * What is the minimum sum of the elements inside the array resulting from the k operations
 * The algorithm is as follows:
 * ----------------------------------------
Initialize max element to MAX_INTEGER. The first time thru this triggers the sort.
Continue processing and applying the tests until the current value is less than max value.
Then resort, reset the index and reassign a new max.
Continue until all the tests have been applied
This works well because all values are processed until the current value is less than max. 
Then it would make no sense to apply the test to the smaller value and it's time to resort.
Border cases of k = 0 or 1, entries = 0 or 1 have also been tested
https://stackoverflow.com/questions/59520626/how-to-minimize-the-sum-of-the-elements-in-the-final-array-after-performing-k-nu
 */

public class MinimumSum {
    public static long minimalSum(List<Integer> data, int ktests) {
        if (data.size() == 0) {
            return 0;
        }

        int index = 0;
        int max = Integer.MAX_VALUE;
        while (ktests > 0) {
            int currentValue = data.get(index);
            System.out.println("Max value:" + max + "  curval:" + currentValue + "  K:" + ktests + " Array:" + data.toString());
            if (currentValue <= max) {
                data.sort(Comparator.reverseOrder());
                index = 0;
                max = data.get(0) / 2;
                continue;
            }
            ktests--;

            int roundUp = currentValue & 1;
            currentValue /= 2;
            currentValue += roundUp;

            data.set(index, currentValue);
            if (index + 1 < data.size()) {
                index++;
            }
        }
        return data.stream().mapToLong(a->a).sum();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	   List<Integer> l = new ArrayList<Integer>();
	   l.add(1024);
	   l.add(1);
	   l.add(2);
	   
	   System.out.println(minimalSum(l, 6));
	  
	}

}
