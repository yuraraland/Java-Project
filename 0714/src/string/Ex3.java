package string;

public class Ex3 {

	public static void main(String[] args) {
		
		int count = 0;
		
		String msg = ++count + "little, " + ++count +
				"little, " + ++count + "little Indian";
		
		System.out.println(msg);

		// 1) ++count + "little, " 의 첫 번째 객체 생성.
		// 2) ++count + "litele, " ++count + "little, " 의 객체 생성
		// 3) 위와 같이 마지막 객체가 생성되어 msg에 저장된다.
	}

}
