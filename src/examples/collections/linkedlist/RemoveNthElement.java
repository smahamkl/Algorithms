package examples.collections.linkedlist;


public class RemoveNthElement {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	static ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode slowPointer = head;
		ListNode resultNode = null;
		ListNode resultHead = resultNode;
		
		if(n <= 0)
			return head;

		int i = 0;

		while (head != null) {
			if (i >= n) {
				if (resultNode == null) {
					resultNode = new ListNode(slowPointer.val);
					resultHead = resultNode;
				} else {
					resultNode.next = new ListNode(slowPointer.val);
					resultNode = resultNode.next;
				}
				slowPointer = slowPointer.next;
			}

			head = head.next;
			i++;
		}
		slowPointer = slowPointer.next;

		while (slowPointer != null) {
			if (resultNode == null) {
				resultNode = new ListNode(slowPointer.val);
				resultHead = resultNode;
			} else {
				resultNode.next = new ListNode(slowPointer.val);
				resultNode = resultNode.next;
			}
			slowPointer = slowPointer.next;
		}

		return resultHead;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(2);
		n1.next.next = new ListNode(3);
		n1.next.next.next = new ListNode(4);
		n1.next.next.next.next = new ListNode(5);

		ListNode result = removeNthFromEnd(n1, 6);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}

}
