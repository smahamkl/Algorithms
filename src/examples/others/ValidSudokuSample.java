package examples.others;

import java.util.HashSet;

public class ValidSudokuSample {

	static boolean isValidSudoku(char[][] board) {
		boolean result = true;

		// One Critical optimization is to move diagonally starting with left most
		// toward bottom right side
		// this is to prevent iterate through every row and column for column wise and
		// row wise

		HashSet<Character> hsRow = new HashSet<>();
		HashSet<Character> hsCol = new HashSet<>();

		for (int i = 0, j = 0; i < board.length && j < board.length; i++, j++) {
			hsRow.clear();
			hsCol.clear();
			for (int row = 0, col = 0; row < board.length && col < board.length; row++, col++) {
				if (hsRow.contains(board[row][j]))
					return false;
				else if (board[row][j] != '.')
					hsRow.add(board[row][j]);

				if (hsCol.contains(board[i][col]))
					return false;
				else if (board[i][col] != '.')
					hsCol.add(board[i][col]);
			}

		}

		// check each internal 3x3 cells for dups
		HashSet<Character> hs = new HashSet<>();
		for (int row = 0; row < board.length; row += 3) {
			for (int col = 0; col < board.length; col += 3) {
				hs.clear();

				for (int i = row; i < row + 3; i++) {
					for (int j = col; j < col + 3; j++) {
						if (hs.contains(board[i][j]))
							return false;
						else if (board[i][j] != '.')
							hs.add(board[i][j]);
					}
				}
			}
		}

		return result;
	}

	static boolean sudokuSolver(char[][] board) {

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col] == '.') {
					for (char val = '1'; val <= '9'; val++) {
						board[row][col] = val;

						if (isValidSudoku(board) && sudokuSolver(board))
							return true;

						board[row][col] = '.';

					}
					return false;
				}
				
			}
		}

		return true;

	}

	static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] arr = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		sudokuSolver(arr);

		printBoard(arr);

		// arr = new char[][] { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
		// { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.',
		// '.', '.', '6', '.' },
		// { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.',
		// '3', '.', '.', '1' },
		// { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.',
		// '.', '2', '8', '.' },
		// { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8',
		// '.', '.', '7', '9' } };
		//
		// System.out.println(isValidSudoku(arr));
		//
		// arr = new char[][] { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
		// { '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.',
		// '3', '.', '.', '1' },
		// { '8', '.', '.', '.', '.', '.', '.', '2', '.' }, { '.', '.', '2', '.', '7',
		// '.', '.', '.', '.' },
		// { '.', '1', '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.',
		// '2', '.', '.', '.' },
		// { '.', '2', '.', '9', '.', '.', '.', '.', '.' }, { '.', '.', '4', '.', '.',
		// '.', '.', '.', '.' } };
		//
		// System.out.println(isValidSudoku(arr));

	}

}
