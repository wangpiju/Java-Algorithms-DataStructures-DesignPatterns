package design_pattern;

import java.util.ArrayList;
import java.util.List;

public class PerformOperation implements IntegerOperation{

	@Override
	public Integer performOperation(Integer value) {
		return ++value;
	}
	
	public static List<Integer> updateList(final List<Integer> numbers, final IntegerOperation op){
		final ArrayList<Integer> toReturn = new ArrayList<Integer>(numbers.size());
		
		for(final Integer number: numbers){
			toReturn.add(op.performOperation(number));
		}
		
		return toReturn;
	}

}
