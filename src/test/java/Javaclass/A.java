package Javaclass;

public class A {
	
	void m() {
		
		System.out.println("This is the message");
	}
	void n() {
		
		System.out.println("This is another message");
		//m();
		this.m();
	}
	
	public static void main(String args[]) {
		
		A obj = new A();
		obj.n();
		
		
	}

}
