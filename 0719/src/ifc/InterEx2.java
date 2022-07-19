package ifc;

public class InterEx2 implements Inter3 {

	int a = 100;
	
	@Override 
	public int getA() { 
		//오버라이딩. Inter3이 Inter1, 2에 있던 getA를 상속받고, Class 에서 재정의 해줘야 한다. 
		return a;
	}

	@Override
	public int getData() {
		//오버라이딩. 
		return a+10;
	}

	public static void main(String[] args) {
		InterEx2 it = new InterEx2();
		Inter1 it1 = it;
		Inter2 it2 = it;
		Inter3 it3 = it;
		
		System.out.println(it1.getA());
		System.out.println(it2.getA());
		System.out.println(it3.getA());
		System.out.println(it.toString());

	}

}
