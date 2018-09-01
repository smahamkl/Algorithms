package min.costpath;

public class MinCostPath {

	static int finalRow;
	static int finalCol;

	static int minCostPath(int[][] costArr, int curRow, int curCol) {

		int curCost = costArr[curRow][curCol];

		if (curRow == finalRow && curCol == finalCol)
			return curCost;
		else if (curRow == finalRow && curCol < finalCol)
			return (curCost + minCostPath(costArr, curRow, curCol + 1));
		else if (curRow < finalRow && curCol == finalCol)
			return (curCost + minCostPath(costArr, curRow + 1, curCol));
		else
			return (Math.min(curCost + minCostPath(costArr, curRow + 1, curCol),
					Math.min(curCost + minCostPath(costArr, curRow, curCol + 1),
							curCost + minCostPath(costArr, curRow + 1, curCol + 1))));
	}

	public static void main(String[] args) {
		int costArr[][] = { { 1, 2, 3 }, { 4, 1, 2 }, { 1, 5, 3 } };

		finalRow = 1;
		finalCol = 1;

		int ret = minCostPath(costArr, 0, 0);

		System.out.println(ret);
	}

}
