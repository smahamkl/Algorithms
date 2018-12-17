package examples.practice;

import examples.trees.CharNode;

public class ConstructTree {

	static int getInorderIndex(String[] inOrder, String element) {
		for (int i = 0; i < inOrder.length; i++) {
			if (element.equals(inOrder[i]))
				return i;
		}
		return -1;
	}

	static int preOrderIdx = 0;

	static CharNode constructTree(String[] in, String[] pre, int fromIn, int toIn, CharNode root) {

		if (preOrderIdx < pre.length) {
			root = new CharNode(pre[preOrderIdx]);

			preOrderIdx++;

			int inOrderIdx = getInorderIndex(in, root.data);

			if (inOrderIdx != -1 && (fromIn < toIn)) {
				root.left = constructTree(in, pre, fromIn, inOrderIdx - 1, root.left);
				root.right = constructTree(in, pre, inOrderIdx + 1, toIn, root.right);
			}
		} 
		
		return root;


	}

	static void preOrder(CharNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] preOrder = new String[] { "A", "B", "D", "E", "C", "F" };
		String[] inOrder = new String[] { "D", "B", "E", "A", "C", "F" };

		CharNode root = null;

		// construct & print the tree
		preOrder(constructTree(inOrder, preOrder, 0, inOrder.length - 1, root));
	}

}
