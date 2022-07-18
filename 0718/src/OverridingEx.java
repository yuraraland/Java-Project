
public class OverridingEx {

	public static void main(String[] args) {
		
		Child cd = new Child();
		//차일드 객체 선언과 생성
		
		System.out.println("cd: " +cd.getMsg());
		
		
		Parent pt = new Child();
		System.out.println("pt: " +pt.getMsg());

		
		//부모의 메서드와 똑같은 것을 가지게 되면,
		//자식의 기능이 확장되면서 우선권을 가지게 된다.
		
		
	}

}
