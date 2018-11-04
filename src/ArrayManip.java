

public class ArrayManip {
	
	// Creates a diff array D[] for A[] and returns
    // it after filling initial values.
    static void initializeDiffArray(int A[], int D[])
    {
         
        int n = A.length;
 
        D[0] = A[0];
        D[n] = 0;
        for (int i = 1; i < n; i++)
            D[i] = A[i] - A[i - 1];
    }
 
    // Does range update
    static void update(int D[], int l, int r, int x)
    {
        D[l] += x;
        D[r + 1] -= x;
    }
 
    // Prints updated Array
    static int printArray(int A[], int D[])
    {
        for (int i = 0; i < A.length; i++) {
             
            if (i == 0)
                A[i] = D[i];
 
            // Note that A[0] or D[0] decides
            // values of rest of the elements.
            else
                A[i] = D[i] + A[i - 1];
 
            System.out.print(A[i] + " ");
        }
         
        System.out.println();
         
        return 0;
    }
     
    // Driver Code
    public static void main(String[] args)
    {
//        // Array to be updated
//        int A[] = { 10, 5, 20, 40 };
//        int n = A.length;
//        // Create and fill difference Array
//        // We use one extra space because
//        // update(l, r, x) updates D[r+1]
//        int D[] = new int[n + 1];
//        initializeDiffArray(A, D);
// 
//        // After below update(l, r, x), the
//        // elements should become 20, 15, 20, 40
//        update(D, 0, 1, 10);
//        printArray(A, D);
// 
//        // After below updates, the
//        // array should become 20, 35, 70, 60
//        update(D, 1, 3, 20);
//        update(D, 2, 2, 30);
//         
//        printArray(A, D);
    	
    	int A[] = { 0,0,0,0,0,0,0,0,0,0 };
    	int n = A.length;
    	int D[] = new int[n + 1];
    	initializeDiffArray(A, D);
    	System.out.println("Initial array");
    	printArray(A, D);
    	
    	update(D, 0, 4, 3);
    	System.out.println("Difference array after first operation");
    	for (int i = 0; i < D.length; i++) {
    		System.out.print(D[i] + " ");
    	}
    	System.out.println();
    	System.out.println("Resultant array after first operation");
    	printArray(A, D);
    	update(D, 3, 7, 7);
    	
    	System.out.println("Difference array after second operation");
    	for (int i = 0; i < D.length; i++) {
    		System.out.print(D[i] + " ");
    	}
    	System.out.println();
    	
    	System.out.println("Resultant array after second operation");
    	printArray(A, D);
    	update(D, 5, 8, 1);
    	System.out.println("Difference array after third operation");
    	for (int i = 0; i < D.length; i++) {
    		System.out.print(D[i] + " ");
    	}
    	System.out.println();
    	
    	System.out.println("Resulting array after third operation");
    	printArray(A, D);
   
    }
    

}
