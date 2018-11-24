package examples.trees;

//Given a binary tree, check whether it is a mirror of itself.
/*
 * Given a binary tree, check whether it is a mirror of itself.

For example, this binary tree is symmetric:

     1
   /   \
  2     2
 / \   / \
3   4 4   3
 */
public class CheckSymmetricTree {

	static boolean checkIfTreeSymmetric(String[] arr) {
		CharNode root = buildTree(arr, null, 0);
		//inOrder(root);
		
		if (root == null)
			return true;
		else {
			if (isMirror(root, root))
				return true;
		}

		return false;
	}

	static boolean isMirror(CharNode n1, CharNode n2) {
		if (n1 == null && n2 == null)
			return true;

		if (n1.data == n2.data)
			return (isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left));
		else
			return false;
	}
	//below is a helper function to traverse and print the nodes
	static void inOrder(CharNode root) 
    { 
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
            
        } 
    } 

	static CharNode buildTree(String[] arr, CharNode root, int i) {

		if (i < arr.length) {
			root = new CharNode(arr[i]);
			// insert left child
			root.left = buildTree(arr, root.left, 2 * i + 1);
			// insert right child
			root.right = buildTree(arr, root.right, 2 * i + 2);
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CheckSymmetricTree c = new CheckSymmetricTree();

		System.out.println(checkIfTreeSymmetric(new String[] { "10", "2", "2", "#", "1", "1", "#" }));
		System.out.println(checkIfTreeSymmetric(new String[] { "4", "3", "4" }));
	}

}
