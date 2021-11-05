package examples.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {

	public ExecutorService executor = Executors.newSingleThreadExecutor();
	public ExecutorService executor1 = Executors.newFixedThreadPool(10);

	public Future<Integer> calculate(Integer input) {
		return executor1.submit(() -> {
			Thread.sleep(1000);
			return input * input;
		});
	}

}
