package examples.strings;

/*
 * What are the subproblems in this case?
The idea is process all characters one by one staring from either from left or right sides of both strings.
Let us traverse from right corner, there are two possibilities for every pair of character being traversed.

m: Length of str1 (first string)
n: Length of str2 (second string)
If last characters of two strings are same, nothing much to do. Ignore last characters and get count for remaining strings. 
So we recur for lengths m-1 and n-1.
Else (If last characters are not same), we consider all operations on ‘str1’, consider all three operations on last 
character of first string, recursively compute minimum cost for all three operations and take minimum of three values.
Insert: Recur for m and n-1
Remove: Recur for m-1 and n
Replace: Recur for m-1 and n-1
 */
public class EditDistanceSample {

	static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

	//The time complexity of below solution is exponential. In worst case, we may end up doing O(3m) operations. 
	//The worst case happens when none of characters of two strings match. Below is a recursive call diagram for worst case.
	static int editDistance(String str1, String str2, int m, int n) {

		if (m == 0)
			return n;
		else if (n == 0)
			return m;

		// first case - nothing much to do so
		// recurse strings without the last character
		if (str1.charAt(m) == str2.charAt(n))
			return editDistance(str1, str2, m - 1, n - 1);
		else
		{
			 // If last characters are not same, consider all three 
		    // operations on last character of first string, recursively 
		    // compute minimum cost for all three operations and take 
		    // minimum of three values. Replace/Insert/Remove
			return 1 + min(editDistance(str1, str2, m - 1, n - 1), editDistance(str1, str2, m, n - 1),
					editDistance(str1, str2, m - 1, n));
		}

	}
	
	// A Dynamic Programming based Java program to find minimum 
	// number operations to convert str1 to str2 
    static int editDistDP(String str1, String str2, int m, int n) 
    { 
        // Create a table to store results of subproblems 
        int dp[][] = new int[m+1][n+1]; 
       
        // Fill d[][] in bottom up manner 
        for (int i=0; i<=m; i++) 
        { 
            for (int j=0; j<=n; j++) 
            { 
                // If first string is empty, only option is to 
                // isnert all characters of second string 
                if (i==0) 
                    dp[i][j] = j;  // Min. operations = j 
       
                // If second string is empty, only option is to 
                // remove all characters of second string 
                else if (j==0) 
                    dp[i][j] = i; // Min. operations = i 
       
                // If last characters are same, ignore last char 
                // and recur for remaining string 
                else if (str1.charAt(i-1) == str2.charAt(j-1)) 
                    dp[i][j] = dp[i-1][j-1]; 
       
                // If the last character is different, consider all 
                // possibilities and find the minimum 
                else
                    dp[i][j] = 1 + min(dp[i][j-1],  // Insert 
                                       dp[i-1][j],  // Remove 
                                       dp[i-1][j-1]); // Replace 
            } 
        } 
   
        return dp[m][n]; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "frys";
		String str2 = "fry";

		System.out.println("Total inserts/replacements/deletions needed are: "
				+ editDistance(str1, str2, str1.length()-1, str2.length()-1));

	}

}
