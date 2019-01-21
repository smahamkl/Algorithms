package examples.practice;

public class ConstructTreeSample {

	static class Node {
		public Node left, right;
		private int data;

		public Node(int _data) {
			this.data = _data;
		}

	}

	static Node constructTree(int[] arr, int idx, Node root) {
		if (idx < arr.length) {
			root = new Node(arr[idx]);

			root.left = constructTree(arr, 2 * idx + 1, root.left);
			root.right = constructTree(arr, 2 * idx + 2, root.right);

		}

		return root;
	}

	static void printPreNodeTree(Node root) {
		if (root != null) {
			System.out.println(root.data);
			printPreNodeTree(root.left);
			printPreNodeTree(root.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] { 1, 2, 3, 4, 5 };

		Node root = null;

		printPreNodeTree(constructTree(arr, 0, root));

	}

}
