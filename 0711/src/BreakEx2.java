
public class BreakEx2 {

	public static void main(String[] args) {
		
		exit_for: //레이블 설정
			for(int i=0; i<5; i++) {
				for (int j=0; j<5; j++) {
					if(j==3)
						break exit_for; //exit_for이라는 반복문을 아예 빠져나가라.
					System.out.println("i값: "+i+", j값: "+j);
				}
			}

	}

}
