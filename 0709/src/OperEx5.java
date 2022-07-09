
public class OperEx5 {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 7;
		
		int c = a & b;
		// 비트 연산자 계산.
		// 10 의 2진수 값은 1010 이고,
		// 7 의 2진수 값은 0111 이다.
		// & 연산자는 비트 단위의 곱이므로 결과는 0010 즉 2이다.
		System.out.println("c=" + c);
		
	}

}
