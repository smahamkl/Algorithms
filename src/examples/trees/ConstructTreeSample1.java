package examples.trees;

/*
 * Construct Tree from given Inorder and Preorder traversals
Let us consider the below traversals:
Preorder sequence: A B D E C F
Inorder sequence: D B E A F C

In a Preorder sequence, leftmost element is the root of the tree. So we know �A� is root for given sequences. By searching �A� in Inorder sequence, we can find out all elements on left 
side of �A� are in left subtree and elements on right are in right subtree. So we know below structure now.
                 A
               /   \
             /       \
           D B E     F C
We recursively follow above steps and get the following tree.
         A
       /   \
     /       \
    B         C
   / \        /
 /     \    /
D       E  F
Algorithm: buildTree()
1) Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next element in next recursive call.
2) Create a new tree node tNode with the data as picked element.
3) Find the picked element�s index in Inorder. Let the index be inIndex.
4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
6) return tNode.
 */
public class ConstructTreeSample1 {

	static int getInorderIndex(String[] inOrder, String element) {
		for (int i = 0; i < inOrder.length; i++) {
			if (element.equals(inOrder[i]))
				return i;
		}
		return -1;
	}

	// here preOrderIdx has to be global, since this index needs to increment for
	// every call(left/right)
	// durin the building of the tree
	static int preOrderIdx = 0;

	static CharNode constructTree(String[] inOrder, String[] preOrder, int fromInOrderIdx, int toInOrderIdx,
			CharNode root) {

		if (preOrderIdx < preOrder.length) {

			int inOrderIdx = getInorderIndex(inOrder, preOrder[preOrderIdx]);

			root = new CharNode(preOrder[preOrderIdx]);
			preOrderIdx++;

			if (inOrderIdx != -1 && (fromInOrderIdx < toInOrderIdx)) {

				root.left = constructTree(inOrder, preOrder, fromInOrderIdx, inOrderIdx - 1, root.left);

				root.right = constructTree(inOrder, preOrder, inOrderIdx + 1, toInOrderIdx, root.right);
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

	static void InOrder(CharNode root) {
		if (root != null) {
			InOrder(root.left);
			System.out.print(root.data + " ");
			InOrder(root.right);

		}
	}
	
	static void postOrder(CharNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
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
