import java.util.*;
public class OperTest5 {

	public static void main(String[] args) {
		
	
		/* 키보드로 아이디와 패스워드를 입력받습니다.
		 * 입력 조건으로 이름은 문자열이고 패스워드는 정수입니다.
		 * (패스워드는 int 타입으로 변환)
		 * 입력된 내용을 비교해서 아이디가 "java"이고
		 * 패스워드가 12345라면 "로그인 성공" 을 출력하고,
		 * 그렇지 않으면 "로그인 실패"를 출력하도록 
		  코드를 작성해 보세요. */
	
	Scanner s = new Scanner(System.in);
	
	System.out.println("아이디를 입력하세요!");
	String id = s.nextLine();
	System.out.println("패스워드를 입력하세요!");
	int pass = s.nextInt();
	
	if (id.equals("java")) {
		if (pass==12345) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패: 패스워드 틀림");
		}
	} else {
		System.out.println("로그인 실패: 존재하지 않는 아이디");
	}
	
		

	}

}
