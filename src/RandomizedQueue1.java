import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

public class RandomizedQueue1<Item> implements Iterable<Item> {
	private class Node<Item> {
		private Node<Item> next;
		private Item current;
		private Node<Item> previous;
	}

	private Node<Item> firstNode = null;
	private Node<Item> lastNode = null;
	private int totalNodes = 0;

	public RandomizedQueue1() // construct an empty deque
	{

	}

	public boolean isEmpty() // is the deque empty?
	{
		if (totalNodes == 0)
			return true;
		return false;
	}

	public int size() // return the number of items on the deque
	{
		return totalNodes;
	}

	public void enqueue(Item item) // add the item to the front
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

	public Item dequeue() // remove and return the item from the end
	{
		int elementToRemove = 0;
		Item itemRemoved = null;

		if (totalNodes == 0)
			throw new java.util.NoSuchElementException();

		if (totalNodes == 1) {
			itemRemoved = firstNode.current;
			firstNode = null;
			lastNode = null;
			totalNodes--;
			return itemRemoved;
		}

		elementToRemove = StdRandom.uniform(1, totalNodes);

		if (elementToRemove == 1) {
			itemRemoved = firstNode.current;
			firstNode = firstNode.next;
			firstNode.previous = null;
		} else if (elementToRemove == totalNodes) {
			itemRemoved = lastNode.current;
			lastNode = lastNode.previous;
			lastNode.next = null;
		} else {
			Node<Item> tmp = firstNode;
			int i = 1;
			while (firstNode.next != null) {
				if (i == elementToRemove) {
					itemRemoved = firstNode.current;
					firstNode.previous.next = firstNode.next;
					firstNode.next.previous = firstNode.previous;
					firstNode = null;
					break;
				}
				firstNode = firstNode.next;
				i++;
			}
			firstNode = tmp;
		}

		totalNodes--;

		if (totalNodes == 1)
			firstNode = lastNode;

		return itemRemoved;
	}

	public Item sample() {
		if (totalNodes == 0)
			throw new java.util.NoSuchElementException();

		if (totalNodes == 1)
			return firstNode.current;

		int sampleElement = StdRandom.uniform(1, totalNodes);
		Node<Item> tmp = firstNode;
		int i = 1;
		while (tmp != null && i < totalNodes) {
			if (i == sampleElement) {
				return tmp.current;
			}
			tmp = tmp.next;
			i++;
		}
		return null;
	}

	public Iterator<Item> iterator() // return an iterator over items in order
	// from front to end
	{
		return new RandomizedQueueIterator();

	}

	private class RandomizedQueueIterator implements Iterator<Item> {
		private Node<Item> nextNode;
		private boolean first;

		public RandomizedQueueIterator() {
			int sampleElement = StdRandom.uniform(1, 3);
			if (sampleElement == 2) {
				first = false;
				nextNode = lastNode;
			} else {
				first = true;
				nextNode = firstNode;
			}

		}

		public boolean hasNext() {
			return nextNode != null;
		}

		public Item next() {
			if (!hasNext())
				throw new java.util.NoSuchElementException();

			Item res = nextNode.current;
			if (first) {
				nextNode = nextNode.next;

			} else {
				nextNode = nextNode.previous;
			}
			return res;
		}

		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}

	}

	public static void main(String[] args) // unit testing
	{

		RandomizedQueue1<Integer> list = new RandomizedQueue1<Integer>();
		System.out.println(list.isEmpty());
		System.out.println(list.isEmpty());

		list.enqueue(234);
		list.enqueue(23);
		list.enqueue(2);

		System.out.println("Total size of array:" + list.size());

		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext())
			System.out.println(itr.next() + " ");

		// System.out.println(list.sample());

	}

}
