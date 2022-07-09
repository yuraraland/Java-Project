
public class OperEx4 {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 20;
		
		boolean c = ((a+=12)>b) && (a==(b+=2));
		//((a=a+12)>b) 와 (a==(b=b+2)) 두가지 조건을
		//모두 만족해야 true 인 논리 연산자 &&
		//첫번째 식은 22>20, 두번째 식은 22==22 이므로
		//c는 true 값을 가지게 된다.
		
		System.out.println("c=" + c);
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		
	}

}
