package leetcode.dec20problems;

import java.util.*;

public class FourSum2 {
	
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    	Arrays.sort(A);
    	Arrays.sort(B);
    	Arrays.sort(C);
    	Arrays.sort(D);
    	
    	int i=0,j=0,k=0,l=0,res = 0;
    	
    	while(i < A.length && j < B.length && k < C.length && l < D.length)
    	{

    		if(A[i] + B[j] + C[k] + D[l] == 0)
    			res++;
    		
    		if(i+1 < A.length && (A[i+1] + B[j] + C[k] + D[l] <= 0))
    			i++;
    		else if(j+1 < B.length && (A[i] + B[j+1] + C[k] + D[l] <= 0))
    			j++;
    		else if(k+1 < C.length && (A[i] + B[j] + C[k+1] + D[l] <= 0))
    			k++;
    		else if(l+1 < D.length && (A[i] + B[j] + C[k] + D[l+1] <= 0))
    			l++;
    		else
    			break;
    		
    	}
    	
   	
    	return res;    	
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourSum2 obj = new FourSum2();
		System.out.println(obj.fourSumCount(new int[] {1, 2}, new int[] {-2,-1}, new int[] {-1,2}, new int[] {0,2} ));
	}

}
