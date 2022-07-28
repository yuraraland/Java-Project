import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VenechiaFrame extends JFrame {
	
	JPanel south_p, north_p;
	JTextField input; //사용자에게 입력받을 창
	JButton start_bt, ok_bt;
	
	JPanel center_p = new JPanel() {

		@Override
		public void paint(Graphics g) {
			
			Image img = createImage(this.getSize().width, this.getSize().height);
			//현재 JPanel의 크기와 동일한 이미지 객체 생성
			
			Graphics img_g = img.getGraphics();
			//위의 img에만 그림을 그릴 수 있는 붓 객체를 얻어낸다.
			
			Iterator<WordVO> it = list.iterator();
			while(it.hasNext()) {
				WordVO vo = it.next();
				
				img_g.setColor(vo.c);
				img_g.drawString(vo.msg, vo.x, vo.y);
			}
			
			g.drawImage(img, 0, 0, this);
			
		}
		
		
		
	};
	
	int score;
	JLabel score_lb;
	
	//시작버튼을 클릭할 때 생성되어 구동되는 스레드객
	Thread thread;
	int dropTime = 1000;
	boolean start_status = true; //true이면 시작버튼을 누를 수 있는 상태.
	
	String[] ar = {"오뚜기", "월드컵", "토끼", "컴퓨터", "끼니", "블로그",
			"마우스", "오버워치", "딸기", "키보드", "스피드", "카테고리", "아메리카노",
			"김밥", "우영우", "쪼끼", "톡끼니", "쫑쪼끼"
	};
	
	ArrayList<WordVO> list;
	
	public VenechiaFrame() {
		
		list = new ArrayList<WordVO>();
		
		north_p = new JPanel(new GridLayout(1, 2));
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p1.add(start_bt = new JButton("시작"));
		start_bt.setFont(new Font("serif", Font.BOLD, 20));
		north_p.add(score_lb = new JLabel());
		
		//Jlabel에 폰트 설정
		score_lb.setFont(new Font("Serif", Font.BOLD, 30));
		score_lb.setForeground(Color.blue);
		
		score_lb.setText(String.valueOf(score));
		
		north_p.add(p1);
		
		this.add(north_p, BorderLayout.NORTH);
		
		south_p = new JPanel();
		south_p.add(input = new JTextField(10));
		input.setFont(new Font("serif", Font.BOLD, 20));
		south_p.add(ok_bt = new JButton("확인"));
		
		this.add(north_p, BorderLayout.SOUTH);
		
		this.add(center_p);
		
		this.setBounds(200, 200, 600, 500);
		this.setVisible(true);
		
		//이벤트 감지자 등록
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		
		});
		
		start_bt.addActionListener(new ActionListener() {
			//ActionListner이라는 인터페이스를 구현한 이름없는 내부 클래스
			@Override
			public void actionPerformed(ActionEvent e) {
				// 시작 버튼을 눌렀을 때 수행하는 곳!
				
				if (thread == null) {
					thread = new Thread() {//WordVO를 하나씩 만들어서 떨어지게 하는 스레
							//스레드를 상속받는 이름없는 내부클래스
						@Override
						public void run() {
							//여기는 현재 스레드가 WordVO를 특정 시간 간격으로 생성하여
							//ArrayList에 저장한 후 WordVO를 구동한다.
							
							start_status = false;
							while(true) {
								try {
									Thread.sleep(dropTime);
								} catch (Exception e2) {
									
								}
								
								//난수를 발생시켜 단어를 하나 고른다.
								int idx = (int)(Math.random()*ar.length);
								String msg = ar[idx];
								//배열에서 선택된 단어!
								
								//단어가 하나 선택됐으니 WordVO 생성하자!
								WordVO vo = new WordVO(msg, VenechiaFrame.this);
								
								list.add(vo); //생성된 스레드를 list에 저장.
								
								//vo가 스레드이므로 구동시켜야 한다. 그래야 아래로 이동한다.
								vo.start();
								
							}
							
						}
						
					};
					
					thread.start();
					start_bt.setEnabled(false); //비활성화!
				}
				
			}
		});
		
		input.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// JTextField에서 엔터쳤을 때 수행하는 곳.
				
				//사용자가 입력한 문자열 얻어내기.
				String str = input.getText().trim();
				if(str.length()>0) {
					//단 한 자라도 입력한 경우!
					
					//ConcurrentModificationException을 피하기 위해 복사본 만들기.
					ArrayList<WordVO> c_list = (ArrayList<WordVO>)list.clone();
					
					//복사본에서 반복자 얻기
					Iterator<WordVO> it = c_list.iterator();
					
					while(it.hasNext()) {
						WordVO vo = it.next();
						//사용자가 입력한 문자열(Str)과 반복자에서 얻어낸 WordVO의 msg와
						//비교하여 같다면 list에서 삭제!!
						if(vo.msg.equals(str)) {
							list.remove(vo);
							score += 10; //점수 주기
							
							//점수판
							score_lb.setText(String.valueOf(score));
							
						}//while의 
					}
					input.setText(""); //사용자가 입력한 값 청소하기.
				}
				
			}
		});
		
	}
	
	
	

	public static void main(String[] args) {
		// 프로그램 시작!

		new VenechiaFrame();
	}

}
