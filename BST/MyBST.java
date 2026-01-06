// Implements a BST with BinaryNode nodes

public class MyBST<E extends Comparable<E>> {
	
	private BinaryNode<E> root;  // holds the root of this BST

	// Constructor: creates an empty BST.
	public MyBST() {
		root = null;
	}

	public BinaryNode<E> getRoot() {
		return root;
	}
	
	public int getHeight() {
		return root.getHeight();
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(E value) {
		return false;
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(E value) {
		BinaryNode temp = root;
		BinaryNode add = new BinaryNode(value);
		if (root == null) {
			root = add;
			return true;
		}
		while (temp.getLeft() != value && temp.getRight() != value) {
			if (value.compareTo((E) temp.getValue()) < 0) {
				if (temp.getLeft() == null) {
					temp.setLeft(add);
					return true;
				} else {
					temp = temp.getLeft();
				}
			}
			if (value.compareTo((E) temp.getValue()) > 0) {
				if (temp.getRight() == null) {
					temp.setRight(add);
					return true;
				} else {
					temp = temp.getRight();
				}
			}
		}
		return false;
	}

	// Removes value from this BST.  Returns true if value has been
	// found and removed; otherwise returns false.
	// If removing a node with two children: replace it with the
	//  largest node in the right subtree
	public boolean remove(E value) {
		return false;
	}
	
	// Returns the minimum in the tree
	public E min() {
		return null;
	}
	
	// Returns the maximum in the tree.
	public E max() {
		return null;
	}

	// Returns a bracket-surrounded, comma separated list of the contents of the nodes, in order
	// e.g. [Apple, Cranberry, Durian, Mango]
	public String toString() {
		StringBuilder ret = new StringBuilder();
		BinaryNode temp = root;
	}


}
