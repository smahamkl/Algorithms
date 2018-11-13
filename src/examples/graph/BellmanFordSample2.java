package examples.graph;

public class BellmanFordSample2 {

	static class Edge {
		int src;
		int dest;
		int weight;
	}

	static class Graph {
		int V;
		Edge[] edge;

		public Graph(int vertices, int edges) {
			V = vertices;
			edge = new Edge[edges];
			
			for (int i = 0; i < edges; i++)
				edge[i] = new Edge();
		}

		void BellmanFord(Graph graph, int src) {

			// pick a dist array, size equal to total vertices
			int[] dist = new int[V];
			for (int i = 0; i < V; i++)
				dist[i] = Integer.MAX_VALUE;

			dist[src] = 0;

			for (int i = 0; i < V - 1; i++) {

				for (Edge e : edge) {

					if ((dist[e.src] + e.weight) < dist[e.dest])
						dist[e.dest] = dist[e.src] + e.weight;

				}
			}
			printDistances(dist);
			
			//now check for -ve weight cycles in the graph
			for (Edge e : edge) {
				if ((dist[e.src] + e.weight) < dist[e.dest])
					System.out.println("Graph contains negative weight cycle"); 
			}
			
		}

		void printDistances(int[] dist) {
			for (int i : dist)
				System.out.println(i + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int V = 5; // Number of vertices in graph
		int E = 8; // Number of edges in graph

		Graph graph = new Graph(V, E);

		// add edge 0-1 (or A-B in above figure)
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = -1;

		// add edge 0-2 (or A-C in above figure)
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 4;

		// add edge 1-2 (or B-C in above figure)
		graph.edge[2].src = 1;
		graph.edge[2].dest = 2;
		graph.edge[2].weight = 3;

		// add edge 1-3 (or B-D in above figure)
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 2;

		// add edge 1-4 (or A-E in above figure)
		graph.edge[4].src = 1;
		graph.edge[4].dest = 4;
		graph.edge[4].weight = 2;

		// add edge 3-2 (or D-C in above figure)
		graph.edge[5].src = 3;
		graph.edge[5].dest = 2;
		graph.edge[5].weight = 5;

		// add edge 3-1 (or D-B in above figure)
		graph.edge[6].src = 3;
		graph.edge[6].dest = 1;
		graph.edge[6].weight = 1;

		// add edge 4-3 (or E-D in above figure)
		graph.edge[7].src = 4;
		graph.edge[7].dest = 3;
		graph.edge[7].weight = -3;

		graph.BellmanFord(graph, 0);

	}

}
