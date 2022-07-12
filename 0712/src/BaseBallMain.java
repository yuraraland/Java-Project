import java.util.*;
public class BaseBallMain {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	BaseBall bb = new BaseBall();
	
	System.out.println("야구 게임 시작!");
	
	bb.ComNum();
	
	
	System.out.print("1~9 까지의 숫자 세 개를 입력해 주세요. :");
	int a, b, c;
		
	a = scan.nextInt();
	b = scan.nextInt();
	c = scan.nextInt();
	bb.UserNum(a, b, c);
	
	if (a<10 && b<10 && c<10) {

	
	int[] com = bb.com;
	int[] user = bb.user;
	
	
	bb.StrikeCount(com, user);
	bb.BallCount(com, user);
	
	for (int i=0; i<10;) {
	  if (bb.t) {
		System.out.println("게임 종료! 수고하셨습니다.");
		break;
	  } else {
		  bb.t=false; 
		  if ((8-i)<0) {
			  System.out.println("횟수 초과. 실패!");
			  break;
		  } else {
		  System.out.print("다시 입력해 주세요! (남은 횟수" + (9-i) +"회) :" );
		  	a = scan.nextInt();
			b = scan.nextInt();
			c = scan.nextInt();
			bb.UserNum(a, b, c);
			
			bb.StrikeCount(com, user);
			bb.BallCount(com, user);
			i++;
		  }
	  }
	
	}
	} else {
		System.out.println("잘못 입력하셨습니다.");
		System.out.println("게임을 다시 시작하세요.");
	}
	
	}
	
		
}
	

		
	
	


