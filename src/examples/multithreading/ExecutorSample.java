package examples.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ExecutorSample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		SquareCalculator squareCalculator = new SquareCalculator();
		
		Future<Integer> f1 = squareCalculator.calculate(10);
		Future<Integer> f2 = squareCalculator.calculate(5);
		
		while(!f1.isDone() && !f2.isDone())
		{
			System.out.println("F1, F2 are still running");
			
			Thread.sleep(300);
		}
		
		System.out.println(f1.get());
		
		System.out.println(f2.get());
		
		squareCalculator.executor1.shutdown();
        
	}

}
