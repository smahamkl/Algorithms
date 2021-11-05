package examples.collections.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Interval 
{ 
    int start,end; 
    Interval(int start, int end) 
    { 
        this.start=start;
        this.end=end;
    } 
} 

public class DisjointIntervals {
	
	public void printInterval(Interval[] i)
	{
		for(Interval i1:i)
		{
			System.out.println(i1.start + "," + i1.end);
		}
	}

    public int solution(int[] A, int[] B) {
    	if(A.length <= 0 || B.length <= 0)
    		return 0;
    	
    	
    	
    	Interval[] intrvl =new Interval[A.length];
    	
        // write your code in Java SE 8
    	for(int i=0;i<A.length&&i<B.length;i++)
    	{
    		intrvl[i] = new Interval(A[i], B[i]);
    	}
    	
    	//--sort the intervals by start---------
    	Arrays.sort(intrvl,new Comparator<Interval>(){ 
            public int compare(Interval intrvl1,Interval intrvl2) 
            { 
                return intrvl1.start-intrvl2.start; 
            } 
        });
    	
    	printInterval(intrvl);
    	System.out.println("-------------------");
    	Stack<Interval> s = new Stack<Interval>();
    	Interval prev = intrvl[0];
    	int res = 0;
    	for(int i=1;i<intrvl.length;i++)
    	{
    		Interval cur = intrvl[i];
    		
    		if(cur.start <= prev.end)
    		{
    			prev = new Interval(Math.min(prev.start, cur.start), Math.max(prev.end, cur.end));
    			printInterval(new Interval[] {prev});
    		}else if(cur.start > prev.end)
    		{
    			res ++;
    			prev = cur;
    		}
    		
    	}
    	
    	return res+1;    	
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(new DisjointIntervals().solution(new int[] {1,12,42,70,36,-4,43,15}, new int[] {5,15,44,72,36,2,69,24}));
		System.out.println(new DisjointIntervals().solution(new int[] {1,1,2,3,6,7}, new int[] {1,1,4,5,8,9}));
	}

}
