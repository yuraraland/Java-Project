import java.awt.Canvas;
import java.awt.Graphics;

public class CanvasEx1 extends Canvas {
	
	int x, y, w=10, h=10;

	@Override
	public void paint(Graphics g) {
		// 그리는 작업을 수행해준다.
		g.fillOval(x, y, w, h);
	}

	@Override
	public void update(Graphics g) {
		// update는 기본적으로 싹 지워주고 다시 만들어주기 때문에
		// paint(g) 메서드를 이용해서 기존 값을 유지해 준다.
		paint(g);
		
	}
	
	

}
