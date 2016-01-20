package algorithms;

import java.math.BigInteger;


//Use iterative to implement Factorial
public class Factorial {
	
	public static void main(String[] args){
		System.out.println(factorial(10));
	}
	
	public static long factorial(int n){
		if(n < 1)
			throw new IllegalArgumentException("n must be greater than zero.");
		
		long toReturn = 1;
		
		for(int i = 1; i <= n; i++){
			toReturn *= i;
		}
		
		return toReturn;
	}
}
