package test_algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitLIfeCycle {

	private static int counter = 0;
	
	@BeforeClass
	public static void suiteSteup(){
		assertEquals(0, counter);
		counter++;
	}
	
	public JUnitLIfeCycle(){
		assertTrue(Arrays.asList(1, 5).contains(counter));
		counter++;
	}
	
	@Before
	public void prepareTest(){
		assertTrue(Arrays.asList(2, 6).contains(counter));
		counter++;
	}
	
	@Test
	public void test() {
		assertTrue(Arrays.asList(3, 7).contains(counter));
		counter++;
	}
	
	@Test
	public void secondTest() {
		assertTrue(Arrays.asList(3, 7).contains(counter));
		counter++;
	}
	
	@After
	public void cleanupTest() {
		assertTrue(Arrays.asList(4, 8).contains(counter));
		counter++;
	}
	
	@AfterClass
	public static void suiteFinished() {
		assertEquals(9, counter);
		
	}
	

}
