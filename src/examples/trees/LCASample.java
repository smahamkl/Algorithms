package examples.trees;

public class LCASample {

	Node2 root;

	public LCASample() {
		root = null;
	}

	public Node2 lca(Node2 root, int n1, int n2)
	{
		
		if(root == null)
			return root;
		
		if(root.data == n1 || root.data == n2)
			return root;
		
		Node2 lcaLeft = lca(root.left, n1, n2);
		Node2 lcaRight = lca(root.right, n1, n2);
		
		if(lcaLeft != null && lcaRight != null)
			return root;
		
		return lcaLeft == null ? lcaRight : lcaLeft;
		
	}
	/* Driver program to test above functions */
	public static void main(String args[]) {
		LCASample tree = new LCASample();
		tree.root = new Node2(1);
		tree.root.left = new Node2(2);
		tree.root.right = new Node2(3);
		tree.root.left.left = new Node2(4);
		tree.root.left.right = new Node2(5);

		System.out.println("LCA of 2 & 3: " + tree.lca(tree.root, 2, 3).data);
		System.out.println("LCA of 4 & 5: " + tree.lca(tree.root, 4, 5).data);
		System.out.println("LCA of 3 & 5: " + tree.lca(tree.root, 3, 5).data);
	}

}
