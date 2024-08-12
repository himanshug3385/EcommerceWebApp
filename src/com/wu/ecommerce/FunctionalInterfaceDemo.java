package com.wu.ecommerce;

@FunctionalInterface
public interface FunctionalInterfaceDemo {
	
	public int add(int a, int b);
     
	
	default void test()
	{
		System.out.println("Cheen");
	}
	
	default void test1()
	{
		System.out.println("Tapak");
	}
	
	default void test2()
	{
		System.out.println("dam");
	}
	
	default void test3()
	{
		System.out.println("dam");
	}

}

class Test{
	
	public static void getResult(FunctionalInterfaceDemo functionalInterface) {
		
		int result =  functionalInterface.add(10, 20);
		functionalInterface.test();
		functionalInterface.test1();
		functionalInterface.test2();
		functionalInterface.test3();
		
		System.out.println(result);
	}

	
	public static void main(String[] args)
	{
		getResult((a,b) -> a+b);
	}
}
