package examples.collections.arrays;

public class ShuffleNumber {
	
    public int solution(int A) {
        // write your code in Java SE 8
    	if(A < 99)
    		return A;
    	
    	String numStr = String.valueOf(A);
    	
    	int startPtr = 0;
    	int endPtr = numStr.length()-1;
    	
    	StringBuilder res = new StringBuilder();
    	
    	while(startPtr < endPtr)
    	{
    		res.append(numStr.charAt(startPtr));
    		res.append(numStr.charAt(endPtr));
    		
    		startPtr++;
    		endPtr--;
    	}
    	
    	if(numStr.length() % 2 == 1)
    		res.append(numStr.charAt(startPtr));
    	
    	return Integer.parseInt(res.toString());
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(new ShuffleNumber().solution(99));
	}

}
