package com.mvc;

class Test{
		public String name;
		
		public Test(String name) {
			this.name=name;
			this.printName();
		}
		public void printName() {
			System.out.println("아빠 :"+name);
		}
}
public class Construct2 extends Test{
	public Construct2(String name1) {
		super(name1);
		
	}
	public void printName() {
		System.out.println("아들 :"+name);
	}
}
class Excute{
	public static void main(String[] args) {
		Construct2 r= new Construct2("안녕");
		r.printName();
	}
}

