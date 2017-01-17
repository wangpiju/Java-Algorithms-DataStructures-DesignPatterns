package design_pattern;

import java.util.LinkedList;

public class TemplatePattern {
	public static interface StackPredicate{
		boolean isValid(int i);
	}
	
	public class StackPredicateTest{
		private Stack stack;
		
		public void createStack(){
			stack = new Stack();
			
			for(int i = 1; i <= 10; i++){
				stack.push(i);
			}
		}
		
		@SuppressWarnings("unused")
		public void evenPredicate(){
			final Stack filtered = stack.filter(new StackPredicate(){
				@Override
				public boolean isValid(int i) {
					return (i % 2 == 0);
				}
			});
		}
	}
	
	public static class Stack{
		private final LinkedList<Integer> stack;
		
		public Stack(){
			stack = new LinkedList<Integer>();
		}
		
		public Stack(final LinkedList<Integer> initialState){
			this.stack = initialState;
		}
		
		public void push(final int number){
			stack.add(0, number);
		}
		
		public Integer pop(){
			return stack.remove(0);
		}
		
		public Stack filter(final StackPredicate filter){
			final LinkedList<Integer> initialState = new LinkedList<Integer>();
			
			for(Integer integer: stack){
				if(filter.isValid(integer)){
					initialState.add(integer);
				}
			}
			return new Stack(initialState);
		}
	}
	
	
	public static void main(String[] args) {
		

	}

}
