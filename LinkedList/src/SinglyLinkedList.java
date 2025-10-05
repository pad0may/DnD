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
		if (values == null) {
			throw new NullPointerException();
		}
		if (values.length == 0) {
			this.head = null;
			this.tail = null;
			nodeCount = 0;
		} else {
			for (int i = 0; i < values.length; i++) {
				add((E) values[i]);
			}
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
		if (head == null) {
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
		if (indexOf(obj) >= 0) {
			return true;
		}
		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		if ((head.getValue() == null && obj == null)
				|| (head.getValue() != null && head.getValue().equals(obj))) {
			return 0;
		}
		int ret = 0;
		ListNode temp = head;
		while (temp.getNext() != null) {
			if ((temp.getValue() == null && obj == null)
					|| (temp.getValue() != null && temp.getValue().equals(obj))) {
				return ret;
			}
			ret++;
			temp = temp.getNext();
		}
		return -1;
	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		ListNode node = new ListNode<E>(obj);
		if (nodeCount == 0) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}
		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.

	public boolean remove(E obj) {
		if ((head.getValue() == null && obj == null)
				|| (head.getValue() != null && head.getValue().equals(obj))) {
			head = head.getNext();
			nodeCount--;
			if (nodeCount == 0) {
				head = null;
				tail = null;
			}
			return true;
		}
		ListNode temp = head;
		for (int i = 0; i < size() - 1; i++) {
			if ((temp.getNext().getValue() == null && obj == null)
					|| (temp.getNext().getValue() != null
							&& temp.getNext().getValue().equals(obj))) {
				temp.setNext(temp.getNext().getNext());
				nodeCount--;
				if (i + 1 == size()) {
					tail = temp;
				}
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	// Returns the i-th element.
	public E getObj(int i) {
		if (i >= nodeCount || i < 0)
			throw new IndexOutOfBoundsException();
		ListNode temp = head;
		for (int j = 0; j < i; j++) {
			temp = temp.getNext();
		}
		return (E) temp;
	}

	public E get(int i) {
		if (i >= nodeCount || i < 0)
			throw new IndexOutOfBoundsException();
		if (i == 0) {
			return (E) head.getValue();
		}
		ListNode temp = head;
		for (int j = 0; j < i; j++) {
			temp = temp.getNext();
		}
		return (E) temp.getValue();
	}


	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, Object obj) {
		if (i >= nodeCount || i < 0)
			throw new IndexOutOfBoundsException();
		if (i == 0) {
			E ret = head.getValue();
			head.setValue((E) obj);
			return ret;
		}
		ListNode temp = (ListNode) getObj(i);
		E ret = (E) temp.getValue();
		temp.setValue(obj);
		return ret;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {
		if ((i == 0 && nodeCount == 0) || i == nodeCount) {
			add((E) obj);
			return;
		}
		if (i > nodeCount || i < 0)
			throw new IndexOutOfBoundsException();
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
		if (i >= nodeCount || i < 0)
			throw new IndexOutOfBoundsException();
		if (i == 0) {
			ListNode ret = head;
			head = head.getNext();
			nodeCount--;
			return (E) ret;
		}
		ListNode temp = (ListNode) getObj(i - 1);
		ListNode ret = temp.getNext();
		temp.setNext(temp.getNext().getNext());
		if (i == size() - 1) {
			tail = temp;
		}
		nodeCount--;
		return (E) ret.getValue();
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		if (head == null) {
			return "[]";
		}
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
