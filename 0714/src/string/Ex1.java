package string;

public class Ex1 {

	public static void main(String[] args) {
		
		String s1 = "Twinkle"; //암시적 객체 생성 
		String s2 = "Twinkle"; 
		
		if(s1==s2) {
			System.out.println("s1과 s2는 같다.");
		} else {
			System.out.println("s1과 s2는 같지 않다.");
		}
		
		// 암시적 객체 생성은 같은 문자열일 시, 같은 주소값을 복사해서 가지기 때문에,
		// s1과 s2 의 주소값은 서로 같다.
		
		String s3 = new String("Little Star");
		String s4 = new String("Little Star");
		
		if (s3==s4) {
			System.out.println("s3과 s4는 같다.");
		} else {
			System.out.println("s3과 s4는 같지 않다.");
		}
		
		// new 연산자를 사용해 생성할 시, 명시적 생성을 한다.
		// 명시적 생성은 매번 객체를 새로 생성하기 때문에 서로 다른 주소값을 각각 가진다.
	}

}
