package string;

public class Ex4 {

	public static void main(String[] args) {
		
		String s1 = "Kwon Sun Ae";
		String s2 = new String("KWON SUN AE");
		String msg = null;
		
		if (s1.equals(s2)) { 
			//문자열의 내용을 비교해 주는 함수 equals()
			//자바는 대소문자를 구별하기 때문에 대소문자가 다르면 내용이 다르다고 표시된다.
			msg = "s1과 s2는 내용이 같다";
		} else {
			msg = "s1과 s2는 내용이 같지 않다.";
		}
		
		System.out.println(msg);
		
		if (s1.equalsIgnoreCase(s2)) {
			//문자열을 전체 소문자로 만들어 준 후 비교한다.
			msg = "s1과 s2는 대/소문자 구별없이 같다.";
		} else {
			msg = "s1과 s2는 대/소문자 구별없이 다르다.";
		}
		
		System.out.println(msg);
		
		//format 형식에 맞춰 String 객체 생성
		msg = String.format("%20s,%s", s1, s2);
		System.out.println("msg: " + msg);

	}

}
