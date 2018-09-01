import java.util.ArrayList;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class Board1 {
	private int blocks[][];
	private int[][] goalArr;

	// construct a board from an n-by-n array of blocks
	// (where blocks[i][j] = block in row i, column j)
	public Board1(int[][] blocks) {
		this.blocks = blocks;
		// initialize my GoalArray with NxN dimensions
		goalArr = new int[blocks.length][blocks.length];
		int inc = 1;
		for (int i = 0; i < blocks.length; i++)
			for (int j = 0; j < blocks.length; j++) {
				goalArr[i][j] = inc;
				inc++;
			}
		// set the last element to 0
		goalArr[blocks.length - 1][blocks.length - 1] = 0;
	}

	// board dimension n
	public int dimension() {
		return blocks.length;
	}

	// number of blocks out of place
	public int hamming() {
		int hmDist = 0;
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {

				if (blocks[i][j] == 0)
					continue;
				else if (goalArr[i][j] != blocks[i][j])
					hmDist++;
			}
		}
		return hmDist;
	}

	// sum of Manhattan distances between blocks and goal
	public int manhattan() {
		int manDist = 0;
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {
				if (blocks[i][j] == 0)
					continue;
				else if (goalArr[i][j] != blocks[i][j]) {
					manDist += getRowColDiff(i, j, blocks[i][j]);
				}
			}
		}
		return manDist;
	}

	private int getRowColDiff(int row, int col, int element) {
		int dist = 0;
		for (int i = 0; i < goalArr.length; i++)
			for (int j = 0; j < goalArr.length; j++) {
				if (goalArr[i][j] == 0)
					continue;
				else if (goalArr[i][j] == element) {
					dist = Math.abs(row - i) + Math.abs(col - j);
					break;
				}
			}
		return dist;
	}

	// is this board the goal board?
	public boolean isGoal() {
		boolean goalReached = true;
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {
				if (goalArr[i][j] != blocks[i][j])
					return false;
			}
		}
		return goalReached;

	}

	// a board that is obtained by exchanging any pair of blocks
	public Board1 twin() {
		int[][] twinArr = goalArr;

		int randBlock1 = StdRandom.uniform(1, (dimension() * dimension() - 1));
		int randBlock2 = randBlock1 == (dimension() * dimension() - 1) ? (randBlock1 - 1) : (randBlock1 + 1);

		int row1 = ((randBlock1 / dimension()) + (randBlock1 % dimension() > 0 ? 1 : 0)) - 1;
		int col1 = Math.abs((row1) * dimension() - randBlock1) - 1;

		int row2 = ((randBlock2 / dimension()) + (randBlock2 % dimension() > 0 ? 1 : 0)) - 1;
		int col2 = Math.abs((row2) * dimension() - randBlock2) - 1;

		int tmp = twinArr[row1][col1];
		twinArr[row1][col1] = twinArr[row2][col2];
		twinArr[row2][col2] = tmp;

		return new Board1(twinArr);
	}

	// does this board equal y?
	public boolean equals(Object y) {
		if(y == null)
			return false;
		
		Board1 b = (Board1)y;
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {
				if (b.getBlocksArr()[i][j] != blocks[i][j])
					return false;
			}
		}
		return true;
	}

	// all neighboring boards
	public Iterable<Board1> neighbors() {
		ArrayList<Board1> neighbourBoards = new ArrayList<Board1>();
		int zeroRow = 0, zeroCol = 0;
		// find row & col of element 0
		for (int i = 0; i < dimension(); i++)
			for (int j = 0; j < dimension(); j++) {
				if (blocks[i][j] == 0) {
					zeroRow = i;
					zeroCol = j;
					break;
				}
			}
		int[][] tmpArr = new int[dimension()][dimension()];

		for (int i = 0; i < blocks.length; i++)
			for (int j = 0; j < blocks[i].length; j++)
				tmpArr[i][j] = blocks[i][j];

		if (zeroRow > 0) {
			tmpArr[zeroRow][zeroCol] = tmpArr[zeroRow - 1][zeroCol];
			tmpArr[zeroRow - 1][zeroCol] = 0;
			neighbourBoards.add(new Board1(tmpArr));
		}

		tmpArr = new int[dimension()][dimension()];

		for (int i = 0; i < blocks.length; i++)
			for (int j = 0; j < blocks[i].length; j++)
				tmpArr[i][j] = blocks[i][j];

		if (zeroRow < (dimension() - 1)) {
			tmpArr[zeroRow][zeroCol] = tmpArr[zeroRow + 1][zeroCol];
			tmpArr[zeroRow + 1][zeroCol] = 0;
			neighbourBoards.add(new Board1(tmpArr));
		}
		tmpArr = new int[dimension()][dimension()];
		for (int i = 0; i < blocks.length; i++)
			for (int j = 0; j < blocks[i].length; j++)
				tmpArr[i][j] = blocks[i][j];

		if (zeroCol > 0) {
			tmpArr[zeroRow][zeroCol] = tmpArr[zeroRow][zeroCol - 1];
			tmpArr[zeroRow][zeroCol - 1] = 0;
			neighbourBoards.add(new Board1(tmpArr));
		}
		tmpArr = new int[dimension()][dimension()];
		for (int i = 0; i < blocks.length; i++)
			for (int j = 0; j < blocks[i].length; j++)
				tmpArr[i][j] = blocks[i][j];

		if (zeroCol < (dimension() - 1)) {
			tmpArr[zeroRow][zeroCol] = tmpArr[zeroRow][zeroCol + 1];
			tmpArr[zeroRow][zeroCol + 1] = 0;
			neighbourBoards.add(new Board1(tmpArr));
		}
		return neighbourBoards;

	}

	// string representation of this board (in the output format specified
	// below)
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {
				sb.append(blocks[i][j] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();

	}

	public int[][] getBlocksArr() {
		return blocks;
	}

	public static void main(String[] args) {
		int i[][] = new int[][] { { 5, 2, 8 }, { 1, 0, 7 }, { 4, 3, 6 } };
		i = new int[][] { { 0, 1, 3 }, { 4, 2, 5 }, { 7, 8, 6 } };
		Board1 b = new Board1(i);
		System.out.println(b.manhattan());
		System.out.println(b.hamming());
		// System.out.println(b.twin().toString());

		System.out.println(b.toString());

		Iterator<Board1> it = b.neighbors().iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}

	}
}