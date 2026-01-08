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
		BinaryNode temp = root;
		while (value.compareTo((E) temp.getValue()) != 0) {
			if (value.compareTo((E) temp.getValue()) < 0) {
				temp = temp.getLeft();
			}
			if (value.compareTo((E) temp.getValue()) > 0) {
				temp = temp.getRight();
			}
		}
		if (temp.equals(value)) {
			return true;
		} else {
			return false;
		}
	}

	public BinaryNode find(E value) {
		BinaryNode temp = root;
		while (value.compareTo((E) temp.getValue()) != 0) {
			if (value.compareTo((E) temp.getValue()) < 0) {
				temp = temp.getLeft();
			}
			if (value.compareTo((E) temp.getValue()) > 0) {
				temp = temp.getRight();
			}
		}
		if (temp.equals(value)) {
			return temp;
		} else {
			return null;
		}
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
		int addHeight = 1;
		while (value.compareTo((E) temp.getValue()) != 0) {
			add.setHeight(addHeight);
			if (value.compareTo((E) temp.getValue()) < 0) {
				if (temp.getLeft() == null) {
					temp.setLeft(add);
					return true;
				} else {
					temp = temp.getLeft();
					addHeight++;
				}
			}
			if (value.compareTo((E) temp.getValue()) > 0) {
				if (temp.getRight() == null) {
					temp.setRight(add);
					return true;
				} else {
					temp = temp.getRight();
					addHeight++;
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
		if (!this.contains(value)) return false;
		if (condition) {
			
		}
	}
	
	// Returns the minimum in the tree
	public E min() {
		BinaryNode temp = root;
		while (temp.hasLeft();) {
			temp = temp.getLeft();
		}
		return (E) temp.getValue();
	}
	
	// Returns the maximum in the tree.
	public E max() {
		BinaryNode temp = root;
		while (temp.hasRight()) {
			temp = temp.getRight();
		}
		return (E) temp.getValue();
	}

	// Returns a bracket-surrounded, comma separated list of the contents of the nodes, in order
	// e.g. [Apple, Cranberry, Durian, Mango]
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("[");
		stringTo(ret, root);
		ret.append("]");
		return ret.toString();
	}

	private StringBuilder stringTo(StringBuilder str, BinaryNode node) {
		if (node.getLeft() != null) {
			stringTo(str, node.getLeft());
		}
		str.append(node.getValue());
		if (!node.getValue().equals(max())) str.append(", ");
		if (node.getRight() != null) {
			stringTo(str, node.getRight());
		}
		return str;
	}

	public String toStringHeight() {
		StringBuilder ret = new StringBuilder();
		ret.append("[");
		stringToHeight(ret, root);
		ret.append("]");
		return ret.toString();
	}

	private StringBuilder stringToHeight(StringBuilder str, BinaryNode node) {
		if (node.getLeft() != null) {
			stringToHeight(str, node.getLeft());
		}
		str.append(node.getValue());
		str.append(":");
		str.append(node.getHeight());
		if (!node.getValue().equals(max())) str.append(", ");
		if (node.getRight() != null) {
			stringToHeight(str, node.getRight());
		}
		return str;
	}

}
