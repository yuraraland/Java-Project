
public class Parent {
	
	String msg = "Parent 클래스";
	
	public String getMsg() {
		return msg;
	}

}


class Child extends Parent {
	//상속
	
	String msg = "Child 클래스";
	
	@Override 
	//부모 클래스와 자식 클래스가 같은 메서드를 가지고 있는 것을
	//메서드 재정의 (오버라이딩) 라고 하며, 자식이 가지고 있는 메서드를 우선 호출하게 된다.
	public String getMsg () {
		return msg;
		
	}
}
