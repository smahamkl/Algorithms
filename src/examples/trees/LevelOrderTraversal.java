package examples.trees;

import java.util.Queue;
import java.util.LinkedList;

//also known as breadth first traversal in a Tree
public class LevelOrderTraversal {
	
	Node root;
	
	public void BreadthFirstTraversal()
	{
		
		Queue<Node > q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			Node x = q.poll();
			System.out.println(x.data);
			
			if(x.left != null)
				q.add(x.left);
			
			if(x.right != null)
				q.add(x.right);
			
		}
		
	}

	public static void main(String[] args) {
		
		LevelOrderTraversal lot = new LevelOrderTraversal();
		lot.root = new Node(1);
		lot.root.left = new Node(2);
		lot.root.right = new Node(3);
		lot.root.left.left = new Node(4);
		lot.root.left.right = new Node(5);
		
		System.out.println("Level order(BF) traversal of binary tree is - ");
        lot.BreadthFirstTraversal();
		
	}

}

class Node {
	Node left, right;
	int data;

	public Node(int item) {
		data = item;
		left = null;
		right = null;
	}
}
