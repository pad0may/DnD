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
		if (root == null) return false;
		BinaryNode temp = root;
		while (temp != null && value.compareTo((E) temp.getValue()) != 0) {
			if (value.compareTo((E) temp.getValue()) < 0 && !temp.hasLeft()) {
				return false;
			} if (value.compareTo((E) temp.getValue()) > 0 && !temp.hasRight()) {
				return false;
			}
			if (value.compareTo((E) temp.getValue()) < 0 && temp.hasLeft()) {
				temp = temp.getLeft();
			}
			if (value.compareTo((E) temp.getValue()) > 0 && temp.hasRight()) {
				temp = temp.getRight();
			}
		}
		if (temp.getValue().equals(value)) {
			return true;
		} else {
			return false;
		}
	}

	public BinaryNode find(E value) {
		BinaryNode temp = root;
		while (value.compareTo((E) temp.getValue()) != 0) {
			if (value.compareTo((E) temp.getValue()) < 0 && !temp.hasLeft()) {
				return null;
			} if (value.compareTo((E) temp.getValue()) > 0 && !temp.hasRight()) {
				return null;
			}
			if (value.compareTo((E) temp.getValue()) < 0 && temp.hasLeft()) {
				temp = temp.getLeft();
			}
			if (value.compareTo((E) temp.getValue()) > 0 && temp.hasRight()) {
				temp = temp.getRight();
			}
		}
		if (temp.getValue().equals(value)) {
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
			if (value.compareTo((E) temp.getValue()) < 0) {
				if (temp.getLeft() == null) {
					add.setHeight(addHeight);
					add.setParent(temp);
					temp.setLeft(add);
					return true;
				} else {
					temp = temp.getLeft();
					addHeight++;
				}
			}
			if (value.compareTo((E) temp.getValue()) > 0) {
				if (temp.getRight() == null) {
					add.setHeight(addHeight);
					add.setParent(temp);
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
	public boolean remove2(E value) {
		if (!this.contains(value)) return false;
		BinaryNode del = find(value);
		if (!del.hasLeft() && !del.hasRight()) {
			if (del.getParent().hasRight() && del.getParent().getRight().equals(del)) {
				del.getParent().setRight(null);
				return true;
			} else {
				del.getParent().setLeft(null);
				return true;
			}
		}
		return false;
	}

	public boolean remove(E value) {
		if (root == null || !this.contains(value)) return false;
		BinaryNode del = find(value);
		if (del.isLeaf() && del.equals(root)) {
			root = null;
			return true;
		} else if (del.equals(root)) {
			E close = (E) getClose(del).getValue();
			root.setValue(close);
			updateHeights(root);
			return true;
		}
		if (del.isLeaf()) {
			if (del.getParent().hasRight() && del.getParent().getRight().equals(del)) {
				del.getParent().setRight(null);
				return true;
			} else {
				del.getParent().setLeft(null);
				return true;
			}
		} else {
			E close = (E) getClose(del).getValue();
			if (del.getParent().hasRight() && del.getParent().getRight().equals(del)) {
				del.getParent().getRight().setValue(close);
				return true;
			} else {
				del.getParent().getLeft().setValue(close);
				return true;
			}
		}
	}

	private BinaryNode getClose(BinaryNode node) {
		BinaryNode ret;
		if ((node.hasRight() && !node.hasLeft()) || (node.hasRight() && node.hasLeft())) {
			ret = node.getRight();
			while (ret.hasLeft()) {
				ret = ret.getLeft();
			}
		} else {
			ret = node.getLeft();
			while (ret.hasRight()) {
				ret = ret.getRight();
			}
		}
		if (ret.getParent().hasRight() && ret.getParent().getRight().equals(ret)) {
				ret.getParent().setRight(ret.hasLeft() ? ret.getLeft() : ret.getRight());
				return ret;
			} else {
				ret.getParent().setLeft(ret.hasRight() ? ret.getRight() : ret.getLeft());
				return ret;
			}

	}

	private void updateHeights(BinaryNode node) {
		if (node.hasRight()) {
			node.getRight().setParent(node);
			updateHeights(node.getRight());
		}
		if (node.hasLeft()) {
			node.getLeft().setParent(node);
			updateHeights(node.getLeft());
		}
		node.updateHeight();
		if (node.isLeaf()) {
			return;
		} 
	}
	
	// Returns the minimum in the tree
	public E min() {
		BinaryNode temp = root;
		while (temp.hasLeft()) {
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
