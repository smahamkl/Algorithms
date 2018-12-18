package examples.others;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation2 {

	private WeightedQuickUnionUF wquf;
	private int[][] percolArr;
	private int sites;
	int bottom;
	private int top = 0;

	// create n-by-n grid, with all sites blocked
	public Percolation2(int n) {
		if (n <= 0)
			throw new java.lang.IllegalArgumentException();

		percolArr = new int[n][n];

		wquf = new WeightedQuickUnionUF(n * n + 2);
		this.sites = n;
		bottom = sites * sites + 1;
	}

	// open site (row, col) if it is not open already
	public void open(int row, int col) {
		if ((row < 1 || col < 1) || (row > sites || col > sites))
			throw new java.lang.IndexOutOfBoundsException();

		percolArr[row - 1][col - 1] = 1;

		if (row == 1) {
			wquf.union(row - 1, top);
		}
		if (row == sites) {
			wquf.union(getSerializedArrNumber(row, col), bottom);
		}

		try {
			// bottom site
			if (row > 1 && isOpen(row - 1, col)) {
				wquf.union(getSerializedArrNumber(row - 1, col), getSerializedArrNumber(row, col));
			}
		} catch (Exception ex) {

			ex.printStackTrace();
		}
		try {
			// top site
			if (row < sites && isOpen(row + 1, col)) {
				wquf.union(getSerializedArrNumber(row + 1, col), getSerializedArrNumber(row, col));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// right site
		try {
			if (col < sites && isOpen(row, col + 1)) {
				wquf.union(getSerializedArrNumber(row, col), getSerializedArrNumber(row, col + 1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// left site
		try {
			if (col > 1 && isOpen(row, col - 1)) {
				wquf.union(getSerializedArrNumber(row, col - 1), getSerializedArrNumber(row, col));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public int getSerializedArrNumber(int row, int col) {
		if (row == 1)
			return (col - 1);
		else
			return ((row - 1) * sites) + col - 1;
	}

	// is site (row, col) open?
	public boolean isOpen(int row, int col) {
		if ((row < 1 || col < 1) || (row > sites || col > sites))
			throw new java.lang.IndexOutOfBoundsException();

		if (percolArr[row - 1][col - 1] == 1)
			return true;
		else
			return false;
	}

	// is site (row, col) full?
	public boolean isFull(int row, int col) {
		if ((row < 1 || col < 1) || (row > sites || col > sites))
			throw new java.lang.IndexOutOfBoundsException();

		return false;
	}

	// does the system percolate?
//	public boolean percolates() {
//
//		for (int i = 0; i < sites; i++) {
//			int p = wquf.find((sites - 1) * sites + i);
//			if (p >= 0 && p < sites) {
//				System.out.println("Yes percolates");
//				return true;
//			}
//
//		}
//		return false;
//	}
	
	public boolean percolates() {
		return wquf.connected(top, bottom);
	}

	// test client (optional)
	public static void main(String[] args) {

		int n1 = 10;
		Percolation2 p = new Percolation2(n1);
		int row = n1;
		int col = n1;

		// p.open(4, 4);
		// p.open(2, 3);
		// p.open(2, 2);
		// p.open(4, 1);
		// p.open(1, 4);
		// p.open(2, 4);
		// p.open(4, 2);
		// p.open(2, 3);
		// p.open(3, 2);
		// p.open(3, 3);
		// p.open(4, 3);
		// p.open(4, 1);

		// boolean perc = p.percolates();
		// System.out.println(" Perculates? " + perc);
		int i=0;
		while (!p.percolates()) {
			int randRow = StdRandom.uniform(1, n1 + 1);
			int randCol = StdRandom.uniform(1, n1 + 1);
			p.open(randRow, randCol);
			System.out.println("Row:" + randRow + " Col:" + randCol + " Perculates? " + p.percolates());
			i++;
		}
		System.out.println("Total blocks: " + (n1 * n1) + " Total iterations: " + i + " Threshold: " + (((float)i/(float)(n1 * n1))));

	}

}
