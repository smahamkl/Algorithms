package examples.collections.linkedlist;

/*
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
 */

public class SwapNodes {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	static ListNode swapNodes(ListNode root) {
		ListNode swpNode = null, prevNode = null, result = null;

		int i = 1;

		while (root != null) {
			if (i % 2 == 0) {
				if (swpNode == null) {
					swpNode = new ListNode(root.val);
					swpNode.next = new ListNode(prevNode.val);
					result = swpNode;
					swpNode = swpNode.next;

				} else {
					swpNode.next = new ListNode(root.val);
					swpNode.next.next = new ListNode(prevNode.val);
					swpNode = swpNode.next.next;
				}
				

			} else if (i % 2 == 1) {
				prevNode = root;
			}

			root = root.next;
			i++;
		}

		if (i == 2)
			result = prevNode;
		else if (i % 2 == 0)
			swpNode.next = new ListNode(prevNode.val);

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode n1 = new ListNode(1);
		//n1.next = new ListNode(2);
		//n1.next.next = new ListNode(3);
		//n1.next.next.next = new ListNode(4);
		//n1.next.next.next.next = new ListNode(5);

		ListNode result = swapNodes(n1);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}

}
