package adt;

import java.util.Arrays;

public class TheStack {
	
	private String[] stackArray;
	
	private int stackSize;
	
	private int topOfStack = -1;
	
	TheStack(int size){
		stackSize = size;
		stackArray = new String[size];
		Arrays.fill(stackArray, "-1");
	}
	
	public void push(String input){
		if(topOfStack + 1 < stackSize){
			topOfStack++;
			stackArray[topOfStack] = input;
		}
		else{
			System.out.println("the stackt is full.");
		}
		
		System.out.println("PUSH " + input + " was added to the Stack");
	}
	
	public String pop(){
		if(topOfStack >= 0){
			System.out.println("POP " + stackArray[topOfStack] + " was Removed from the Stack");
			
			stackArray[topOfStack] = "-1";
			
			return stackArray[topOfStack--];
		}
		else{
			System.out.println("Sorry the Stack is empty");
			return "-1";
		}
	}
	
	public void pushMany(String  multipleValues){
		String[] tempString = multipleValues.split(",");
		
		for(String s: tempString){
			push(s);
		}
	}
	
	public String peek(){
		System.out.println("PEEK " + stackArray[topOfStack] + " is at the top of the Stack");
		
		return stackArray[topOfStack];
	}
	
	public static void main(String[] args) {
		TheStack stack = new TheStack(10);
		stack.push("10");
		stack.push("10");
		stack.pushMany("46,56,89,78,85");
		stack.peek();
		stack.pop();
		for(String s: stack.stackArray){
			System.out.println(s);
		}
		
	}

}
