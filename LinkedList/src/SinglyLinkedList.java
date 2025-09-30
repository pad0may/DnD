// Implements a singly-linked list.

import java.util.List;

public class SinglyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;
	private int nodeCount;

	// Constructor: creates an empty list
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
		nodeCount = 0;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public SinglyLinkedList(Object[] values) {
		for (int i = 0; i < values.length; i++) {
			add((E) values[i]);
		}
	}

	public ListNode<E> getHead() {
		return head;
	}

	public ListNode<E> getTail() {
		return tail;
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		if (nodeCount == 0) {
			return true;
		}
		return false;
	}

	// Returns the number of elements in this list.
	public int size() {
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		for (ListNode i = head; i != null; i = i.getNext()) {
			if (i.getValue().equals(obj)) {
				return true;
			}
		}
		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		int ret = 0;
		for (ListNode i = head; i.getValue() == obj; i = i.getNext()) {
			ret++;
		}
		return ret;

	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		ListNode node = new ListNode<E>(obj);
		if (nodeCount == 0) {
			head = node;
			tail = node;
		}
		tail.setNext(node);
		tail = node;
		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		if (head.getValue().equals(obj)) {
			head = head.getNext();
			nodeCount--;
			return true;
		}
		for (int i = 0; i < size(); i++) {
			if (((ListNode<E>) getObj(i)).getNext().getValue().equals(obj)) {
				((ListNode<E>) getObj(i)).setNext(((ListNode<E>) getObj(i)).getNext().getNext());
				nodeCount--;
				if (i + 1 == size()) {
					tail = (ListNode<E>) getObj(i);
				}
				return true;
			}

		}
		return false;
	}

	// Returns the i-th element.
	public E getObj(int i) {
		ListNode temp = head;
		for (int j = 0; j < i; j++) {
			temp = temp.getNext();
		}
		return (E) temp;
	}

	public E get(int i) {
		ListNode temp = head;
		if (i >= size()) {
			throw new IndexOutOfBoundsException();
		}
		for (int j = 0; j < i; j++) {
			temp = temp.getNext();
		}
		return (E) temp.getValue();
	}


	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, Object obj) {
		ListNode temp = (ListNode) getObj(i);
		E ret = (E) temp.getValue();
		temp.setValue(obj);
		return ret;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {
		ListNode add = new ListNode<>(obj);
		if (i == 0) {
			add.setNext(head);
			head = add;
			nodeCount++;
			return;
		}
		add.setNext(((ListNode<E>) getObj(i)));
		((ListNode<E>) getObj(i - 1)).setNext(add);
		if (i == size()) {
			tail = add;
		}
		nodeCount++;
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		if (i == 0) {
			ListNode ret = head;
			head = head.getNext();
			return (E) ret;
		}
		ListNode temp = (ListNode) getObj(i - 1);
		ListNode ret = temp.getNext();
		temp.setNext(temp.getNext().getNext());
		if (i == size()) {
			tail = temp;
		}
		nodeCount--;
		return (E) ret.getValue();
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("[");
		for (ListNode i = head; i != tail; i = i.getNext()) {
			ret.append(i.getValue());
			ret.append(", ");
		}
		ret.append(tail.getValue());
		ret.append("]");
		return ret.toString();
	}


}
