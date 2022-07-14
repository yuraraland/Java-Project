package string;

public class Ex5 {

	public static void main(String[] args) {
		
		String s1 = "Kwon Sun Ae";
		
		int index = s1.indexOf('n');
		System.out.println("맨 처음 문자 n의 위치: " + index);
		// indexOf(찾고자 하는 문자); 함수는 문자의 인덱스 번호를 알려준다.
		// 기준은 왼쪽에서 오른쪽이다.
		
		index = s1.indexOf("sun");
		System.out.println("문자 sun의 위치: " + index);
		
		index = s1.lastIndexOf('n');
		System.out.println("마지막 문자 n의 위치: " + index);
		// 오른쪽에서 왼쪽 기준으로 찾아주며,
		// 인덱스의 값은 변하지 않는다.
		
		char c = s1.charAt(index); // 문자 추출
		System.out.println("추출한 문자: " + c);
		
		index = s1.indexOf('S');
		String str = s1.substring(index);
		System.out.println("대문자 S로부터 끝까지 잘라내기: " +str);
		
		str = s1.substring(index, index+3);
		System.out.println("대문자 S로부터 3까지 잘라내기: " +str);
		
		int length = s1.length();
		System.out.println("s1의 길이: " + length);
		
		String[] arr = s1.split(" "); //문자열 분할
		for (int i =0; i<arr.length; i++) 
			System.out.println("arr["+i+"]: "+arr[i]);

	}

}
