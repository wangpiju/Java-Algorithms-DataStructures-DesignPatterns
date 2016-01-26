package adt;

import java.util.HashMap;
import java.util.Scanner;


public class TestIterator {  
	protected String firstName;
	protected String lastName;
	protected long   employeeId;
	
	public int hashCode(){
		return (int) employeeId *
		            firstName.hashCode() *
		            lastName.hashCode();
	}
} 