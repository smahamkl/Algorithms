package examples.others;
import java.util.HashSet;
import java.util.Iterator;

public class Sample1 {
	int a;

	public static void main(String[] args) {
		HashSet<Animal> hs = new HashSet<Animal>();

		hs.add(new Animal());
		hs.add(new Animal());

		Iterator<Animal> i = hs.iterator();

		while (i.hasNext()) {
			Animal a = i.next();
			System.out.println(a);
			String s = "abc";
			String s2 = s + "def";
			String s1 = "abcdef";

			if (s2.equals(s1))
				System.out.println("equal");

			/*
			 * if (s2 == s1) System.out.println("equal");
			 */

		}

	}

}

class Animal {
	public int i = 12;

	public Animal() {
		i = 13;
	}

	@Override
	public String toString() {
		return "Animal " + i;
	}

	@Override
	public int hashCode() {
		return 1000;
	}

	@Override
	public boolean equals(Object a) {
		if (a instanceof Animal) {
			if (a.hashCode() == this.hashCode())
				return true;
		}
		return false;
	}

}