package examples.trees;

//Convert Ternary Expression to a Binary Tree
/*
 * Input :  string expression =   a?b:c 
Output :        a
              /  \
             b    c

Input : expression =  a?b?c:d:e
Output :     a
           /  \
          b    e
        /  \
       c    d
 */
public class TernaryToBT {

	Node1 root;
	Node1 cur;

	int parseStr(String s, int m)
	{
		if(m > s.length()-1)
			return 0;
		
		if(m == 0)
		{
		     root = new Node1(s.charAt(m));
		     m++;
		    root.parent = null;
		    cur = root;
		}
		
		if(s.charAt(m) == '?')
		{
			m++;
			cur.left = new Node1(s.charAt(m));
			cur.left.parent = cur;
			cur = cur.left;
			m++;
			return parseStr(s, m);
		}
		
		if(s.charAt(m) == ':')
		{
			m++;
			cur = cur.parent;
			cur.right = new Node1(s.charAt(m));
			cur.right.parent = cur;
            m++;
			return parseStr(s, m);
		}
		
		return 0;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ternStr = "a?b?c?d:e:f:g";
		TernaryToBT t = new TernaryToBT();

		int v = t.parseStr(ternStr, 0);
		System.out.println(t.root.curChar);
		System.out.println(t.root.right.curChar);
		System.out.println(t.root.left.right.curChar);
		System.out.println(t.root.left.left.right.curChar);

	}

}

class Node1 {
	Node1 left, right, parent;
	char curChar;

	public Node1(char s) {
		left = right = parent = null;
		curChar = s;
	}
}
