package examples.graph;

import java.util.Iterator;
import java.util.LinkedList;

/*
 * Breadth First Traversal (or Search) for a graph is similar to Breadth First Traversal of a tree (See method 2 of this post). The only catch here is, unlike trees, graphs 
 * may contain cycles, so we may come to the same node again. 
 * To avoid processing a node more than once, we use a boolean visited array. For simplicity, it is assumed that all vertices are reachable from the starting vertex.
 * For example, in the following graph, we start traversal from vertex 2. When we come to vertex 0, we look for all adjacent vertices of it. 2 is also an adjacent vertex of 0. 
 * If we don’t mark visited vertices, then 2 will be processed again and it will become a non-terminating process. A Breadth First Traversal of the following graph is 2, 0, 3, 1.
 */
public class BFSGraphSample1 {

	int V;

	LinkedList<Integer> E[];

	public BFSGraphSample1(int vertices) {
		this.V = vertices;
		E = new LinkedList[V];
		
		for (int i = 0; i < V; i++)
			E[i] = new LinkedList<>();

	}

	void addEdge(int src, int dest) {
		E[src].add(dest);
	}

	void BFS(int src) {
		boolean[] visited = new boolean[V];
		LinkedList<Integer> q = new LinkedList<>();

		visited[src] = true;
		q.add(src);

		while (q.size() > 0) {

			int cur = q.poll();

			System.out.println(cur + " ");

			Iterator list = E[cur].listIterator();

			while (list.hasNext()) {
				int j = (int) list.next();
				if (!visited[j]) {
					q.add(j);
					visited[j] = true;
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BFSGraphSample1 g = new BFSGraphSample1(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 0)");
		
		 g.BFS(0);

	}

}
