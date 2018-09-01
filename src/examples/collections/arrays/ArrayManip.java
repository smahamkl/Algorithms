package examples.collections.arrays;
import java.util.Scanner;

public class ArrayManip {

	/*
	 * It's a difference array. The program stores the difference/the changes that should be made in each index and then runs a loop to add up all these changes. You increment the 
	 * lower bound because everything inbetween the lower and upper bound should be incremented but you dont want this change to continue 
	 * for the rest of the array so you decrement at (upper+1)
	 * 
	 * Given an array A[n], its difference array D is some array that satisfies D[i] = A[i] � A[i � 1] (for 1 < i <= N), and D[1] = A[1].
	 * It can be used to perform range update queries of, for instance, adding some value x to all indicies from l to r. you create the difference array, then for each query "l r x", 
	 * you perform D[l] += x, D[r + 1] -= x, and after all the queries you return to the normal array from it, by performing partial sum (A[1] = D[1], A[i] = A[i � 1] + D[i]) 
	 * and you're done. Each query was in O(1) instead of O(N).
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		//This will be the "difference array". The entry arr[i]=k indicates that arr[i] is exactly k units larger than arr[i-1]
		long[] arr = new long[n];

		int lower;
		int upper;
		long sum;

		for(int i=0;i<n;i++) arr[i]=0;

		for(int i=0;i<m;i++){
		    lower=scan.nextInt();
		    upper=scan.nextInt();
		    sum=scan.nextInt();
		    arr[lower-1]+=sum;
		    if(upper<n) arr[upper]-=sum; 
		}
		        
		long max=0;
		long temp=0;

		for(int i=0;i<n;i++){
		    temp += arr[i];
		    if(temp> max) max=temp;
		}

		System.out.println(max);
	}
}
