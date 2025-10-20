import java.util.List;

public class DoublyLinkedList {
	// Implements a circular doubly-linked list.

	private final ListNode2<Nucleotide> SENTINEL = new ListNode2<Nucleotide>(null);
	private int nodeCount;

	// Constructor: creates an empty list
	public DoublyLinkedList() {
		this.nodeCount = 0;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public DoublyLinkedList(Nucleotide[] values) {
		if (values == null) {
			throw new NullPointerException();
		}
		this.nodeCount = 0;
		SENTINEL.setNext(SENTINEL);
		SENTINEL.setPrevious(SENTINEL);
		for (Nucleotide nucleotide : values) {
			if ((nucleotide != Nucleotide.A) || (nucleotide != Nucleotide.C)
					|| (nucleotide != Nucleotide.G) || (nucleotide != Nucleotide.T)) {
				throw new IllegalArgumentException();
			}
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
		ListNode2 temp = SENTINEL.getNext();
		int index = 0;
		while (temp.getValue() != obj) {
			if (temp == SENTINEL) {
				temp = temp.getNext();
			} else {
				temp = temp.getNext();
				index++;
			}
		}
		return index;
	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	@SuppressWarnings("unchecked")
	public boolean add(Nucleotide obj) {
		ListNode2 add = new ListNode2<>(obj, getTail(), SENTINEL);
		if (nodeCount == 0) {
			SENTINEL.setNext(add);
			add.setPrevious(SENTINEL);
		} else {
			SENTINEL.getPrevious().setNext(add);
		}
		SENTINEL.setPrevious(add);
		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(Nucleotide obj) {
		ListNode2 temp = SENTINEL;
		for (int i = 0; i <= nodeCount; i++) {
			if (temp.getValue() != null && temp.getValue().equals(obj)) {
				temp.getPrevious().setNext(temp.getNext());
				temp.getNext().setPrevious(temp.getPrevious());
				nodeCount--;
				return true;
			}
			temp = temp.getNext();
		}
		return false;


	}

	// Returns the i-th element.
	public Nucleotide get(int i) {
		if (i >= size() || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		ListNode2 temp = getNode(i);
		return (Nucleotide) temp.getValue();
	}

	public ListNode2 getNode(int i) {
		ListNode2 temp = SENTINEL.getNext();
		while (i > 0) {
			// if (temp == SENTINEL) {
			// temp = temp.getNext();
			// } else {
			temp = temp.getNext();
			i--;
			// }
		}
		return temp;
	}

	// Replaces the i-th element with obj and returns the old value.
	public Nucleotide set(int i, Nucleotide obj) {
		if (i >= nodeCount || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		ListNode2 temp = getNode(i);
		Nucleotide tempNuc = (Nucleotide) temp.getValue();
		temp.setValue(obj);
		return tempNuc;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	@SuppressWarnings("unchecked")
	public void add(int i, Nucleotide obj) {
		if (i > nodeCount || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		ListNode2 add = new ListNode2<>(obj);
		if (i == 0) {
			add.setNext(SENTINEL.getNext());
			SENTINEL.setNext(add);
			add.setPrevious(SENTINEL);
			nodeCount++;
			return;
		}
		if (i == nodeCount) {
			SENTINEL.getPrevious().setNext(add);
			add.setPrevious(SENTINEL.getPrevious());
			SENTINEL.setPrevious(add);
			add.setNext(SENTINEL);
			nodeCount++;
			return;
		}
		add.setPrevious(getNode(i - 1));
		add.setNext(getNode(i));
		getNode(i).setPrevious(add);
		getNode(i - 1).setNext(add);
		nodeCount++;
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public Nucleotide remove(int i) {
		if (i >= nodeCount || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		ListNode2 temp = getNode(i);
		temp.getPrevious().setNext(temp.getNext());
		temp.getNext().setPrevious(temp.getPrevious());
		nodeCount--;
		return (Nucleotide) temp.getValue();
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		if (SENTINEL.getNext() == null) {
			return "[]";
		}
		StringBuilder ret = new StringBuilder();
		ret.append("[");
		ListNode2 temp = SENTINEL.getNext();
		while (temp.getNext() != SENTINEL) {
			ret.append(temp.getValue());
			ret.append(", ");
			temp = temp.getNext();
		}
		ret.append(temp.getValue());
		ret.append("]");
		return ret.toString();
	}

	// Like question 7 on the SinglyLinkedList test:
	// Add a "segment" (another list) onto the end of this list
	public void addSegmentToEnd(DoublyLinkedList seg) {
		this.SENTINEL.getPrevious().setNext(seg.SENTINEL.getNext());
		seg.SENTINEL.getNext().setPrevious(SENTINEL.getPrevious());
		this.SENTINEL.setPrevious(seg.SENTINEL.getPrevious());
		seg.SENTINEL.getPrevious().setNext(SENTINEL);
	}

	// Like question 8 on the SinglyLinkedList test:
	// You are to remove the next 16 nodes from the list, after the node nodeBefore.
	// (on the test these nodes were assumed to contain CCCCCCCCGGGGGGGG, but here
	// you do not need to assume or check for that)
	public void removeCCCCCCCCGGGGGGGG(ListNode2<Nucleotide> nodeBefore) {
		ListNode2 temp = getNode(indexOf(nodeBefore.getValue()));
		for (int i = 0; i <= 16; i++) {
			temp = temp.getNext();
		}
		temp.setPrevious(getNode(indexOf(nodeBefore.getValue())));
		getNode(indexOf(nodeBefore.getValue())).setNext(temp);
	}

	// Like question 9 on the SinglyLinkedList test:
	// You are to find and delete the first instance of seg in the list.
	// If seg is not in the list, return false, otherwise return true.
	public boolean deleteSegment(DoublyLinkedList seg) {
		if (seg == null || seg.size() > this.size()) {
			return false;
		}
		for (int i = 0, x = 0; i < nodeCount; i++, x++) {
			if (!(this.get(i).equals(seg.get(x)))) {
				x = -1;
			}
			if (x == seg.size() - 1) {
				getNode(i - x - 1).setNext(getNode(i + 1));
				getNode(i + 1).setPrevious(getNode(i - x - 1));
				nodeCount -= x + 1;
				return true;
			}
		}
		return false;
	}

	// Like question 10 on the SinglyLinkedList test:
	// Delete the last three nodes in the list
	// If there are not enough nodes, return false
	public boolean deleteLastThree() {
		if (size() < 3) {
			return false;
		}
		if (size() == 3) {
			SENTINEL.setNext(SENTINEL);
			SENTINEL.setPrevious(SENTINEL);
			nodeCount -= 3;
			return true;
		}
		ListNode2 temp = SENTINEL.getPrevious().getPrevious().getPrevious().getPrevious();
		temp.setNext(SENTINEL);
		nodeCount -= 3;
		SENTINEL.setPrevious(temp);
		return true;
	}

	// Like question 11 on the SinglyLinkedList test:
	// Replaces every node containing "A" with three nodes containing "T" "A" "C"
	public void replaceEveryAWithTAC() {
		for (int i = 0; i < size(); i++) {
			if (getNode(i).getValue().equals(Nucleotide.A)) {
				ListNode2<Nucleotide> T = new ListNode2<>(Nucleotide.T);
				ListNode2<Nucleotide> A = new ListNode2<>(Nucleotide.A);
				ListNode2<Nucleotide> C = new ListNode2<>(Nucleotide.C);
				T.setPrevious(getNode(i - 1));
				T.setNext(A);
				A.setPrevious(T);
				A.setNext(C);
				C.setPrevious(A);
				C.setNext(getNode(i + 1));
				getNode(i - 1).setNext(T);
				getNode(i + 1).setPrevious(C);
				nodeCount += 2;
				i += 2;
			}
		}
		return;
	}

}
