package examples.graph;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

public class BreadthFirstSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal ");

		// new Graph(4).bfs(4, 6, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 0 },
		// { 2, 3 }, { 3, 3 } }, 2);
		new Graph(4).bfs(4, 2, new int[][] { { 1, 2 }, { 1, 3 } }, 1);
		//new Graph(3).bfs(3, 1, new int[][] { { 2, 3 } }, 2);
		//new Graph(10).bfs(10, 6, new int[][] { { 3,1 }, { 10, 1 }, {10,1},{3,1}, {1,8}, {5,2} }, 3);
	}

}

/*
 * class Node { int vertex; int level = -1;
 * 
 * public Node(int v) { vertex = v; } }
 */

class Graph {
	static int vertices;
	static LinkedList<Integer> list[];

	public Graph(int v) {
		vertices = v;
		list = new LinkedList[vertices+1];

		for (int i = 0; i <= vertices; i++) {
			list[i] = new LinkedList<Integer>();
		}
	}


	static int[] bfs(int n, int m, int[][] edges, int s) {

		Graph g = new Graph(n);

		for (int i = 0; i < m; i++) {
			list[edges[i][0]].add(edges[i][1]);
			//also add reverse path as well(non directed graph)
			list[edges[i][1]].add(edges[i][0]);
		}

		return BFS(s);
	}

	static int[] BFS(int s1) {
		boolean[] visited = new boolean[vertices + 1];
		int[] wtArr = new int[vertices];
		int[] finalArr = new int[vertices-1];

		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(s1);
		visited[s1] = true;
		int lvl = 0;
		wtArr[s1 - 1] = 0;

		while (!q.isEmpty()) {
			int s = q.poll();

			if (s < list.length) {
				Iterator<Integer> i = list[s].iterator();

				if (i.hasNext())
					lvl++;

				while (i.hasNext()) {
					int ele = i.next();

					if (!visited[ele]) {
						visited[ele] = true;
						q.add(ele);
						if (ele != s1)
							wtArr[ele - 1] = lvl;

					}
				}
			}

		}

		int j=0;
		for (int i = 0; i < vertices; i++) {
			if (i != s1 - 1) {
				int tempWt = wtArr[i] > 0 ? (6 * wtArr[i]) : -1;
				System.out.println(s1 + "->" + (i + 1) + ":" + tempWt);
				finalArr[j] = tempWt;
				j++;
			}
		}
		return finalArr;

	}
}
