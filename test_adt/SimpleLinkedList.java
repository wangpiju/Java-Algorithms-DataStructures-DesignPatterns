package test_adt;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleLinkedList<E> {
	private static class Element<E>{
		E value;
		Element<E> next;
	}
	
	private Element<E> head;
	
	public static void main(String[] args) {
		
		queueInserion();
	}
	
	public static void queueInserion(){
		final Queue<String> queue = new LinkedList<String>();
		
		queue.add("first");
		queue.add("second");
		queue.add("third");
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		System.out.println(queue.remove());
	}
	
	

}
