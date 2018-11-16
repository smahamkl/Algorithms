package examples.permutations;

/*
 * Power Set
Power Set Power set P(S) of a set S is the set of all subsets of S. For example S = {a, b, c} then P(s) = {{}, {a}, {b}, {c}, {a,b}, {a, c}, {b, c}, {a, b, c}}.
Set  = [a,b,c]
power_set_size = pow(2, 3) = 8
Run for binary counter = 000 to 111

Value of Counter            Subset
    000                    -> Empty set
    001                    -> a
    010                    -> b
    011                    -> ab
    100                    -> c
    101                    -> ac
    110                    -> bc
    111                    -> abc
 */
public class PowerSetSample1 {

	static void powerSet(int[] arr) {
		double cardinality = Math.pow(2, arr.length);

		for (int counter = 0; counter < cardinality; counter++) {
			  for(int j = 0; j < arr.length; j++) 
	            { 
	                /* Check if jth bit in the
	                counter is set If set then
	                print jth element from set */
	                if((counter & (1 << j)) > 0) 
	                    System.out.print(arr[j]);
	            }
	            System.out.println();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] { 1, 2, 3 };

		powerSet(arr);

	}

}
