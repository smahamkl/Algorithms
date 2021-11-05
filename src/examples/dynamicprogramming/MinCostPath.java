package examples.dynamicprogramming;

public class MinCostPath {

	static int N = 4;

	public static int minCost(int[][] costArr, int row, int col) {
		if (row == N - 1 && col == N - 1)
			return costArr[N - 1][N - 1];
		else if (row >= N || col >= N)
			return Integer.MAX_VALUE;

		return costArr[row][col] + Math.min(minCost(costArr, row + 1, col), minCost(costArr, row, col + 1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] costArr = new int[][] { { 1, 7, 9, 2 }, { 8, 6, 3, 2 }, { 1, 6, 7, 8 }, { 2, 9, 8, 2 } };

		System.out.println(minCost(costArr, 0, 0));

	}

}
