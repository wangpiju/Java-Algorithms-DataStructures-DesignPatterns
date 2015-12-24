package test_adt;


//implement tree interface
public class Node<E extends Comparable> implements Tree<E> {
	private E value;
	private SimpleTree<E> left;
	private SimpleTree<E> right;
	
	@Override
	public boolean search(E toFind) {
		if(toFind.equals(value))
			return true;
			
		if(toFind.compareTo(value) < 0)
			return left.search(toFind);
		
		return right.search(toFind);
		
	}

	@Override
	public void insert(E toInsert) {
		
		
	}

	public SimpleTree<E> getLeft() {
		return left;
	}

	public void setLeft(SimpleTree<E> left) {
		this.left = left;
	}

	public SimpleTree<E> getRight() {
		return right;
	}

	public void setRight(SimpleTree<E> right) {
		this.right = right;
	}
	

}
