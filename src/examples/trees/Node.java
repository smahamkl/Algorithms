package examples.trees;


class Node {
	
	int data;
	Node left, right;
	
	Node(int data)
	{
		this.data = data;
		this.left = this.right = null;
	}
}