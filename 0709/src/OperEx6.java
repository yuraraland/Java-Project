
public class OperEx6 {

	public static void main(String[] args) {
		
		int a = 12;
		int b = 2;
		
		int c = a >> b;
		// >> 연산자는 비트를 해당 방향으로 이동하라는 뜻이다.
		// 12 를 오른쪽으로 2비트 이동하고, 남은 빈 공간은 0으로 채운다.
		// 12의 2진수 0000 1100 을 오른쪽으로 두 비트 밀어준다.
		// 0000 0011 이므로, c의 값은 3이 된다.
		
		char d = (char)(a<<2);
		// 0000 1100 을 두 비트 왼쪽으로 밀어준다.
		// 0011 0000 은 십진수로 48이므로
		// d의 값은 48의 아스키코드값 0이다.
		
		System.out.println("변수 c의 값: " + c);
		System.out.println("변수 d의 값: " + d);

	}

}
