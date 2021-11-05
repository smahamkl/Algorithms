package examples.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> names = Arrays.asList("siva", "gayathri", "sai", "pavan", "someother");

		List<String> names1 = names.stream().filter(name -> !"someother".equals(name)).collect(Collectors.toList());

		names1.forEach(System.out::println);

	}

}
