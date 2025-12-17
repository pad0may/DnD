public class SortedArrayList<E extends Comparable<E>> extends MyArrayList<E>{

	
	@Override
	public boolean contains(E obj) {
		
	}
	
	//May not contain more than one of the same object
	@Override
	public boolean add(E obj) {
		if (objectCount == 0) {
			super.add(obj);
			return true;
		}
		for (int i = objectCount-1; i >= 0; i--) {
			if (this.get(i).compareTo(obj) <= 0) {
				if (objectCount == i+1) {
					super.add(obj);
					return true;
				}
				else {
					super.add(i+1, obj);
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean remove(E obj) {
		
	}
	
	public E min() {
		return super.get(0);
	}
	
	public E max() {
		return super.get(objectCount-1);
	}
}
