package examples.others;

public class PowerNumberSample {

	static double pow(int x, int n) {
		return Math.pow(x, n);
		
/*		double result = x;
		
		for(int i=1;i<= n;i++)
		{
			result*= result;
		}
		
		return result;*/
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 100;
		int n = 100;

		System.out.println(pow(x, n));

	}

}
