package Javaclass;

public class A1 {
	
	A1() {
		
		
		System.out.println("Hello A");
	}
	A1(int x)
	{
		
		this();
		System.out.println(x);
	}
	
	public static void main(String args[]) {
		
		A1 obj = new A1(10);
	}

}
