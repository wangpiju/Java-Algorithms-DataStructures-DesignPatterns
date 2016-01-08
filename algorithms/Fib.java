package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fib {

	public static void main(String[] args) {
//		List<Integer> result = fibonacci(4);
//		
//		for(Integer i: result)
//			System.out.println(i);
		
		System.out.println(fibN(8));

	}
	
	public static int fibN(int n){
		if(n < 0)
			throw new IllegalArgumentException("n must not be less than zero");
		
		if(n == 1)
			return 0;
		
		if(n == 2)
			return 1;
		
		return (fibN(n -1) + fibN(n - 2));
		
	}
	//回傳費氏數列list
	public static List<Integer> fibonacci(int n){
		if(n < 0)
			throw new IllegalArgumentException();
		
		if(n == 0)
			return new ArrayList<Integer>();
		
		if(n == 1)
			return Arrays.asList(0);
		
		if(n == 2)
			return Arrays.asList(0, 1);
		
		final List<Integer> seq = new ArrayList<Integer>(n);
		
		seq.add(0);
		n = n - 1;
		seq.add(1);
		n = n -1;
		
		while(n > 0){
			int a = seq.get(seq.size() - 1);
			int b = seq.get(seq.size() - 2);
			
			seq.add(a+b);
			
			n = n - 1;
		}
		
		return seq;
			
		
	}

}
