package examples.graph;


//A Java program for Dijkstra's single source shortest path algorithm. 
//The program is for adjacency matrix representation of the graph 
public class DykstraShortPathSample1 {

	static final int V = 9;

	// A utility function to find the vertex with minimum distance value,
	// from the set of vertices not yet included in shortest path tree
	int getMinCostVertex(int[] dist, boolean[] visitedNodes) {
		int minVrtx = -1;
		int minDist = Integer.MAX_VALUE;
		
		for(int i=0; i<V;i++)
		{
			if(!visitedNodes[i] && dist[i] <= minDist)
			{
				minVrtx = i;
				minDist = dist[i];
			}
		}
		
		return minVrtx;
		
	}

	// Funtion that implements Dijkstra's single source shortest path 
    // algorithm for a graph represented using adjacency matrix 
    // representation 
	int[] dijkstra(int[][] graph, int src) {
		
		int[] dist = new int[V];
		boolean[] visitedNodes = new boolean[V];
		
		for(int i=0; i<V;i++)
		{
			dist[i] = Integer.MAX_VALUE;
			visitedNodes[i] = false;
		}
		
		dist[src] = 0;
		
		for(int i=0; i<V-1;i++)
		{
			int nextVertex  = getMinCostVertex(dist, visitedNodes);
			visitedNodes[nextVertex] = true;
			
			for(int j=0; j<V;j++)
			{
				if(graph[i][j] != Integer.MAX_VALUE && !visitedNodes[j] &&  (dist[nextVertex] + graph[nextVertex][j] < dist[j]) && 
						graph[nextVertex][j] != 0)
					dist[j] = dist[nextVertex] + graph[nextVertex][j];
				
			}
			
		}
		
		return dist;
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
									 { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
									 { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
									 { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
									 { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
									 { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
									 { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
									 { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
									 { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		DykstraShortPathSample1 t = new DykstraShortPathSample1();
		int[] dist = t.dijkstra(graph, 0);
		
		for(int i : dist)
		{
			System.out.println(i);
		}
	}

}
