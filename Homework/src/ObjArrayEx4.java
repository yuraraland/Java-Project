
public class ObjArrayEx4 {

	public static void main(String[] args) {
		
		int[][] test; //다차원 배열 선언
		test = new int[2][3];
		//2행 3열의 다차원 배열 선언
		test[0][0] = 100;
		test[0][1] = 200;
		test[0][2] = 300;
		// 1행 초기화 끝
		test[1][0] = 500;
		test[1][1] = 600;
		test[1][2] = 700;
		// 2행 초기화 끝
		
		for(int i=0; i<test.length; i++) {
			for(int j=0; j<test[i].length; j++) {
				System.out.println("test[" + i  + "]" 
						+ "[" + j + "]: " + test[i][j]);
			}
		}

	}

}
