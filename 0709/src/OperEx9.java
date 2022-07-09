
public class OperEx9 {

	public static void main(String[] args) {
		
		int a, b;
		a = b = 10;
		
		boolean c = ++a > b++ || a++>= ++b;
		//첫번째 조건식의 값이 true 이므로 두번째 조건식은 수행하지 않고 나온다.
		
		System.out.println(a+","+b);
		System.out.println("변수 c의 값: " + c);

	}

}
