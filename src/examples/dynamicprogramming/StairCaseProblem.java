package examples.dynamicprogramming;

public class StairCaseProblem {

	/*
	 * 
	 * Triple Step: A child is running up a staircase with n steps and can hop
	 * either 1 step, 2 steps, or 3 steps at a time. Implement a method to count how
	 * many possible ways the child can run up the stairs.
	 */	
	static int totalPossibilities(int steps, int stepsRemaining) {
		if (stepsRemaining == 0)
			return 1;
		else if (stepsRemaining == 1)
			return 1;
		else if (stepsRemaining == 2)
			return 2;
		else {
			return totalPossibilities(steps, stepsRemaining - 1) + totalPossibilities(steps, stepsRemaining - 2) + totalPossibilities(steps, stepsRemaining - 3);
		}
	}
	
	//using memoization technique with o(n) time complexity
	//the logic is that its a fibonacci series - stairs(n) = fibo(n+1)
	static int totalPossibilitiesMemo(int steps) {
		
		int possibilities = 0;
		
		if (steps <= 0)
			return 0;
		else if (steps == 1)
			return 1;
		else if (steps == 2)
			return 2;
		else {
			int a = 1;
			int b = 1;
			int c = 2;
			
			for(int i=3;i<=steps;i++)
			{
				possibilities = a + b + c;
				a = b;
				b = c;
				c = possibilities;
			}
		}
		return possibilities;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(totalPossibilities(4, 4));
		System.out.println(totalPossibilitiesMemo(4));

	}

}
