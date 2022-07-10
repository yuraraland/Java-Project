
public class OperTest6 {

	public static void main(String[] args) {
		
		// 다음 코드를 실행했을 때 출력 결과는 무엇입니까?
		
		int score = 85;
		String result = (!(score>90)) ? "가" : "나";
		// 식은 거짓이나 앞에 부정이 붙었으므로 참. "가" 
		System.out.println(result);

	}

}
