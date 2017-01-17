package adt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkedList {

	public static void main(String[] args) {
		long[] timeBegin = new long[2];
		long[] timeEnd = new long[2];
		
		Integer[] ia = new Integer[50000];
		
		for(int i=0;i<50000;i++)
			ia[i] = i;
		int tempi;
		//arraylist
		List arrayList = new ArrayList(Arrays.asList(ia));
		
		timeBegin[0] = System.currentTimeMillis();
		
		for(int i=0; i< 50000; i++)
			tempi = (Integer) arrayList.get(i);
		timeEnd[0] = System.currentTimeMillis();
		
		//linkedlist
		List linkedList = new LinkedList(Arrays.asList(ia));
		
		timeBegin[1] = System.currentTimeMillis();
		Iterator it = linkedList.iterator();
		
		while(it.hasNext())
			it.next();
		
		timeEnd[1] = System.currentTimeMillis();
		System.out.println(timeEnd[0]);
		System.out.println(timeEnd[1]);
		System.out.println(timeEnd[0] - timeBegin[0] );
		System.out.println(timeEnd[1] - timeBegin[1] );

	}

}
