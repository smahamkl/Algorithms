package min.costpath;

public class MagicSquare {

	static int[][][] magicArr = { { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } }, { { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } },
			{ { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } }, { { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } },
			{ { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } }, { { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } },
			{ { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } }, { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } } };

	// In a magic square each of the numbers between 1 to 9 has to be arranged in a
	// 3x3 matrix and every row/column and diagonal needs to be equal to 15
	// the above 3-d array(magicArray) has all possible magic square numbers
	// the solution is find the lowest cost value to transform the given matrix to one of the
	// magic square values above

	static int getMinCost(int[][] s) {
		int cost = Integer.MAX_VALUE;

		for (int width = 0; width < 8; width++) {
			int localCost = 0;
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					localCost += Math.abs(magicArr[width][row][col] - s[row][col]);
				}
			}
			cost = Math.min(localCost, cost);
		}

		return cost;
	}

	public static void main(String[] args) {
		// int[][] a = { { 5,3,4 }, {1,5,8}, {6,4,2} };

		// int[][] a = { { 4,9,2 }, {3,5,7}, {8,1,5} };

		// int[][] a = { { 4,8,2 }, {4,5,7}, {6,1,6} };
		int[][] a = { { 4, 5, 8 }, { 2, 4, 1 }, { 1, 9, 7 } };
		System.out.println(getMinCost(a));
	}

}
