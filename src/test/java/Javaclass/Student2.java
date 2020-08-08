package Javaclass;

public class Student2 {
	
	int rollno;
	String name;
	float fee;
	Student2(int r,String n, float f)
	{
		rollno=r;
		name=n;
		fee=f;
	}
	void display() {
		
		System.out.println(rollno+" "+name+" "+fee);
	}
	 
}

