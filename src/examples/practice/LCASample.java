package examples.practice;

public class LCASample {

	static class Node {
		String data;
		Node left, right;

		Node(String _data) {
			this.data = _data;
		}
	}

	static Node lca(Node root, String n1, String n2) {

		if (root != null) {

			if (root.data == n1 || root.data == n2)
				return root;

			Node l = lca(root.left, n1, n2);
			Node r = lca(root.right, n1, n2);

			if (l != null && r != null) {
				return root;
			} else {
				return l != null ? l : r;
			}

		}

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node n = new Node("A");
		n.left = new Node("B");
		n.left.left = new Node("C");
		n.left.right = new Node("D");
		n.right = new Node("E");
		n.right.left = new Node("F");
		n.right.right = new Node("G");

		System.out.println(lca(n, "C", "D").data);

	}

}
