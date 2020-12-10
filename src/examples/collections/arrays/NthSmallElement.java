package examples.collections.arrays;

import java.util.Arrays;

public class NthSmallElement {
	
	    public int solution(int[] A) {
	        // write your code in Java SE 8
	         Arrays.sort(A);
	         
	         printArr(A);
	         
	         for(int i=1;i<A.length;i++)
	         {
	            if(A[i-1] > 0 && A[i] > (A[i-1] + 1))
	            {
	            	return A[i-1] + 1;
	            }
	         }
	         
	         return Math.max(1, A[A.length-1]+1);
	        
	    }

		public void printArr(int[] arr)
		{
			for(int i:arr)
			{
				System.out.print(i + " ");
			}
			System.out.println();
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NthSmallElement().solution(new int[] {1}));
	}

}
