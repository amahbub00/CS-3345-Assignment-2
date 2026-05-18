import java.util.*;
public class DoublyLinkedList<T> implements List<T>, Iterable<T> {
	private Node head, tail;
	private int numberOfElements;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		numberOfElements = 0;
	}
	
	@Override
	public void addLast(T item) {
		// TODO 
		Node node = new Node(item);
		if (numberOfElements == 0) {
			head = node;
			tail = node;
		} else {
			node.previous = tail;
			node.next = null;
			tail.next = node;
			tail = node;
		}
		numberOfElements++;
	}

	@Override
	public void addFirst(T item) {
		// TODO 
		Node node = new Node(item);
		if (numberOfElements == 0) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			node.previous = null;
			head.previous = node;
			head = node;
		}
		numberOfElements++;
			
	}

	@Override
	public T get(int position) {
		// TODO 
		if (position < 0 || position >= numberOfElements) {
		return null; 
		}
		Node current = head;
		int count = 0;
		for (int i = 0; i < position; i++) {
			current = current.next;
			count++;
		}
		return current.data;
	}

	@Override
	public void print() {
		// TODO
		Node current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
				
	}

	@Override
	public void printBackwards() {
		// TODO
		Node current = tail;
		while (current != null) {
			System.out.println(current.data);
			current = current.previous;
		}
			
	}

	@Override
	public boolean remove(T item) {
		// TODO 
		Node current = head;
		while (current != null) {
			if (current.data.equals(item)) {
				if (current.previous == null && current.next == null) {
					numberOfElements--;
					head = null;
					tail = null;
				} else if (current.previous == null) {
					numberOfElements--;
					head = current.next;
					head.previous = null;
				} else if (current.next == null) {
					numberOfElements--;
					tail = current.previous;
					tail.next = null;
				} else {
					numberOfElements--;
					current.previous.next = current.next;
					current.next.previous = current.previous;
				}
				return true;
				} else {
					current = current.next;
				}
				}
				return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO
		if (numberOfElements == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getLength() {
		// TODO 
		return numberOfElements;
	}
	

	public Iterator<T> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<T>
	{
		Node current = head;
		public boolean hasNext() {
			if (current != null) {
				return true;
			} else {
				return false;
			}
		}
		public T next() {
			T temp = current.data;
			current = current.next;
			return temp;
		}
	}
	/** 
	 * Inner class representing a node in the linked list
	 */

	private class Node
	{
		private T data;
		private Node next, previous;

		private Node(T data) {
			this(data,null,null);
		}

		private Node (T data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.previous = prev;
		}
	}


}