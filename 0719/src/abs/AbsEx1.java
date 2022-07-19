package abs;

abstract class AbsEx1 {
	
	//추상화 - 추상 클래스와 인터이스로 나뉜다.
	//추상 클래스는, 클래스 내부에 추상 메서드가 하나라도 있으면 추상 클래스가 된다.
	
	int a = 100;
	
	final String str = "abstract test"; //상수
	
	public String getStr() {
		return str;
	} // 멤버 메서드
	
	public abstract int getA(); //추상 클래스
	//추상 클래스의 특징 - body가 없다.
	

}
