package test_algorithms;


import org.junit.Assert;
import org.junit.Test;
import algorithms.Factorial;

/**
 * @author Jason 20160115
 *
 */
public class Test_Factorial extends Factorial{

	@Test
	public final void test() {
		Factorial fac = new Factorial();
		String a= "23";
		String b = "34";
		Assert.assertEquals("2334", fac.stringAppend(a, b));
	}

}
