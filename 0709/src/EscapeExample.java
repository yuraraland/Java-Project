
public class EscapeExample {

	public static void main(String[] args) {
		
		System.out.println("번호\t이름\t직업");
		// \t 는 탭 만큼 띄운다는 이스케이프 문자이다.
		System.out.print("행 단위 출력\n");
		// \n 줄 바꿈. 
		System.out.print("행 단위 출력\n");
		System.out.println("우리는 \"개발자\" 입니다.");
		// println(출력한 뒤 줄을 바꾸어준다.)
		// print(출력)
		// printf(포멧에 맞게 출력)
		System.out.println("봄\\여름\\가을\\겨울");
		// \\ 역슬레시를 출력한다.

	}

}
