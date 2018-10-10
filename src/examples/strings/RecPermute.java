package examples.strings;

//anagram solver is similar to this
public class RecPermute {
	static String inputstring;

	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		inputstring = "abcd";
		

		combine(0);
	}

	static void RecPermuteFunc(String soFar, String rest) {
		if (rest.isEmpty()) {
			System.out.println(soFar);
		} else {
			for (int i = 0; i < rest.length(); i++) {
				String next = soFar + String.valueOf(rest.charAt(i));
				String remaining = rest.substring(0, i) + rest.substring(i + 1);
				// System.out.println(next + " " + remaining);
				RecPermuteFunc(next, remaining);
			}
		}
	}

	static void combine(int start) {
		for (int i = start; i < inputstring.length(); ++i) {
			output.append(inputstring.charAt(i));
			System.out.println(output);
			if (i < inputstring.length())
				combine(i + 1);
			System.out.println(output.length() - 1);
			output.setLength(output.length() - 1);
		}
	}

}
