package abs;

abstract class AbsEx2 extends AbsEx1 { //추상클래스끼리의 상속.
	
	public int getA() { //getA 재정의.
		return a; //AbsEx1 으로부터 상속받은 변수 a 값.
	}
	
	public abstract String str(); //추상 메서

}
