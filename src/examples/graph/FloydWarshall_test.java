package examples.graph;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FloydWarshall_test {

//    public void basicTest() {
//        FloydWarshall fw = new FloydWarshall(4);
//        double INF = Double.POSITIVE_INFINITY;
////        double[][] expected ={ {0,   5,   8,   9},
////                               {INF, 0,   3,   4},
////                               {INF, INF, 0,   1},
////                               {INF, INF, INF, 0} };
//        fw.addEdge(0, 1, 5);
//        fw.addEdge(0, 2, 9);
//        fw.addEdge(0, 3, 10);
//        fw.addEdge(1, 2, 3);
//        fw.addEdge(2, 3, 1);
//
//        double[][] result = fw.floydWarshall();
//        String errorMsg = String.format("Failure - Expected: %s Got: %s", Arrays.deepToString(expected), 
//                Arrays.deepToString(result));
//        Assert.assertArrayEquals(errorMsg, expected, result);
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader in = new BufferedReader(new FileReader("/Users/smahamka/Documents/workspace/JavaSamples/src/graph4.txt"));
			String s;

			s = in.readLine();
			String[] var = s.split(" ");
			//Graph g = new BellmanFord().getGraph(Integer.parseInt(var[0]), Integer.parseInt(var[1]));
			
			 FloydWarshall fw = new FloydWarshall(Integer.parseInt(var[0]));
		     double INF = Double.POSITIVE_INFINITY;

			while ((s = in.readLine()) != null) {

				var = s.split(" ");

				int from = Integer.parseInt(var[0])-1;
				int to = Integer.parseInt(var[1])-1;
				int wt = Integer.parseInt(var[2]);

				fw.addEdge(from, to, wt);

			}

	        double[][] result = fw.floydWarshall();
	        double intCheck=Double.MAX_VALUE;
	        
	        for(int i=0;i<result.length;i++)
	        {
	        	for(int j=0;j<result.length;j++)
	        	{
	        		//System.out.print(result[i][j] + "  ");
	        		if(result[i][j] < intCheck)
	        			intCheck = result[i][j];
	        	}
	        	
	        }
	        
	        System.out.print(intCheck);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

//    @Test
//    public void detectsNegativeCycles() {
//        FloydWarshall fw = new FloydWarshall(1);
//        double[][] expected = new double[1][1];
//        expected[0][0] = -2;
//        fw.addEdge(0, 0, -1);
//
//        double[][] result = fw.floydWarshall();
//        String errorMsg = String.format("Failure - Expected: %s Got: %s", Arrays.deepToString(expected), 
//                Arrays.deepToString(result));
//        Assert.assertArrayEquals(errorMsg, expected, result);
//        Assert.assertTrue("failure - hasNegativeCycle() should be true", fw.hasNegativeCycle());
//    }

}