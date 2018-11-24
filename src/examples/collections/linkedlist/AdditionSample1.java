package examples.collections.linkedlist;

public class AdditionSample1 {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode sum = null, sum1 = null;
		int tmpBal = 0;
		int i = 0;

		while (l1 != null || l2 != null || tmpBal != 0) {
			int tmp1 = l1 == null ? 0 : l1.val;
			int tmp2 = l2 == null ? 0 : l2.val;
			if (i == 0) {
				sum = new ListNode((tmp1 + tmp2 + tmpBal) % 10);
				sum1 = sum;
			} else {
				sum.next = new ListNode((tmp1 + tmp2 + tmpBal) % 10);
				sum = sum.next;
			}

			if (tmp1 + tmp2 + tmpBal >= 10)
				tmpBal = (tmp1 + tmp2 + tmpBal) / 10;
			else
				tmpBal = 0;
			l1 = l1 == null ? l1 : l1.next;
			l2 = l2 == null ? l2 : l2.next;
			i++;
		}

		return sum1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode n1 = new ListNode(1);
		// n1.next = new ListNode(2);
		// n1.next.next = new ListNode(3);

		ListNode n2 = new ListNode(9);
		n2.next = new ListNode(1);
		// n2.next.next = new ListNode(4);

		ListNode sum1 = addTwoNumbers(n1, n2);

		while (sum1 != null) {
			System.out.println(sum1.val);
			sum1 = sum1.next;
		}

	}

}
