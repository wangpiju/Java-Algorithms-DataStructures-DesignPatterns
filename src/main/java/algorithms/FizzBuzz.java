package algorithms;

import java.util.ArrayList;
import java.util.List;



public class FizzBuzz {

	public static void main(String[] args) {
		
		List<String> list = alternativeFizzBuzz(30);
		
		for(String s: list)
			System.out.println(s);
	}
	
	public static List<String> fizzBuzz(final int n){
		final List<String> toReturn = new ArrayList<String>(n);
		
		for(int i = 1; i <= n; i++){
			if(i % 15 == 0){
				toReturn.add("FizzBuzz");
			}
			else if(i % 3 == 0){
				toReturn.add("Fizz");
			}
			else if( i % 5 ==0){
				toReturn.add("Buzz");
			}
			else
				toReturn.add(Integer.toString(i));
		}
		
		return toReturn;
	}
	
	public static List<String> alternativeFizzBuzz(final int n){
		final List<String> toReturn = new ArrayList<String>(n);
		
		for(int i = 1; i <= n; i++){
			final String word = toWord(3, i, "Fizz") + toWord(5, i, "Buzz");
			
			if(null == word || word.equals(""))
				toReturn.add(Integer.toString(i));
			else
				toReturn.add(word);
		}
		
		return toReturn;
	}
	
	private static String toWord(final int divisor, final int value, final String word){
		return value % divisor == 0 ? word : "";
	}

}
