package leetcode.dec20problems;
/*
 * 
 An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:

If the character read is a letter, that letter is written onto the tape.
If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.

 

Example 1:

Input: S = "leet2code3", K = 10
Output: "o"
Explanation: 
The decoded string is "leetleetcodeleetleetcodeleetleetcode".
The 10th letter in the string is "o".


 Solution:
 ----------
 Approach 1: Work Backwards
Intuition

If we have a decoded string like appleappleappleappleappleapple and an index like K = 24, the answer is the same if K = 4.

In general, when a decoded string is equal to some word with size length repeated some number of times (such as apple with size = 5 repeated 6 times), the answer is the same for the index K as it is for the index K % size.

We can use this insight by working backwards, keeping track of the size of the decoded string. Whenever the decoded string would equal some word repeated d times, we can reduce K to K % (word.length).

Algorithm

First, find the length of the decoded string. After, we'll work backwards, keeping track of size: the length of the decoded string after parsing symbols S[0], S[1], ..., S[i].

If we see a digit S[i], it means the size of the decoded string after parsing S[0], S[1], ..., S[i-1] will be size / Integer(S[i]). Otherwise, it will be size - 1.
 */
public class DecodedString {


	public String decodeAtIndex(String S, int K) {
        long size = 0;
        int N = S.length();

        // Find size = length of decoded string
        for (int i = 0; i < N; ++i) {
            char c = S.charAt(i);
            if (Character.isDigit(c))
                size *= c - '0';
            else
                size++;
        }
        

        for (int i = N-1; i >= 0; --i) {
            char c = S.charAt(i);
            K %= size;
            //System.out.println("Character: " + c + " Value of K: " + K + " size: " + size);
            if (K == 0 && Character.isLetter(c))
                return Character.toString(c);

            if (Character.isDigit(c))
                size /= c - '0';
            else
                size--;
        }

        throw null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodedString obj = new DecodedString();
		//System.out.println(obj.decodeAtIndex("ha22", 5));
		//System.out.println(obj.decodeAtIndex("a2345678999999999999999", 1));
		//System.out.println(obj.decodeAtIndex("leet2code3", 10));
		System.out.println(obj.decodeAtIndex("y959q969u3hb22odq595", 222280369));

	}

}
