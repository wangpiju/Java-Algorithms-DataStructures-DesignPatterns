package adt;



import org.junit.Test;

public class SimpleTree <E extends Comparable>{
	private E value;
	private SimpleTree<E> left;
	private SimpleTree<E> right;
	
	public static void main(String[] args){
		createTree();
	}
	
	public E getValue(){
		return value;
	}
	
	public SimpleTree<E> getLeft(){
		return left;
	}
	
	public SimpleTree<E> getRight(){
		return right;
	}
	
	@Test
	public static void createTree(){
		final SimpleTree<Integer> root = new SimpleTree<Integer>(7, null, null);
		root.insert(3);
		root.insert(9);
		root.insert(10);
		
		System.out.println(root.search(10));
		System.out.println(Integer.valueOf(10).equals( root.getRight().getRight().getValue()));
		
	}
	
	public SimpleTree(E value, SimpleTree<E> left, SimpleTree<E> right){
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	//search
	public boolean search(final E toFind){
		
		if(toFind.equals(value))
			return true;
		
		if(toFind.compareTo(value) < 0 && null != left)
			return left.search(toFind);
		
		return null != right && right.search(toFind);
	}
	
	//insert
	public  void insert (final E toInsert){
		//if toInsert is less than value, insert into left, otherwise right 
		if(toInsert.compareTo(value) < 0){
			if(null == left)
				left = new SimpleTree<E>(toInsert, null, null);
			else
				left.insert(toInsert);
		}
		else{
			if(null == right)
				right = new SimpleTree<E>(toInsert, null, null);
			else
				right.insert(toInsert);
		}
	}

}
