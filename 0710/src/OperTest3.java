
public class OperTest3 {

	public static void main(String[] args) {
		
		/* 다음 코드를 실행하면 출력 결과로 5를 기대했는데, 4가 출력되었습니다.
		 	어디에서 잘못 작성된 것일까요? */
		
		int var1 = 5;
		int var2 = 2;
		double var3 = var1/var2; 
		// var1, var2는 int, 정수형이므로 정수/정수의 나머지 값은 버려지게 된다.
		// 따라서 (double) varl / var2 처럼 double 형으로 형변환을 해 주면
		// 실수형이 출력되게 된다.
		int var4 = (int) (var3*var2);
		System.out.println(var4);
		
		int var5 = 5;
		int var6 = 2;
		double var7 = (double)var5/var6;
		int var8 = (int)(var7*var6);
		System.out.println(var8);

	}

}
