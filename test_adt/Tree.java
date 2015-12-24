package test_adt;


public interface Tree<E extends Comparable>{
	boolean search(E toFind);
	void insert(E toInsert);
}

