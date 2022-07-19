package abs;

public class AbsEx extends AbsEx2 {

	@Override
	public String str() {
		//AbsEx2 오버라이딩.
		return str; // 상속받은 str 값.
	}

	public static void main(String[] args) {
		AbsEx ae = new AbsEx();
		System.out.println("ae.getA(): " + ae.getA());
		System.out.println("ae.getStr(): " + ae.getStr());
	}

}
