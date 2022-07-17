
public class KoreanMain {

	public static void main(String[] args) {
		
		Korean k1 = new Korean("박자바", "920321-1234567");
		//생성자 사용;
		
		System.out.println("k1.name: " + k1.name);
		System.out.println("k1.sse: " + k1.ssn);
		
		Korean k2 = new Korean("김자바", "010202-1234567");
		
		System.out.println("k2.name: " + k2.name);
		System.out.println("k2.sse: " + k2.ssn);
		
	}

}
