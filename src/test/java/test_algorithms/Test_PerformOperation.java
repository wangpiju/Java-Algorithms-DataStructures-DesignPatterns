package test_algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Test_PerformOperation extends PerformOperation{

	@Test
	public void testPerformOperation() {
		final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
		final List<Integer> expected = Arrays.asList(2,3,4,5,6,7,8);
		PerformOperation op = new PerformOperation();
		final List<Integer> actual = PerformOperation.updateList(numbers, op);
	
		assertEquals(expected, actual);	
	}

}
