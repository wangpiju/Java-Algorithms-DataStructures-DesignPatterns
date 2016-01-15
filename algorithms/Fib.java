package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fib {

	public static void main(String[] args) {
//		List<Integer> result = fibonacci(4);
//		
//		for(Integer i: result)
//			System.out.println(i);
		
		//System.out.println(fibN(8));
		
		final long nonCachedStart = System.nanoTime();
		fibN(45);
		final long nonCachedEnd = System.nanoTime();
		cachedFibN(45);
		final long cachedFinish = System.nanoTime();
		
		System.out.println("no cached time: " +(nonCachedEnd -nonCachedStart));
		
		System.out.println("cached time: " +(cachedFinish -nonCachedEnd));
		
		

	}
	//改進遞迴法，將計算過的存在記憶體
	private static Map<Integer, Integer> fibCache = new HashMap<Integer, Integer>();
	
	public static int cachedFibN(int n){
		if(n < 0){
			throw new IllegalArgumentException("n must not be less than zero");
		}
		
		fibCache.put(0, 0);
		fibCache.put(1, 1);
		
		return recursiveCachedFibN(n);
	}
	
	private static int recursiveCachedFibN(int n){
		if(fibCache.containsKey(n))
			return fibCache.get(n);
		
		int value = recursiveCachedFibN(n -1) + recursiveCachedFibN(n -2);
		fibCache.put(n, value);
		return value;
	}
	//遞迴法
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
