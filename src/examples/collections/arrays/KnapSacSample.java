package examples.collections.arrays;

/*
 * 0-1 Knapsack Problem | DP-10
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] 
which represent values and weights associated with n items respectively. Also given an integer W which represents knapsack capacity, 
find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
public class KnapSacSample {

	static int N = 3;

	static int findTotalValMaxWt(int[] wt, int[] val, int maxWt) {

		int result = 0;

		int[][] valArr = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if (i == 0 || j == 0) {
					valArr[i][j] = 0;
				} else if (i != j) {
					if ((wt[i - 1] + wt[j - 1]) <= maxWt) {
						valArr[i][j] = val[i - 1] + val[j - 1];
						result = Math.max(result, (val[i - 1] + val[j - 1]));
					}

				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] val = new int[] { 10, 20, 30 };
		int[] wt = new int[] { 1, 1, 1 };

		int maxWt = 2;

		System.out.println(findTotalValMaxWt(wt, val, maxWt));

	}

}
