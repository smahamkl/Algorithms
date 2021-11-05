package examples.collections.arrays;

public class Sample1 {
	
    int solution(int[] A) {
        int ans = A[0];
        for (int i = 1; i < A.length; i++) {
            if (ans > A[i]) {
                ans = A[i];
            }
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(new Sample1().solution(new int[] {-1,1,-2,2}));
		System.out.println(new Sample1().solution(new int[] {-100, -1000, 5,-20000}));
		//System.out.println(new Sample1().solution(new int[] {1,2,3,4}));
	}

}
