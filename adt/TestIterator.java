package adt;

import java.util.HashMap;
import java.util.Iterator;

public class TestIterator {

	public static void main(String[] args) {
		HashMap h = new HashMap();
		h.put(1, 1);
		h.put(2, 2);
		h.put(3, 1);
		h.put(4, 1);
		
		Iterator i = h.entrySet().iterator();
		//h.put(5, 1);
		//h.remove(4);
		while(i.hasNext()){
			
			System.out.println(i.next());
			//i.remove();
		}

	}

}
