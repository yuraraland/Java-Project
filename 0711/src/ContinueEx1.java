
public class ContinueEx1 {

	public static void main(String[] args) {
		

		for(int i=0; i<10; i++) {
			if (i%4==0) {
				continue; //continue를 만나면 해당 for 문의 증감식으로 넘어가고,
				//해당 for 문제 증감식이 없다면 조건식으로 넘어간다.
			}
			System.out.println("i값: "+i);
		}

	}

}
