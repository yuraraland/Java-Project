import java.awt.Color;

public class WordVO extends Thread {
	
	int x;
	int y = -30; //화면에서 시작부터 보이지 않게 하기 위한 초기값
	int speed;
	String msg;
	Color c;
	
	VenechiaFrame f;
	//현재 word객체가 사라지도록 하기 위해 VenechiaFrame이
	//가지고 있는 ArrayList를 접근하거나, 현재 word객체의
	//y좌표 값이 증가했을 때, VenechiaFrame에 있는 center_p를
	//다시 그리기 해야 하므로 VenechiaFrame의 주소가 필요함.
	
	public WordVO(String msg, VenechiaFrame f) {
		
		this.msg = msg;
		this.f = f;
		this.x = (int)(Math.random()*f.center_p.getSize().width-70);
		this.speed = (int)(Math.random()*980+20);
		
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		this.c = new Color(red, green, blue);
		
	}

	@Override
	public void run() {
		//현재 스레드가 해야 할 일은,
		//반복적으로 y값을 증가한 후 증가시 창의 바닥에 도달했을 시 반복문 탈출
		//창의 바닥에 도달하지 않은 경우는 VenechiaFrame에 있는 center_p를
		//다시 그리기 하고, 잠시 휴식! 만약! 반복문을 탈출했을 시에는
		//VenechiaFrame의 ArrayList에서 자신을 삭제해야 함!
		
		while(true) {
			y+=3;
			if(y>f.center_p.getSize().height)
				break; //무한 반복문 탈출
			
			f.center_p.repaint(); //다시 그리
			try {
				Thread.sleep(speed);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} //while문의 끝
		
		f.list.remove(this); //스레드가 소멸되기 직전에 현재 WordVO객체가
		//저장되었던 ArrayList로부터 자신을 찾아 삭제한다.
		
	}
	
	
	
	
	

}
