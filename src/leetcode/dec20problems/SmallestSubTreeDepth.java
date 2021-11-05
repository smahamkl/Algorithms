package leetcode.dec20problems;

/*
 * 
 Given the root of a binary tree, the depth of each node is the shortest distance to the root.

Return the smallest subtree such that it contains all the deepest nodes in the original tree.

A node is called the deepest if it has the largest depth possible among any node in the entire tree.

The subtree of a node is tree consisting of that node, plus the set of all descendants of that node.

Solution:
---------
The idea is to return the deepest leaf or it's node of the deepest leaves(if both left and right nodes exist)
If there are multiple leaf nodes/root nodes exist at the same level, return the common ancestor of those nodes
 */

public class SmallestSubTreeDepth {

	static class RootDepth {
		TreeNode node;
		int depth;

		public RootDepth(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	public RootDepth deepestSubTree(TreeNode root, int depth) {
		if (root != null) {
			RootDepth left = deepestSubTree(root.left, depth + 1);
			RootDepth right = deepestSubTree(root.right, depth + 1);
			
			if (left.depth == right.depth)
				return new RootDepth(root, left.depth);
			else if (left.depth < right.depth)
				return right;
			else
				return left;
		} else
			return new RootDepth(root, depth);
	}

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if (root.left == null && root.right == null)
			return root;

		RootDepth res = deepestSubTree(root, 1);

		return res.node;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		//root.right.left.right= new TreeNode(10);
//		TreeNode root = new TreeNode(0);
//		root.left = new TreeNode(1);
//		root.right = new TreeNode(3);
//		root.left.right = new TreeNode(2);
		SmallestSubTreeDepth bst = new SmallestSubTreeDepth();
		TreeNode res = bst.subtreeWithAllDeepest(root);
		System.out.println(res.val);

	}

}
