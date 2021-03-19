package examples.practice;
/*
 * Given an integer array nums, return the length of the longest wiggle sequence.

A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive 
and negative. The first difference (if one exists) may be either positive or negative. 
A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) are alternately positive and negative.
In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences, the first because its first two differences 
are positive and the second because its last difference is zero.
A subsequence is obtained by deleting some elements (eventually, also zero) from the original sequence, 
leaving the remaining elements in their original order.

Solution:
---------------
Idea:
The key realization here is that any number that lies in the middle of a stretch of the same direction is extraneous, 
because the more extreme numbers are the better choices to keep, as they allow for a larger likelihood that a subsequent 
number will be a directional change.

So the simple answer here is to count the inflection points in our input array (N) where the direction changes. 
There are several ways to do this, but in this solution, we can keep a directional flag (up) to keep track of the 
current direction and then increment our answer (ans) and invert up when a change is found.

One tricky thing lies in setting the initial direction. Per the instructions, the first number can represent any direction, 
so we'll have to wait until the first time we see a different number to set our direction. We can check this with a simple 
while loop before the main loop.

Once we finish, we can return ans.

 */

public class WiggleSequence {

    public int wiggleMaxLength(int[] N) {
        int len = N.length, i = 1, ans = 1;
        while (i < len && N[i] == N[i-1]) i++;
        if (i == len) return 1;
        boolean up = N[i-1] > N[i];
        for (; i < len; i++)
            if ((up && N[i] < N[i-1]) || (!up && N[i] > N[i-1])) {
                up = !up;
                ans++;
            }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WiggleSequence sol = new WiggleSequence();
		//System.out.println(sol.wiggleMaxLength(new int[] {1,2,3,4,5,6,7,8,9}));
		//System.out.println(sol.wiggleMaxLength(new int[] {1,17,5,10,13,15,10,5,16,8}));
		//System.out.println(sol.wiggleMaxLength(new int[] {1,7,4,9,2,5}));
		System.out.println(sol.wiggleMaxLength(new int[] {1,100, 102,100}));
	}

}
