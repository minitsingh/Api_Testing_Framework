package com.backend.testing;

public class AA {
	/**
	 * for method chaining
	 */
	public static AA a()
	{
		System.out.println("execute method a");
		return new AA();
	}
	
	public static AA b()
	{
		System.out.println("execute method b");
		return new AA();
		
	}
	public static B c()
	{
		System.out.println("execute method c");
		return new B();
	}

}
