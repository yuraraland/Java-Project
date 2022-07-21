import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class CanvasEx2 extends Canvas {
	
	int x=-10, y=-10, w=10, h=10;
	Color c = Color.black;
	//그림판을 초기 셋팅해 준다.
	//x, y는 초기 시작 좌표.
	//컬러는 블랙, 브러쉬(w, h) 10 으로 지정해 준다.

	@Override
	public void paint(Graphics g) {
		// 그림을 그리는 곳! 
		
		g.setColor(c); //컬러를 받는 곳.
		g.fillOval(x, y, w, h); //브러쉬의 좌표와 브러쉬 크기.
		//처음 값은 모두 0이기 때문에 멤버 변수로 초기값을 정해준다.
		
	}

	@Override
	public void update(Graphics g) {
		paint(g);
		//그린 것들이 없어지지 않게.
	}
	
	

}
