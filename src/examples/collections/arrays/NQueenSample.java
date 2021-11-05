package examples.collections.arrays;

public class NQueenSample {

	static int N = 4;

	static boolean isMoveValid(int[][] arr, int row, int col) {

		// horizontally towards back
		for (int j = col; j >= 0; j--) {
			if (arr[row][j] == 1)
				return false;
		}

		// diagonal top left
		for (int j = col, i = row; i >= 0 && j >= 0; i--, j--) {
			if (arr[i][j] == 1)
				return false;
		}

		// diagonal bottom left
		for (int i = row, j = col; j >= 0 && i < N; j--, i++) {
			if (arr[i][j] == 1)
				return false;
		}

		return true;
	}

	static boolean solveNQueen(int[][] arr, int col) {

		if (col < N) {

			for (int row = 0; row < N; row++) {
				if (isMoveValid(arr, row, col)) {
					arr[row][col] = 1;
					if(solveNQueen(arr, col + 1))
						return true;
					arr[row][col] = 0;
				}
				

			}
			return false;
		}

		return true;

	}

	static void printArr(int[][] arr) {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = new int[N][N];
		solveNQueen(arr, 0);
		printArr(arr);

	}

}
