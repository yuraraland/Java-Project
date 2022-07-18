
public class CellPhoneTest {

	public static void main(String[] args) {
		// 프로그램 시작
		
		D_caPhone dca = new D_caPhone("IN-7600", "010-1234-1234", 60, "400만");
		
		MP3Phone mp = new MP3Phone ("KN-600", "010-0987-0987", 60, 256);
		
		System.out.println(dca.getModel()+"," + dca.getChord()+ "," + dca.getNumber());
		

	}

}
