package examples.trees;

//Given a binary tree, check whether it is a mirror of itself.
public class CheckSymmetricTree {

	Node root;

	static int height(Node root) {
		if (root == null)
			return 0;

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		if (leftHeight > rightHeight)
			return 1 + leftHeight;
		else
			return 1 + rightHeight;
	}

	static boolean checkIfTreeSymmetric(Node root) {

		int height = height(root);

		for (int i = 0; i < height; i++) {
			if(!checkNodesEqual(root.right, root.left, i))
				return false;
		}

		return true;
	}

	static boolean checkNodesEqual(Node left, Node right, int level) {
		if (level == 0)
			return true;

		if (level == 1 && left.data == right.data)
			return true;
		else
			checkNodesEqual(left.left, right.right, level - 1);

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckSymmetricTree tree = new CheckSymmetricTree();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(7);
		tree.root.right.left = new Node(1);
		tree.root.right.right = new Node(7);
		//tree.root.left.left.left = new Node(8);

		System.out.println(checkIfTreeSymmetric(tree.root));
	}

}
