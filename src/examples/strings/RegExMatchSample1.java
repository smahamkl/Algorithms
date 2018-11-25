package examples.strings;

import java.util.LinkedList;

public class RegExMatchSample1 {
	static LinkedList<String> tokenList = new LinkedList<>();
	static LinkedList<String> patternTokens;

	static void strTokenize(String str) {
		String tmp = "";
		int strIdx = 0;
		char prevChar = '0';

		while (strIdx < str.length()) {
			char c = str.charAt(strIdx);

			if (c == '.') {
				if (tmp != "")
					tokenList.add(tmp);

				tmp = "";

				if (strIdx + 1 < str.length() && str.charAt(strIdx + 1) == '*') {
					tokenList.add(".*");
					strIdx += 2;
					continue;
				} else
					tokenList.add(".");

			}

			if (c == '*' && prevChar != '.') {

				if (tmp.length() > 1)
					tokenList.add(tmp.substring(0, tmp.length() - 1));

				tmp = "";
				tokenList.add(prevChar + "*");
			}

			if (c != '.' && c != '*')
				tmp += c;

			strIdx++;
			prevChar = c;

		}
		if (tmp != "")
			tokenList.add(tmp);

		patternTokens = tokenList;

	}

	static boolean regExMatch(String str, int startIdx, String regEx) {

		if (startIdx > str.length())
			return true;

		if (!regEx.contains("*") && !regEx.contains(".")) {

			int idx = str.substring(startIdx).indexOf(regEx);
			
			char curChar = '0';
			for(int i = startIdx;i<idx + startIdx;i++)
			{
				if(curChar != '0' && curChar != str.charAt(i))
					return false;
				curChar = str.charAt(i);
			}

			if (idx == -1)
				return false;
			else
				return regExMatch(str, startIdx + idx + regEx.length(),
						patternTokens.isEmpty() ? regEx : patternTokens.poll());
		} else if (regEx == "." || regEx == ".*") {

			return regExMatch(str, startIdx + 1, patternTokens.isEmpty() ? regEx : patternTokens.poll());

		} else if (regEx.contains("*")) {
			char charToMatch = regEx.charAt(0);

			if(str.substring(startIdx).charAt(startIdx) == charToMatch)
				return regExMatch(str, startIdx + 1, patternTokens.isEmpty() ? regEx : patternTokens.poll());
			else
				return regExMatch(str, startIdx, patternTokens.isEmpty() ? regEx : patternTokens.poll());

		}

		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String regexStr = "abc.*g";
		String s = "abcde";

		strTokenize(regexStr);

		LinkedList<String> str = tokenList;
		for (int i = 0; i < str.size(); i++) {
			System.out.println(str.get(i));
		}

		System.out.println(regExMatch(s, 0, patternTokens.poll()));

	}
}
