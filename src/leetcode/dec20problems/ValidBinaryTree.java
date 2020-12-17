package leetcode.dec20problems;

import java.util.*;
/*
 Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees

 */
public class ValidBinaryTree {
	
    ArrayList<Integer> nodeList = new ArrayList<Integer>();
	public void inorder(TreeNode root) {
    	if(root == null)
    		return;
    	
    	inorder(root.left);
    	nodeList.add(root.val);    	
    	inorder(root.right);
    }

	
    public boolean isValidBST(TreeNode root) {
    	inorder(root);
    	Iterator<Integer> iter = nodeList.iterator();
    	int prev = iter.next();
    	while(iter.hasNext())
    	{
    		int cur = iter.next();
    		if(cur <= prev)
    			return false;
    		prev = cur;
    	}
    	
    	return true;    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		
//		TreeNode root = new TreeNode(2);
//		root.left = new TreeNode(1);
//		root.right = new TreeNode(3);
		
		ValidBinaryTree bst = new ValidBinaryTree();
		System.out.println(bst.isValidBST(root));
	}

}
