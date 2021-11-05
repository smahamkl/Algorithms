package examples.collections.arrays;

public class DeletionCost {
	
    public int solution(String S, int[] C) {
        // write your code in Java SE 8
    	char[] chrArr = S.toCharArray();
    	
    	int cost = 0;
    	for(int i=1;i<chrArr.length;i++)
    	{
    		if(chrArr[i] == chrArr[i-1] && chrArr[i-1] != '*')
    		{
    			cost += C[i-1];
    			chrArr[i-1] = '*';
    		}
    	}
    	return cost;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeletionCost sol = new DeletionCost();
//		System.out.println(sol.solution("abccbd", new int[] {0,1,2,3,4,5}));
//		System.out.println(sol.solution("aabbcc", new int[] {1,2,1,2,1,2}));
//		System.out.println(sol.solution("aaaa", new int[] {3,4,5,6}));
		System.out.println(sol.solution("aaaaaaaaabb", new int[] {1,1,1,1,1,1,1,1,1,1,100}));
		//System.out.println(sol.solution("", new int[] {}));

	}

}
