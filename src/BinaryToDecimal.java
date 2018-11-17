
public class BinaryToDecimal {

	static String getDecimalValue(String nbr) {
		int result = 0;
		int next = 1;
		for (int i = nbr.length()-1; i >= 0; i--) {
			result += (nbr.charAt(i) - '0') * next;
			next = next * 2;
		}

		return "" + result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getDecimalValue("1000"));

	}

}
