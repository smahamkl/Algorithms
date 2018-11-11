package min.costpath;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class AbsolutePermutation {
	
	public static void smallestPermutation(int n, int k) {
	    int g;
	    boolean possible;

	    if(k != 0) {
	        possible = n % k == 0 && n / k % 2 == 0;
	    } else {
	        possible = true;
	    }

	    if(possible) {
	        for(int i=0; i<n; i++) {
	            g = k == 0 ? i : i / k;
	            System.out.print(i + 1 + (g % 2 == 0 ? k : -k));
	            System.out.print(" ");
	        }
	    } else {
	        System.out.print("-1");
	    }

	    System.out.println();
	}

	static HashMap<Integer, ValueCheck> numSet = new HashMap<Integer, ValueCheck>();
	static HashSet<Integer> hset = new HashSet<Integer>();
	
	static void recursiveCheck(int m, int n, int k) {
		if (m > n)
			return;
		hset.clear();
		for(ValueCheck v: numSet.values())
			hset.add(v.value);
        
		if(hset.size() == n && Collections.min(hset) == 1 && Collections.max(hset) == n)
			return;
		
		System.out.println(numSet.keySet().size());

		if ((m + k) >= 1 && (m + k) <= n) {
			if (numSet.containsKey(m)) {
				ValueCheck v = numSet.get(m);
				if (!v.isxPathCheck()) {
					v.setxPathCheck(true);
					numSet.put(m, v);
					recursiveCheck(m + 1, n, k);
				}

			} else
			{
				numSet.put(m, new ValueCheck(m + k, true, false));
				recursiveCheck(m + 1, n, k);
			}
			
		}

		if ((Math.abs(k - m) >= 1 && Math.abs(k - m) <= n)) {
			
			if (numSet.containsKey(m)) {
				ValueCheck v = numSet.get(m);
				if (!v.isyPathCheck()) {
					v.setyPathCheck(true);
					
					v.value = Math.abs(k - m);
					
					numSet.put(m, v);
					recursiveCheck(m + 1, n, k);
				}

			} else
			{
				numSet.put(m, new ValueCheck(Math.abs(k - m), false, true));
				recursiveCheck(m + 1, n, k);
			}
		}

	}

	static int[] absolutePermutation(int n, int k) {
		numSet.clear();
		int[] finalSeries = new int[n];
		recursiveCheck(1, n, k);

		return finalSeries;
	}

	public static void main(String[] args) {

		// 2 1 4 3 6 5 8 7 10 9
		//int a[] = absolutePermutation(10, 1);

		//for (int i : a)
		//	System.out.print(i + " ");
		
		smallestPermutation(10,1);

	}
}