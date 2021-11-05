package examples.strings;

public class LongestPrefixSample {

	static String longestPrefix(String[] arr) {

		int minStringLength = Integer.MAX_VALUE;

		for (String str : arr)
			minStringLength = Math.min(minStringLength, str.length());

		String tmp = arr[0];
		int length = minStringLength;

		for (int j = 1; j < arr.length; j++) {

			for (int i = 0; i < minStringLength; i++) {

				if (tmp.charAt(i) != arr[j].charAt(i)) {
					length = Math.min(length, i);
					break;
				} 

			}
		}

		return arr[0].substring(0, length);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] arr = new String[] { "walmart", "walmar", "walma" };

		System.out.println(longestPrefix(arr));
	}

}
