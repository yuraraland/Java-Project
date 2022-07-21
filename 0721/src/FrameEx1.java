import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class FrameEx1 extends JFrame implements MouseMotionListener {
	//JFrame을 상속받는 FrameEx1;
	//MouseMotionListner 라는 마우스에 관한 이벤트 인터페이스를 가지고 있다.
	
	CanvasEx1 can; //재정의한 캔버스 클래스 객체 생성
	
	public FrameEx1 () { //생성자. 초기화를 하기 위해 쓴다.
		
		this.add(can=new CanvasEx1()); //현재 객체에 캔버스 생성후 add;
		
		
		setBounds(100, 200, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//이벤트 감지자 등록
		can.addMouseMotionListener(this);
		//can에 추가한다. 이벤트 감지자로 현재 객체를.
		//현재 객체가 mousemotionlistner 자격증을 가지고 있으므로,
		//this(현재 객체)는 () 안에 들어갈 수 있다.
		
	}
	
	

	@Override
	public void mouseDragged(MouseEvent e) {
		// 마우스를 드래그 할때.
		// 드래그 때의 x좌표값과 y좌표값을 알아낸다.
		
		can.x = e.getX(); 
		can.y = e.getY();
		
		can.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// 마우스를 이동 시킬 때.

	}

	public static void main(String[] args) {
		//프로그램 시작
		
		new FrameEx1();
	}

}
