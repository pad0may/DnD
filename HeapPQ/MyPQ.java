
public class MyPQ<E extends Comparable<E>> implements MyPriorityQueue<E>{

	private E[] heap;
	private int objectCount;

	public MyPQ() {
		this.heap = (E[])new Comparable[3];
		this.objectCount = 0;
	}

	//Returns the number of elements in the priority queue
	public int size() {
		return objectCount;
	}

	//DO NOT CHANGE MY JANKY TOSTRING!!!!!
	public String toString() {
		StringBuffer stringbuf = new StringBuffer("[");
		for (int i = 0; i < objectCount; i++) {
			stringbuf.append(heap[i]);
			if (i < objectCount - 1)
				stringbuf.append(", ");
		}
		stringbuf.append("]\nor alternatively,\n");

		for(int rowLength = 1, j = 0; j < objectCount; rowLength *= 2) {
			for (int i = 0; i < rowLength && j < objectCount; i++, j++) {
				stringbuf.append(heap[j] + " ");
			}
			stringbuf.append("\n");
			if (j < objectCount) {
				for (int i = 0; i < Math.min(objectCount - j, rowLength*2); i++) {
					if (i%2 == 0)
						stringbuf.append("/");
					else
						stringbuf.append("\\ ");
				}
				stringbuf.append("\n");
			}
		}
		return stringbuf.toString();
	}

	//Doubles the size of the heap array
	private void increaseCapacity() {
		E[] newHeap = (E[])new Comparable[heap.length*2];
		for (int i = 0; i < heap.length; i++) {
			newHeap[i] = heap[i];
		}
		this.heap = newHeap;
	}

	//Returns the index of the "parent" of index i
	private int parent(int i) {
		return (i - 1) / 2;
	}
	//Returns the index of the *smaller child* of index i
	private int smallerChild(int i) {
		int child1 = i * 2 + 1;
		int child2 = i * 2 + 2;
		if (heap[child2] == null) return child1;
		return heap[child1].compareTo(heap[child2]) < 0 ? child1 : child2;
	}

	//Swaps the contents of indices i and j
	private void swap(int i, int j) {
		if (i < 0 || j < 0 || i >= objectCount || j >= objectCount) return;
		E temp = heap[j];
		heap[j] = heap[i];
		heap[i] = temp;
	}

	// Bubbles the element at index i upwards until the heap properties hold again.
	private void bubbleUp(int i) {
		int j = parent(i);
		while (heap[i].compareTo(heap[j]) < 0) {
			swap(i, j);
			i = j;
			j = parent(i);
		}
	}

	// Bubbles the element at index i downwards until the heap properties hold again.
	private void bubbleDown(int i) {
		int j = smallerChild(i);
		while (heap[j] != null && heap[i].compareTo(heap[j]) > 0) {
			swap(i, j);
			i = j;
			j = smallerChild(i);
		}
	}

	@Override
	public void add(E obj) {
		if (obj == null) {
			throw new NullPointerException();
		}
		if (objectCount == heap.length) increaseCapacity();
		heap[objectCount] = obj;
		objectCount++;
		bubbleUp(objectCount-1);
	}

	@Override
	public E removeMin() {
		E ret = heap[0];
		heap[0] = heap[objectCount-1];
		heap[objectCount-1] = null;
		objectCount--;
		bubbleDown(0);
		return ret;
	}

	@Override
	public E peek() {
		return heap[0];
	}

	@Override
	public boolean isEmpty() {
		return objectCount == 0;
	}

}
