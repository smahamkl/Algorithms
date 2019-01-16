package examples.others;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nbr = 123456;

		int reverse = 0;

		while (nbr > 0) {
			reverse = reverse * 10 + nbr % 10;
			nbr = nbr / 10;
		}

		System.out.println(reverse);

	}

}
