package examples.strings;

import java.util.HashMap;
import java.util.Scanner;

public class StringQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);

		int totalString = s.nextInt();

		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		for (int i = 0; i < totalString; i++) {

			String str = s.next();

			if (hm.containsKey(str))
				hm.put(str, new Integer(hm.get(str).intValue() + 1));
			else
				hm.put(str, new Integer(1));
		}

		int totalQry = s.nextInt();

		for (int i = 0; i < totalQry; i++) {
			String tmp = s.next();

			if (hm.containsKey(tmp))
				System.out.println(hm.get(tmp).intValue());
			else
				System.out.println(0);
		}

	}

}
