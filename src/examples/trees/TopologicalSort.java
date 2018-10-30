package examples.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Topological sorting of nodes
//You can only visit[synonymous with print ] after  all its parents are visited . 
//The method can be called with any node in the graph.

public class TopologicalSort {

	public void setNodes(Node n, Node[] nodes, String nodeType) {
		ArrayList<Node> nodeList = new ArrayList<>();
		for (Node no : nodes)
			nodeList.add(no);

		switch (nodeType.toLowerCase().trim()) {
		case "parents":
			n.setParents(nodeList);
			break;
		default:
			n.setChildren(nodeList);
			break;
		}
	}

	public static void main(String args[]) {

		TopologicalSort tree = new TopologicalSort();

		Node nodeB = tree.new Node("B");
		Node nodeD = tree.new Node("D");
		Node nodeI = tree.new Node("I");
		Node nodeG = tree.new Node("G");
		Node nodeA = tree.new Node("A");
		Node nodeE = tree.new Node("E");
		Node nodeJ = tree.new Node("J");
		Node nodeC = tree.new Node("C");

		tree.setNodes(nodeB, new Node[] {}, "parents");
		tree.setNodes(nodeB, new Node[] { nodeI, nodeG, nodeA, nodeE, nodeJ, nodeC }, "children");

		tree.setNodes(nodeB, new Node[] {}, "parents");
		tree.setNodes(nodeD, new Node[] { nodeI, nodeG, nodeA, nodeE, nodeJ, nodeC }, "children");

		tree.setNodes(nodeI, new Node[] { nodeB, nodeD }, "parents");
		tree.setNodes(nodeI, new Node[] { nodeG, nodeA, nodeE, nodeJ, nodeC }, "children");

		tree.setNodes(nodeG, new Node[] { nodeI, nodeB, nodeD }, "parents");
		tree.setNodes(nodeG, new Node[] { nodeC }, "children");

		tree.setNodes(nodeA, new Node[] { nodeI, nodeB, nodeD }, "parents");
		tree.setNodes(nodeA, new Node[] { nodeE, nodeJ, nodeC }, "children");

		tree.setNodes(nodeE, new Node[] { nodeI, nodeB, nodeD, nodeA }, "parents");
		tree.setNodes(nodeE, new Node[] { nodeJ, nodeC }, "children");

		tree.setNodes(nodeJ, new Node[] { nodeI, nodeB, nodeD, nodeA, nodeE }, "parents");
		tree.setNodes(nodeJ, new Node[] { nodeC }, "children");

		tree.setNodes(nodeC, new Node[] { nodeI, nodeB, nodeD, nodeA, nodeE, nodeJ, nodeG }, "parents");
		tree.setNodes(nodeC, new Node[] {}, "children");

		tree.topologicalSort(nodeA);
		System.out.println("--------------------");
		tree.topologicalSort(nodeB);

	}

	Node startingNode = null;
	HashSet<String> visitedNodes = new HashSet<>();

	public void topologicalSort(Node anode) {

		if (startingNode == null)
			startingNode = anode;

		if (anode.parents != null && anode.parents.size() > 0) {
			for (Node parent : anode.parents)
				topologicalSort(parent);

		}
		if (!visitedNodes.contains(anode.value)) {
			visitedNodes.add(anode.value);
			System.out.println(anode.value);

			if (anode.equals(startingNode)) {
				for (Node child : anode.children)
					System.out.println(child.value);

				startingNode = null;
				visitedNodes.clear();
			}
		}

	}

	class Node {

		String value;
		List<Node> parents, children;

		Node(String _value) {
			this.value = _value;

		}

		public void setParents(List<Node> _parents) {
			this.parents = _parents;
		}

		public void setChildren(List<Node> _children) {
			this.children = _children;
		}

	}

}
