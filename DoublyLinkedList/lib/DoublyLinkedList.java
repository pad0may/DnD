import java.util.List;

public class DoublyLinkedList {
	// Implements a circular doubly-linked list.

	private final ListNode2<Nucleotide> SENTINEL = new ListNode2<Nucleotide>(null);
	private int nodeCount;

	// Constructor: creates an empty list
	public DoublyLinkedList() {
		nodeCount = 0;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public DoublyLinkedList(Nucleotide[] values) {
		this();
		SENTINEL.setNext(SENTINEL);
		SENTINEL.setPrevious(SENTINEL);
		for (Nucleotide nucleotide : values) {
			add(nucleotide);
		}
	}

	public ListNode2<Nucleotide> getSentinel() {
		return SENTINEL;
	}

	public ListNode2<Nucleotide> getHead() {
		return SENTINEL.getNext();
	}

	public ListNode2<Nucleotide> getTail() {
		return SENTINEL.getPrevious();
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
	public boolean contains(Nucleotide obj) {
		ListNode2 temp = SENTINEL;
		for (int i = 0; i < nodeCount; i++) {
			if (temp.getValue().equals(obj)) {
				return true;
			}
		}
		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(Nucleotide obj) {
		ListNode2 temp = SENTINEL;
		for (int i = 0; i < nodeCount; i++) {
			if (temp.getValue().equals(obj)) {
				return i;
			}
		}
		return -1;
	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	@SuppressWarnings("unchecked")
	public boolean add(Nucleotide obj) {
		ListNode2 add = new ListNode2<>(obj, getTail(), SENTINEL);
		if (nodeCount == 0)
			SENTINEL.setNext(add);
		SENTINEL.setPrevious(add);
		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(Nucleotide obj) {
		ListNode2 temp = SENTINEL;
		for (int i = 0; i < nodeCount; i++) {
			if (temp.getValue().equals(obj)) {
				temp.getPrevious().setNext(temp.getNext());
				temp.getNext().setPrevious(temp.getPrevious());
				nodeCount--;
				return true;
			}
		}
		return false;


	}

	// Returns the i-th element.
	public Nucleotide get(int i) {
		ListNode2 temp = getNode(i);
		return (Nucleotide) temp.getValue();
	}

	public ListNode2 getNode(int i) {
		ListNode2 temp = SENTINEL;
		for (int j = 0; j < i; j++) {
			temp = temp.getNext();
		}
		return temp;
	}

	// Replaces the i-th element with obj and returns the old value.
	public Nucleotide set(int i, Nucleotide obj) {
		ListNode2 temp = getNode(i);
		Nucleotide tempNuc = (Nucleotide) temp.getValue();
		temp.setValue(temp);
		return tempNuc;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	@SuppressWarnings("unchecked")
	public void add(int i, Nucleotide obj) {
		ListNode2 temp = getNode(i);
		ListNode2 add = new ListNode2<>(obj, temp, temp.getNext().getNext());
		temp.getPrevious().setNext(add);
		temp.setPrevious(add);

	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public Nucleotide remove(int i) {
		ListNode2 temp = getNode(i);
		temp.getPrevious().setNext(temp.getNext());
		temp.getNext().setPrevious(temp.getPrevious());
		return (Nucleotide) temp.getValue();
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {


	}

	// Like question 7 on the SinglyLinkedList test:
	// Add a "segment" (another list) onto the end of this list
	public void addSegmentToEnd(DoublyLinkedList seg) {

	}

	// Like question 8 on the SinglyLinkedList test:
	// You are to remove the next 16 nodes from the list, after the node nodeBefore.
	// (on the test these nodes were assumed to contain CCCCCCCCGGGGGGGG, but here
	// you do not need to assume or check for that)
	public void removeCCCCCCCCGGGGGGGG(ListNode2<Nucleotide> nodeBefore) {

	}

	// Like question 9 on the SinglyLinkedList test:
	// You are to find and delete the first instance of seg in the list.
	// If seg is not in the list, return false, otherwise return true.
	public boolean deleteSegment(DoublyLinkedList seg) {

	}

	// Like question 10 on the SinglyLinkedList test:
	// Delete the last three nodes in the list
	// If there are not enough nodes, return false
	public boolean deleteLastThree() {

	}

	// Like question 11 on the SinglyLinkedList test:
	// Replaces every node containing "A" with three nodes containing "T" "A" "C"
	public void replaceEveryAWithTAC() {

	}

}
