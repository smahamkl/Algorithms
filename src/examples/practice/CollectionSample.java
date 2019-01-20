package examples.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class CollectionSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<String> hs = new HashSet<>(Arrays.asList("B", "C", "A"));

		Iterator<String> it = hs.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("----------------------------");
		
		LinkedHashSet<String> lhs = new LinkedHashSet<>(hs);
		
		it = lhs.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("----------------------------");
		
		lhs = new LinkedHashSet<>(Arrays.asList("B", "C", "A"));
		
		it = lhs.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
