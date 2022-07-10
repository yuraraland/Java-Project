public class ArryEx1 {

	public static void main(String[] args) {

		char[] ch; //배열 선언
		ch = new char[4]; //배열 생성
		
		ch[0]= 'J';
		ch[1]= 'a';
		ch[2]= 'v';
		ch[3]= 'a';
		//배열 초기화
		
		for (int i=0; i<4; i++) {
			System.out.println("ch[" +i+ "]" + ch[i]); //배열 내용 출
		}
		

	}

}
