package examples.practice;

import java.util.Arrays;

public class SpiralArray {

	static int totRows;
	static int totCols;
	static boolean[][] visitedCells;
	static int totLoop = 0;

	// a boolean array to track a visited cell
	// would help to resolve
	static void printSpiralArray(int[][] arr, int row, int col, char dir) {

		switch (dir) {
		case 'R':
			int i;
			for (i = col; i < totCols; i++) {
				if (!visitedCells[row][i])
					System.out.print(arr[row][i] + " ");
				visitedCells[row][i] = true;
			}
			if (!visitedCells[row + 1][i - 1])
				printSpiralArray(arr, row + 1, i - 1, 'D');
			break;
		case 'D':
			for (i = row; i < totRows; i++) {
				if (!visitedCells[i][col])
					System.out.print(arr[i][col] + " ");
				visitedCells[i][col] = true;
			}
			if (!visitedCells[i - 1][col - 1])
				printSpiralArray(arr, i - 1, col - 1, 'L');
			break;
		case 'L':
			for (i = col; i >= totLoop; i--) {
				if (!visitedCells[row][i])
					System.out.print(arr[row][i] + " ");
				visitedCells[row][i] = true;
			}
			if (!visitedCells[row - 1][i + 1])
				printSpiralArray(arr, row - 1, i + 1, 'U');
			break;
		case 'U':
			for (i = row; i > totLoop; i--) {
				if (!visitedCells[i][col])
					System.out.print(arr[i][col] + " ");
				visitedCells[i][col] = true;
			}
			totRows--;
			totCols--;
			totLoop++;

			if (!visitedCells[i + 1][col + 1])
				printSpiralArray(arr, i + 1, col + 1, 'R');
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		arr = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		arr = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 },
				{ 21, 22, 23, 24 } };
		//arr = new int[][] { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };

		totRows = 6;
		totCols = 4;

		visitedCells = new boolean[totRows][totCols];

		for (int i = 0; i < totRows; i++) {
			Arrays.fill(visitedCells[i], false);
		}

		printSpiralArray(arr, 0, 0, 'R');
	}

}
