
public class Opertest2 {

	public static void main(String[] args) {

		/* 534 자루의 연필을 30명의 학생들에게 똑같은 개수로 나누어 줄때
		  1인당 몇 개를 가질 수 있고, 몇 개가 남는지를 구하는 코드를 작성하세요. */
		
		int pencils = 534;
		int students = 30;
		
		int a = pencils/students;
		int b = pencils%students;
		
		System.out.println("1인당 가질 수 있는 연필 갯수= " + a);
		System.out.println("배분 후 남는 연필 갯수= " +b);
		
	}

}
