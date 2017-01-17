package adt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sort {

	public static void main(String[] args) {
		Integer[] spam = new Integer[] { 10,3,9,6,5,7,8,1,2,5,4,90,200,65,78,45,56 };
		List<Integer> a = Arrays.asList(spam);
		for(Integer i: 	mergeSort(a)){
			System.out.println(i);
		}
		

	}
	//O(nlogn)
	public static List<Integer> quickSort(List<Integer> numbers){
		if(numbers.size() < 2)
			return numbers;
		
		final Integer pivot = numbers.get(0);
		final List<Integer> lowerList = new ArrayList<Integer>();
		final List<Integer> higherList = new ArrayList<Integer>();
		
		for(int i = 1; i < numbers.size(); i++){
			if(numbers.get(i) < pivot)
				lowerList.add(numbers.get(i));
			else
				higherList.add(numbers.get(i));
		}
		
		final List<Integer> sortedList = quickSort(lowerList);
		sortedList.add(pivot);
		sortedList.addAll(quickSort(higherList));
		
		return sortedList;
		
	}
	//O(n^2)
	public static void bubbleSort(int[] num){
		int j;
	    boolean flag = true;   // set flag to true to begin first pass
	    int temp;   //holding variable

	    while ( flag )
	    {
            flag= false;    //set flag to false awaiting a possible swap
            for( j=0;  j < num.length -1;  j++ )
            {
                   if ( num[j] >  num[j + 1])   // change to > for ascending sort
                   {
	                   temp = num[ j + 1];                //swap elements
	                   num[ j + 1] = num[ j ];
	                   num[ j ] = temp;
	                   flag = true;              //shows a swap occurred  
                   } 
            } 
	     } 
	}
	//O(n^2)
	public static List<Integer> insertSort(final int[] numbers){
		final List<Integer> sortedList = new LinkedList<Integer>();
		
		originalList: for(Integer number: numbers){
			for(int i = 0; i < sortedList.size(); i++){
				if(number < sortedList.get(i)){
					sortedList.add(i, number);
					continue originalList;
				}
			}
			
			sortedList.add(sortedList.size(), number);
		}
		
		return sortedList;
	}
	//O(nlogn)
	public static List<Integer> mergeSort(final List<Integer> values){
		if(values.size() < 2)
			return values;
		
		final List<Integer> leftHalf = values.subList(0,  values.size() / 2);
		final List<Integer> rightHalf = values.subList(values.size() / 2, values.size());
		
		return merge(mergeSort(leftHalf), mergeSort(rightHalf));
	}
	
	private static List<Integer> merge(final List<Integer> left, final List<Integer> right){
		int leftPtr = 0;
		int rightPtr = 0;
		
		final List<Integer> merged = new ArrayList<Integer>(left.size() + right.size());
		
		while(leftPtr < left.size() && rightPtr < right.size()){
			if(left.get(leftPtr) < right.get(rightPtr)){
				merged.add(left.get(leftPtr));
				leftPtr++;
			}
			else{
				merged.add(right.get(rightPtr));
				rightPtr++;
			}
		}
		
		while (leftPtr < left.size()){
			merged.add(left.get(leftPtr));
			leftPtr++;
		}
		
		while(rightPtr < right.size()){
			merged.add(right.get(rightPtr));
			rightPtr++;
		}
		
		return merged;
		
	}

}
