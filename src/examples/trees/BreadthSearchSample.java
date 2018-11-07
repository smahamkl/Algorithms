package examples.trees;

public class BreadthSearchSample {

	Node2 root;

	public BreadthSearchSample() {
		root = null;
	}

	/* function to print level order traversal of tree */
	void printLevelOrder() {
		int h = height(root);		
		System.out.println(h);		
		System.exit(0);
		
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest path
	 * from the root node down to the farthest leaf node.
	 */
	int height(Node2 root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print nodes at the given level */
	void printGivenLevel(Node2 root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		BreadthSearchSample tree = new BreadthSearchSample();
		tree.root = new Node2(1);
		tree.root.left = new Node2(2);
		tree.root.right = new Node2(3);
		tree.root.left.left = new Node2(4);
		tree.root.left.right = new Node2(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
	}

}
// Recursive Java program for level order traversal of Binary Tree

/*
 * Class containing left and right child of current node and key value
 */
class Node2 {
	int data;
	Node2 left, right;

	public Node2(int item) {
		data = item;
		left = right = null;
	}
}
