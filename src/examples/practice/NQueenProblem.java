package examples.practice;

public class NQueenProblem {

	static int N = 4;

	static boolean isValidPos(int[][] board, int row, int col) {

		// horizontally
		for (int c = col; c >= 0; c--) {
			if (board[row][c] == 1)
				return false;
		}
		// bottom left
		for (int r = row, c = col; c >= 0 && r < N; r++, c--) {
			if (board[r][c] == 1)
				return false;

		}

		// top left
		for (int r = row, c = col; c >= 0 && r >= 0; r--, c--) {
			if (board[r][c] == 1)
				return false;
		}

		return true;

	}

	//be careful about the return statements -  recursive program needs to have 
	//proper return statements in all pathways
	//this is typical backtracking problem which initially sets a bit flag(1) and move forwards to next column(next queen)
	//if at any point encounters any valid moves it should go back unset the bit flag(to 0) that it has set previously
	static boolean solveNQueen(int[][] board, int c) {

		if (c < N) {
			for (int r = 0; r < N; r++) {
				if (isValidPos(board, r, c)) {
					board[r][c] = 1;

					if (solveNQueen(board, c + 1))
						return true;

					board[r][c] = 0;
				}

			}
			return false;
		}else
			return true;

	}

	static void printBoard(int[][] board) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(board[r][c] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] board = new int[N][N];

		solveNQueen(board, 0);

		printBoard(board);

	}

}
