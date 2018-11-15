package examples.collections.arrays;

/*
 * The N Queen is the problem of placing N chess queens on an N�N chessboard so that no two queens attack each other. For example, following is a solution for 4 Queen problem.
 * The expected output is a binary matrix which has 1s for the blocks where queens are placed. For example, following is the output matrix for above 4 queen solution.
              { 0,  1,  0,  0}
              { 0,  0,  0,  1}
              { 1,  0,  0,  0}
              { 0,  0,  1,  0}
 */

public class NQueenProblem {

	static int n = 4;

	static boolean isSafe(int[][] board, int r, int c) {
		// upper diagonal towards left
		int row = r;
		int col = c;
		while (row >= 0 && col >= 0) {
			if (board[row][col] == 1)
				return false;
			col--;
			row--;
		}

		// lower diagonal towards left
		row = r;
		col = c;
		while (row < n && col >= 0) {
			if (board[row][col] == 1)
				return false;
			col--;
			row++;
		}
		// horizontally towards left
		row = r;
		col = c;
		while (col >= 0) {
			if (board[row][col] == 1)
				return false;
			col--;
		}

		return true;
	}

	static boolean solveNQUtil(int[][] board, int col) {
		if (col >= n)
			return true;

		for (int row = 0; row < n; row++) {
			if (isSafe(board, row, col)) {
				board[row][col] = 1;
				if (solveNQUtil(board, col + 1))
					return true;
				board[row][col] = 0;
			}
		}
		return false;
	}

	/* A utility function to print solution */
	static void printSolution(int board[][]) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		if (solveNQUtil(board, 0) == false) {
			System.out.print("Solution does not exist");

		} else
			printSolution(board);

	}

}
