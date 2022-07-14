package string;

public class Ex6 {

	public static void main(String[] args) {
		
		String s1 = " aaa ";
		String msg = null;
		
		msg = s1.replace("aa", "b"); //문자열을 바꿔주는 것. 
		//내용이 바뀌는 것은 아니고 새로운 객체가 생성되는 것이다.
		System.out.println("msg: "+msg);
		
		msg = s1.toUpperCase();
		System.out.println("msg: " +msg); 
		//모두 대문자로 바꾸어준다.
		
		msg = s1.trim();
		System.out.println("msg: " +msg);
		//앞 뒤의 공백을 제거해준다.
		
		msg = String.valueOf(s1.length());
		System.out.println("msg: " +msg);
		//s1의 길이 값인 정수 5를 문자열로 변경하여 출력해 준다.
		
	}

}
