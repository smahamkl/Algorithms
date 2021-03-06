package examples.trees;

//lowest common ancestor
public class BinarySearchTree {

	public Node root;
	
	static Node lca(Node n, int n1, int n2) {

		if (n == null)
			return null;

		if (n.data > n1 && n.data > n2) {
			return lca(n.left, n1, n2);
		}

		if (n.data < n1 && n.data < n2) {
			return lca(n.right, n1, n2);
		}

		return n;
	}
	
	   /* Driver program to test lca() */
    public static void main(String args[]) 
    {
        // Let us construct the BST shown in the above figure
    	BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
  
        int n1 = 10, n2 = 14;
        Node t = lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
  
        n1 = 14;
        n2 = 8;
        t = lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
  
        n1 = 10;
        n2 = 22;
        t = lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
  
    }

}
