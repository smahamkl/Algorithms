package examples.others;
import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {

	private int totalLineSegments = 0;
	private ArrayList<LineSegment> lsArr = null;
	private ArrayList<Point> pArr = null;

	public BruteCollinearPoints(Point[] points) {
		lsArr = new ArrayList<LineSegment>();
		pArr = new ArrayList<Point>();

		if (points == null)
			throw new java.lang.NullPointerException();
		else if (points.length < 4)
			return;

		for (Point p : points) {
			if (p == null)
				throw new java.lang.NullPointerException();

			if (pArr.contains(p))
				throw new java.lang.IllegalArgumentException();
			else
				pArr.add(p);
		}
		pArr.clear();

		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				for (int k = i + 2; k < points.length; k++) {
					for (int l = i + 3; l < points.length; l++) {

						if (points[i].compareTo(points[j]) == 0 || points[i].compareTo(points[k]) == 0
								|| points[i].compareTo(points[l]) == 0)
							continue;

						if (points[i].slopeOrder().compare(points[j], points[k]) == 0
								&& points[i].slopeTo(points[l]) == points[i].slopeTo(points[j])) {
							Point[] pTmp = new Point[] { points[i], points[j], points[k], points[l] };
							Arrays.sort(pTmp);
							totalLineSegments++;
							LineSegment ls = new LineSegment(pTmp[0], pTmp[3]);
							if (!lsArr.contains((ls))) {
								lsArr.add(ls);
								i += 4;
								j += 3;
								k += 2;
								l++;
							}
						}
					}

				}
			}

		}

	}

	public int numberOfSegments() {
		return totalLineSegments;
	}

	public LineSegment[] segments() {
		// return (LineSegment[]) lsArr.toArray(new LineSegment[]);

		LineSegment[] ls = new LineSegment[lsArr.size()];

		for (int i = 0; i < lsArr.size(); i++) {
			ls[i] = lsArr.get(i);
		}

		return ls;
	}

	public static void main(String[] args) {
		In in = new In("/home/sivam/Downloads/collinear/input6.txt");
		int n = in.readInt();
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
		}

		// draw the points
		/*
		 * StdDraw.enableDoubleBuffering(); StdDraw.setXscale(0, 32768);
		 * StdDraw.setYscale(0, 32768); for (Point p : points) { p.draw(); }
		 * StdDraw.show();
		 */

		// print and draw the line segments
		BruteCollinearPoints collinear = new BruteCollinearPoints(points);
		for (LineSegment segment : collinear.segments()) {
			StdOut.println(segment);
			segment.draw();
		}
		StdDraw.show();
	}
}