package examples.practice;

public class SpiralArray {

	static int totRows;
	static int totCols;

	//a boolean array to track a visited cell
	//would help to resolve 
	static void printSpiralArray(int[][] arr, int row, int col, char dir) {

		switch (dir) {
		case 'R':
			int i;
			for (i = col; i < totCols; i++) {
				System.out.print(arr[row][i] + " ");
			}
			if ((row + 1) < totRows)
				printSpiralArray(arr, row + 1, i - 1, 'D');
			break;
		case 'D':
			for (i = row; i < totRows; i++) {
				System.out.print(arr[i][col] + " ");
			}
			printSpiralArray(arr, i - 1, col - 1, 'L');
			break;
		case 'L':
			for (i = col; i >= 0; i--) {
				System.out.print(arr[row][i] + " ");
			}
			printSpiralArray(arr, row - 1, i + 1, 'U');
			break;
		case 'U':
			for (i = row; i > 0; i--) {
				System.out.print(arr[i][col] + " ");
			}
			totRows--;
			totCols--;

			printSpiralArray(arr, i + 1, col + 1, 'R');
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		// arr = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13,
		// 14, 15, 16 } };

		totRows = 3;
		totCols = 4;

		printSpiralArray(arr, 0, 0, 'R');
	}

}
