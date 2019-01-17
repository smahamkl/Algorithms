package examples.others;

public class ReverseInteger {

	static int reverseInteger(int nbr) {
		int reverse = 0;
		int m = 1;

		if (nbr < 0) {
			m = -1;
			nbr = nbr * m;
		}

		//need to check for the number overflow
		while (nbr > 0) {
			if ((reverse * 10 + nbr % 10) >= Integer.MAX_VALUE)
				return 0;
			else
				reverse = reverse * 10 + nbr % 10;
			nbr = nbr / 10;
		}

		return reverse * m;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(reverseInteger(1534236469));

	}

}
