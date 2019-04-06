package examples.min.costpath;

/*
 * 
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
Min Cost Path | DP-6

Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0). 
Each cell of the matrix represents a cost to traverse through that cell. Total cost of a path to reach (m, n) is sum of all the costs on 
that path (including both source and destination). You can only traverse down, right and diagonally lower cells from a given cell, i.e., 
from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.

For example, in the following figure, what is the minimum cost path to (2, 2)?

1) Optimal Substructure
The path to reach (m, n) must be through one of the 3 cells: (m-1, n-1) or (m-1, n) or (m, n-1). So minimum cost to reach (m, n) can be written as “minimum of the 3 cells plus cost[m][n]”.

minCost(m, n) = min (minCost(m-1, n-1), minCost(m-1, n), minCost(m, n-1)) + cost[m][n]

2) Overlapping Subproblems
A Simple recursive implementation of the MCP (Minimum Cost Path) problem. The implementation simply follows the recursive structure mentioned above
 */
public class MinCostPath {

	static int N = 3;
	String path = "";

	static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

	// recursive way - overlapping problems
	static int minCostRecursive(int cost[][], int row, int col) {

		if (row < 0 || col < 0)
			return Integer.MAX_VALUE;
		if (row == 0 && col == 0)
			return cost[row][col];

		return cost[row][col] + min(minCostRecursive(cost, row - 1, col), minCostRecursive(cost, row, col - 1),
				minCostRecursive(cost, row - 1, col - 1));

	}

	// optimal MxN method
	static void minCost(int cost[][], int finalRow, int finalCol) {

		int[][] minCostArr = new int[N][N];

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				// min cost of each cell is min(left/up/upper left diagonal cell)
				if (col > 0 && row > 0) {
					minCostArr[row][col] = cost[row][col]
							+ min(minCostArr[row - 1][col - 1], minCostArr[row - 1][col], minCostArr[row][col - 1]);
				} else if (row == 0 && col > 0) {
					minCostArr[row][col] = cost[row][col] + minCostArr[row][col - 1];
				} else if (row > 0 && col == 0) {
					minCostArr[row][col] = cost[row][col] + minCostArr[row - 1][col];
				} else
					minCostArr[row][col] = cost[row][col];

			}
		}

		printArr(cost);
		System.out.println("------------------------");
		printArr(minCostArr);
	}

	static void printArr(int[][] arr) {
		for (int[] subArr : arr) {
			for (int ele : subArr) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		minCost(cost, 2, 2);

		System.out.println(minCostRecursive(cost, 2, 2));
	}

}
