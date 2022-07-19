package ifc;

public class InterTestEx implements InterTest { //인터페이스는 자격증과 같다.
	//InterTestEx 는 InterTest 라는 자격증을 가진다.

	@Override
	public int getA() { //InterTest 의 추상화 메서드 재정의.
		return A;
	}

	public static void main(String[] args) {
		
		InterTestEx it1 = new InterTestEx();
		System.out.println("it1.getA(): " + it1.getA());

	}

}
