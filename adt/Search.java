package adt;

import java.util.List;

public class Search {

	public static void main(String[] args) {
		

	}
	
	public static boolean binarySearch(final List<Integer> numbers, final Integer value){
		
		if(null == numbers || numbers.isEmpty())
			return false;
		
		final Integer comparision = numbers.get(numbers.size() / 2);
		
		if(value.equals(comparision))
			return true;
		
		if(value < comparision)
			return binarySearch(numbers.subList(0,  numbers.size() / 2), value);
		else
			return binarySearch(numbers.subList(numbers.size() / 2 + 1, numbers.size()), value);
	}

}
