package org.performance.ds;

public class LinkedListSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList1 l = new LinkedList1();
		l.add(new LinkedList1.Node("A"));
		l.add(new LinkedList1.Node("B"));
		l.add(new LinkedList1.Node("C"));
		l.add(new LinkedList1.Node("D"));
		l.add(new LinkedList1.Node("E"));
		l.add(new LinkedList1.Node("F"));
		l.add(new LinkedList1.Node("G"));

		l.printList();

		l.findMiddleElement();
	}

}

class LinkedList1 {

	Node head, tail;

	public void add(Node n) {

		if (head == null)
			head = n;

		if (tail == null)
			tail = n;
		else {
			tail.next = n;
			tail = n;
		}
	}

	public void findMiddleElement() {
		int i = 1;
		Node secondPointer = head;
		Node firstPoiner = head;

		while (firstPoiner != null) {
			//System.out.println(firstPoiner.data);
			firstPoiner = firstPoiner.next;

			if (i % 2 == 0)
				secondPointer = secondPointer.next;
			i++;
		}

		System.out.println("Middle element of the linked list:" + secondPointer.data);
	}

	public void printList() {
		Node firstPoiner = head;
		while (firstPoiner != null) {
			System.out.println(firstPoiner.data);
			firstPoiner = firstPoiner.next;
		}
	}

	public static class Node {

		Node next;
		String data;

		public Node(String _data) {
			this.data = _data;
		}

		public Node(String _data, Node _next) {
			this.next = _next;
			this.data = _data;
		}

	}
}