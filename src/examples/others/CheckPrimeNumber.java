package examples.others;

public class CheckPrimeNumber {

	public static boolean checkPrime(int n) {
		if (n <= 1)
			return false;
		else if (n <= 3)
			return true;
		if (n % 2 == 0)
			return false;

/*		if (n > 5) {
			int digitSum = 0;
			int k = n;
			while (k > 10) {
				digitSum += (k / 10);
				k = k % 10;
			}
			digitSum += k;
			if (k == 5)
				return false;
			else if ((digitSum % 3) == 0)
				return false;
		}*/

		for (int i = 5; i < n - 1; i++) {

			if (n % i == 0)
				return false;

		}
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 431;

		if (checkPrime(n))
			System.out.println(n + " is prime number");
		else
			System.out.println(n + " is not a prime number");
	}

}
