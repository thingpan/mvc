package com.mvc;

public class Constructor {
	int num; 
	public  Constructor(){	
		System.out.println("num");
	
		//생성자는 데이터는 없다
		//클래스 이름이랑 같아야 한다
	}
	public Constructor(int num){
		this.num=num;
		System.out.println("num");
	
		//생성자는 데이터는 없다
		//클래스 이름이랑 같아야 한다
	}

		void test() {
			System.out.println("내 이미 머리 속에 있어서 생성자에서 호출됨!");
			
	}
}
class Execute{
	public static void main(String[] args) {
		Constructor c= new Constructor(100);
		
		System.out.println(c.num);
	}
}
