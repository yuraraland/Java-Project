
public class BaseBall {
	
	int[] com = new int[3];
	int[] user = new int[3];
	boolean t = false;
	
//	--- 난수 발생 메서드 
	
	public void ComNum () {
		
		for (int i=0; i<this.com.length;) {
			int su=(int)(Math.random()*9+1);
			boolean b = true;
			this.com[i] = su;
				for (int j=0; j<i; j++) {
					if (this.com[i]==this.com[j]) {
						b = false;
					}
				} if (b) {
					++i;
				}
		} //for(int i=0; i<this.com.length; i++) {
			//System.out.print(this.com[i]+ " ");
		//}
	}
//	-------- 난수 발생 메서드 끝 
	
//	-------- 사용자 번호 받아서 배열에 저장하는 메서드 
	public void UserNum (int a, int b, int c) {
		this.user[0] = a;
		this.user[1] = b;
		this.user[2] = c;
	}
// ----------- 사용자 번호 메서드 끝 
	
	public void StrikeCount (int a[], int b[]) {
		
		int score = 0;
		
		for (int i=0; i<3; i++) {
			if(a[i]==b[i]) {
				score=score+1;
			} else {
				score=score+0;
			}
			
		} if (score<3) {
			this.t=false;
			System.out.println(score + "Strike!");
		} if (score==3) {
			this.t=true;
			System.out.println(score + "Strike!");
			
			
		}
		

	}

// --------- 스트라이크메서드
	
	public void BallCount (int[] a, int[] b) {
		
		int score = 0;
		for (int i=0; i<3; i++) {
			for (int j=0; (j!=i && j<3); j++) {
				if (a[i]==b[j]) {
					score=score+1;
				} else {
					score=score+0;
				}
			}
		} System.out.println(score+"Ball!");
	}

}
