package examples.practice;

import java.util.HashSet;

public class ValidSudokuSample {

	static boolean isValidSudoku(char[][] board) {
		boolean result = true;

		//One Critical optimization is to move diagonally starting with left most toward bottom right side
		//and to prevent doing it seperately for column wise and row wise
		// first column wise check for dups
		for (int row = 0; row < board.length; row++) {
			HashSet<Character> hs = new HashSet<>();
			hs.clear();

			for (int col = 0; col < board.length; col++) {
				if (hs.contains(board[row][col]))
					return false;
				else if (board[row][col] != '.')
					hs.add(board[row][col]);
			}
		}

		// first row wise check for dups
		for (int col = 0; col < board.length; col++) {
			HashSet<Character> hs = new HashSet<>();
			hs.clear();

			for (int row = 0; row < board.length; row++) {
				if (hs.contains(board[row][col]))
					return false;
				else if (board[row][col] != '.')
					hs.add(board[row][col]);
			}
		}

		// check both diagonal ways
		for (int row = 0; row < board.length; row += 3) {
			HashSet<Character> hs = new HashSet<>();
			hs.clear();

			for (int col = 0; col < board.length; col += 3) {

				// diagonal towards right down
				for (int i = row, j = col; (i < row + 3 && j < col + 3); i++, j++) {
					if (hs.contains(board[i][j]))
						return false;
					else if (board[i][j] != '.')
						hs.add(board[i][j]);
				}
				// diagonal towards left down - no need to visit the center cell again since it
				// has been visited earlier in previous cycle
				if (hs.contains(board[row][col + 2]))
					return false;
				else if (board[row][col + 2] != '.')
					hs.add(board[row][col + 2]);

				// bottom row left most
				if (hs.contains(board[row + 2][col]))
					return false;
				else if (board[row + 2][col] != '.')
					hs.add(board[row + 2][col]);

				// top row middle col
				if (hs.contains(board[row][col + 1]))
					return false;
				else if (board[row][col + 1] != '.')
					hs.add(board[row][col + 1]);

				// middle row left most
				if (hs.contains(board[row + 1][col]))
					return false;
				else if (board[row + 1][col] != '.')
					hs.add(board[row + 1][col]);

				// middle row right most
				if (hs.contains(board[row + 1][col + 2]))
					return false;
				else if (board[row + 1][col + 2] != '.')
					hs.add(board[row + 1][col + 2]);

				// bottom row middle col
				if (hs.contains(board[row + 2][col + 1]))
					return false;
				else if (board[row + 2][col + 1] != '.')
					hs.add(board[row + 2][col + 1]);

				hs.clear();

			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] arr = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		System.out.println(isValidSudoku(arr));

		arr = new char[][] { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		System.out.println(isValidSudoku(arr));

		arr = new char[][] { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
				{ '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
				{ '8', '.', '.', '.', '.', '.', '.', '2', '.' }, { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
				{ '.', '1', '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
				{ '.', '2', '.', '9', '.', '.', '.', '.', '.' }, { '.', '.', '4', '.', '.', '.', '.', '.', '.' } };

		System.out.println(isValidSudoku(arr));

	}

}
