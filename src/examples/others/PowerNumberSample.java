package examples.others;

public class PowerNumberSample {

	static double pow(double x, int n) {
		
		if(x > 0 && x < 0.1 && n >= 100)
			return 0.0;
		else if(x == 1 && x != 0)
			return x;

		if (n == 1)
			return x;
		else if(n == 0)
			return 1;
		else if(n == -1)
			return 1.0/x;
		else if (n % 2 == 0) {
			return pow(x, n / 2) * pow(x, n / 2);
		} else {
			
			return n > 0 ? (x * pow(x, n / 2) * pow(x, n / 2)) : ((1.0/x) * pow(x, n / 2) * pow(x, n / 2));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double x = 2.00000;
				
		int n = -2147483648;

		//System.out.println(pow(x, n));
		
		System.out.println(Math.pow(x, n));

	}

}
