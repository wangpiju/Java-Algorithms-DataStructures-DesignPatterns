package adt;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkedList {

	public static void main(String[] args) {
		long[] timeBegin = new long[2];
		long[] timeEnd = new long[2];
		
		Integer[] ia = new Integer[500000];
		
		for(int i=0;i<500000;i++)
			ia[i] = i;
		int tempi;
		//arraylist
		List<Integer> arrayList = Arrays.asList(ia);
		
		timeBegin[0] = System.currentTimeMillis();
		
		for(int i=0; i< 500000; i++)
			arrayList.get(i);

		timeEnd[0] = System.currentTimeMillis();
		
		//linkedlist
		List<Integer> linkedList = new LinkedList<>(Arrays.asList(ia));
		
		timeBegin[1] = System.currentTimeMillis();
		Iterator<Integer> it = linkedList.iterator();

		while(it.hasNext())
			it.next();
		
		timeEnd[1] = System.currentTimeMillis();

//		System.out.println(timeEnd[0]);
//		System.out.println(timeEnd[1]);

		System.out.println(timeEnd[0] - timeBegin[0] );
		System.out.println(timeEnd[1] - timeBegin[1] );

	}

}
