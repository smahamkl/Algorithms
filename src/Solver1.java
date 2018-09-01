import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.MinPQ;

public class Solver1 {

	private ArrayList<Board1> solArr;
	private Board1 initial;
	private int moves;

	public Solver1(Board1 initial) {

		if (initial == null)
			throw new java.lang.NullPointerException();

		solArr = new ArrayList<Board1>();
		this.initial = initial;
	}

	public boolean isSolvable() {

		int inversions = 0;
		
		//A pair of tiles form an inversion if the the values on tiles are in reverse order of their appearance in goal state. 
		//For example, the following instance of 8 puzzle has two inversions, (8, 6) and (8, 7).
		//1  2  3
		//4     5
		//8  6  7
		//Game is solvable if inversion count is even.

		for (int i = 1; i <= (initial.dimension() * initial.dimension()); i++) {
			for (int j = i + 1; j <= (initial.dimension() * initial.dimension()); j++) {
				int row1 = ((i / initial.dimension()) + (i % initial.dimension() > 0 ? 1 : 0)) - 1;
				int col1 = Math.abs((row1) * initial.dimension() - i) - 1;
				int row2 = ((j / initial.dimension()) + (j % initial.dimension() > 0 ? 1 : 0)) - 1;
				int col2 = Math.abs((row2) * initial.dimension() - j) - 1;
				if (initial.getBlocksArr()[row1][col1] == 0 || initial.getBlocksArr()[row2][col2] == 0)
					continue;

				if (initial.getBlocksArr()[row1][col1] > initial.getBlocksArr()[row2][col2])
					inversions++;
			}
		}
		if (inversions % 2 == 1)
			return false;
		else
			return true;
	}

	public int moves() {
		return moves;
	}

	public Iterable<Board1> solution() {
		solArr.add(initial);
		Board1 tmp = initial;
		Comparator<Board1> comparator = new BoardComparator();
		MinPQ<Board1> queue = new MinPQ<Board1>(10, comparator);

		while (!tmp.isGoal() && moves < 200) {
			Iterator<Board1> it = tmp.neighbors().iterator();
			while (it.hasNext()) {
				Board1 cur = it.next();
				if (!solArr.contains(cur))
					queue.insert(cur);
			}
			

			tmp = queue.delMin();
			solArr.add(tmp);
			moves++;
		}

		return solArr;
	}

	private class BoardComparator implements Comparator<Board1> {
		@Override
		public int compare(Board1 x, Board1 y) {
			if ((x.manhattan()) < (y.manhattan())) {
				return -1;
			}
			if ((x.manhattan()) > (y.manhattan())) {
				return 1;
			}
			return 0;
		}
	}

	public static void main(String[] args) {

		int i[][] = new int[][] { { 5, 2, 8 }, { 4, 1, 7 }, { 0, 3, 6 } };
		//i = new int[][] { { 0, 1, 3 }, { 4, 2, 5 }, { 7, 8, 6 } };
		// i = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 8, 7, 0 } };
		// Board b = new Board(i);
		//
		// Solver solver = new Solver(b);

		// In in = new In(args[0]);
		// int n = in.readInt();
		// int[][] blocks = new int[n][n];
		// for (int i = 0; i < n; i++)
		// for (int j = 0; j < n; j++)
		// blocks[i][j] = in.readInt();
		Board1 initial = new Board1(i);

		// solve the puzzle
		Solver1 solver = new Solver1(initial);

		// print solution to standard output
		if (!solver.isSolvable())
			StdOut.println("No solution possible");
		else {
			for (Board1 board : solver.solution())
				StdOut.println(board);
			StdOut.println("Minimum number of moves = " + solver.moves());
		}
	}

}
