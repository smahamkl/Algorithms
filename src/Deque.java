import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

	private class Node<Item> {
		private Node<Item> next;
		private Item current;
		private Node<Item> previous;
	}

	private Node<Item> firstNode = null;
	private Node<Item> lastNode = null;
	private int totalNodes = 0;

	public Deque() // construct an empty deque
	{

	}

	public boolean isEmpty() {
		if (totalNodes == 0)
			return true;
		return false;
	}

	public int size() // return the number of items on the deque
	{
		return totalNodes;
	}

	public void addFirst(Item item) // add the item to the front
	{
		if (item == null)
			throw new java.lang.NullPointerException();

		Node<Item> n = new Node<Item>();
		n.current = item;
		n.previous = null;

		if (firstNode == null) {
			n.next = null;
			lastNode = n;
		} else {
			firstNode.previous = n;
			n.next = firstNode;
		}

		firstNode = n;
		totalNodes++;

	}

	public void addLast(Item item) // add the item to the end
	{
		if (item == null)
			throw new java.lang.NullPointerException();

		Node<Item> n = new Node<Item>();
		n.current = item;
		n.next = null;

		if (lastNode == null) {
			n.previous = null;
			firstNode = n;
		} else {
			lastNode.next = n;
			n.previous = lastNode;
		}

		lastNode = n;
		totalNodes++;

	}

	public Item removeFirst() // remove and return the item from the front
	{
		if (totalNodes == 0)
			throw new java.util.NoSuchElementException();

		Item i = firstNode.current;

		if (totalNodes == 1) {
			lastNode = null;
			firstNode = null;
		} else {
			firstNode = firstNode.next;
			firstNode.previous = null;
		}

		totalNodes--;
		return i;

	}

	public Item removeLast() // remove and return the item from the end
	{

		if (totalNodes == 0)
			throw new java.util.NoSuchElementException();
		Item i = lastNode.current;

		if (totalNodes == 1) {
			lastNode = null;
			firstNode = null;
		} else {
			lastNode = lastNode.previous;
			lastNode.next = null;
		}
		totalNodes--;
		return i;
	}

	public Iterator<Item> iterator() // return an iterator over items in order
	// from front to end
	{
		return new DequeIterator();

	}

	private class DequeIterator implements Iterator<Item> {
		private Node<Item> nextNode;

		private DequeIterator() {
			nextNode = firstNode;
		}

		public boolean hasNext() {
			return nextNode != null;
		}

		public Item next() {
			if (!hasNext())
				throw new java.util.NoSuchElementException();
			Item res = nextNode.current;
			nextNode = nextNode.next;
			return res;
		}

	}

	public static void main(String[] args) // unit testing
	{

		Deque<Integer> deque = new Deque<Integer>();

		deque.addLast(0);
		deque.addLast(1);
		deque.addLast(2);
		System.out.println(deque.isEmpty());
		deque.addLast(4);
		deque.addLast(5);
		deque.addLast(6);
		deque.addLast(7);
		deque.addLast(8);
		deque.addLast(9);
		System.out.println(deque.removeLast());
	}

}
