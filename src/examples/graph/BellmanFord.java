package examples.graph;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BellmanFord {

	public Graph getGraph(int vertices, int edges) {
		return new Graph(vertices, edges);
	}

	private class Graph {
		int vertices;
		int edges;
		HashMap<Vertex, ArrayList<Edge>> hmapVrtx;

		public Graph(int vertices, int edges) {
			this.vertices = vertices;
			this.edges = edges;
			hmapVrtx = new HashMap<Vertex, ArrayList<Edge>>();

			for (int i = 1; i <= vertices; i++) {
				Vertex v = new Vertex(i);
				if (i == 1)
					v.setFirstNode(true);
				else
					v.setFirstNode(false);

				if (v.isFirstNode)
					v.setSPLength(0);
				else
					v.setSPLength(Integer.MAX_VALUE);

				if (!hmapVrtx.containsKey(v))
					hmapVrtx.put(v, new ArrayList<Edge>());

			}
		}

		public Vertex getVertexObj(int vrtx) {
			for (Vertex key : hmapVrtx.keySet()) {
				if (key.vrtxNum == vrtx)
					return key;
			}
			return null;

		}

		private class Edge {
			public Vertex headVrtx;
			public Vertex tailVrtx;
			public int length;

			public Edge(Vertex headVrtx, Vertex tailVrtx, int length) {
				this.headVrtx = headVrtx;
				this.tailVrtx = tailVrtx;
				this.length = length;
			}

			@Override
			public boolean equals(Object other) {
				if (other == null)
					return false;
				if (other == this)
					return true;
				if (!(other instanceof Edge))
					return false;

				if ((((Edge) other).headVrtx == ((Edge) this).headVrtx)
						&& (((Edge) other).tailVrtx == ((Edge) this).tailVrtx))
					return true;

				return false;

			}

			@Override
			public int hashCode() {
				return this.headVrtx.vrtxNum + this.tailVrtx.vrtxNum;
			}
		}

		private class Vertex {
			public int vrtxNum;
			private int spLength;
			private boolean isFirstNode = false;

			public boolean isFirstNode() {
				return isFirstNode;
			}

			public void setFirstNode(boolean isFirstNode) {
				this.isFirstNode = isFirstNode;
			}

			public Vertex(int vrtxNum) {
				this.vrtxNum = vrtxNum;
			}

			public void setSPLength(int length) {
				this.spLength = length;
			}

			@Override
			public boolean equals(Object other) {
				if (other == null)
					return false;
				if (other == this)
					return true;
				if (!(other instanceof Vertex))
					return false;

				if (((Vertex) other).vrtxNum == ((Vertex) this).vrtxNum)
					return true;

				return false;

			}

			@Override
			public int hashCode() {
				return this.vrtxNum;
			}
		}

		public void addEdge(int headVrtxNum, int tailVrtxNum, int vrtxLength) {

			ArrayList<Edge> edgeList = null;

			Vertex headVrtx = getVertexObj(headVrtxNum);
			Vertex tailVrtx = getVertexObj(tailVrtxNum);

			if (headVrtx != null)
				edgeList = hmapVrtx.get(headVrtx);

			edgeList.add(new Edge(headVrtx, tailVrtx, vrtxLength));

			hmapVrtx.put(headVrtx, edgeList);

		}

		public int computeShortestPath() {

//			for (Vertex key : hmapVrtx.keySet())
//				System.out.println(
//						key.isFirstNode + " " + key.vrtxNum + " " + key.spLength + " " + hmapVrtx.get(key).size());

			System.out.println("----------------------------------------");

			for (int i = 1; i < vertices; i++) {

				for (Vertex key : hmapVrtx.keySet()) {

					ArrayList<Edge> edgList = hmapVrtx.get(key);

					if (key.spLength != Integer.MAX_VALUE) {

						for (int j = 0; j < edgList.size(); j++) {
							Edge e = edgList.get(j);

							if ((e.tailVrtx.spLength == Integer.MAX_VALUE)
									|| ((e.length + key.spLength) < e.tailVrtx.spLength)) {

								e.tailVrtx.spLength = e.length + key.spLength;

							}
						}

					}

				}

			}
			for (Vertex key : hmapVrtx.keySet()) {

				ArrayList<Edge> edgList = hmapVrtx.get(key);

				if (key.spLength != Integer.MAX_VALUE) {

					for (int j = 0; j < edgList.size(); j++) {
						Edge e = edgList.get(j);

						if ((e.tailVrtx.spLength == Integer.MAX_VALUE)
								|| ((e.length + key.spLength) < e.tailVrtx.spLength)) {

							System.out.println("Negative cycle detected");

						}
					}

				}

			}

			for (Vertex key : hmapVrtx.keySet())
				System.out.println(
						key.isFirstNode + " " + key.vrtxNum + " " + key.spLength);

			return 0;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader in = new BufferedReader(new FileReader("src/graph4.txt"));
			String s;

			s = in.readLine();
			String[] var = s.split(" ");
			Graph g = new BellmanFord().getGraph(Integer.parseInt(var[0]), Integer.parseInt(var[1]));

			while ((s = in.readLine()) != null) {

				var = s.split(" ");

				int from = Integer.parseInt(var[0]);
				int to = Integer.parseInt(var[1]);
				int wt = Integer.parseInt(var[2]);

				g.addEdge(from, to, wt);

			}
			g.computeShortestPath();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
