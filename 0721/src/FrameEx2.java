import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameEx2 extends JFrame implements MouseMotionListener, ActionListener, ItemListener {
	
		CanvasEx2 can;
		JPanel west_p, color_p, combo_p, reset_p;
		JButton red_bt, green_bt, blue_bt, orange_bt, violet_bt, black_bt, yellow_bt, white_bt;
		JComboBox<Integer> combo;
		Integer[] ar = {10, 15, 20, 25, 30};
		JButton reset;
		
		public FrameEx2 () { //생성자
			
			can = new CanvasEx2();
			west_p = new JPanel(new GridLayout(3, 1));
			color_p = new JPanel(new GridLayout(4,2));
			
			color_p.add(black_bt = new JButton());
			black_bt.setBackground(Color.black);
			color_p.add(red_bt = new JButton());
			red_bt.setBackground(Color.red);
			color_p.add(green_bt = new JButton());
			green_bt.setBackground(Color.green);
			color_p.add(blue_bt = new JButton());
			blue_bt.setBackground(Color.blue);
			color_p.add(orange_bt = new JButton());
			orange_bt.setBackground(Color.orange);
			color_p.add(violet_bt = new JButton());
			violet_bt.setBackground(Color.MAGENTA);
			color_p.add(yellow_bt = new JButton());
			yellow_bt.setBackground(Color.yellow);
			color_p.add(white_bt = new JButton());
			white_bt.setBackground(Color.white);
			combo = new JComboBox<Integer>(ar);
			combo_p = new JPanel(new GridLayout(3, 1));
			reset_p = new JPanel(new GridLayout(3, 1));
			reset = new JButton("reset");
			
			combo_p.add(new JPanel());
			combo_p.add(combo);
			
			reset_p.add(new JPanel());
			reset_p.add(reset);
			
			west_p.add(color_p);
			west_p.add(combo_p);
			west_p.add(reset_p);
			
			
			this.add(west_p, BorderLayout.WEST);
			this.add(can);
			
			
			setBounds(100, 200, 800, 500);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			//이벤트 감지자 등록
			can.addMouseMotionListener(this); //마우스의 움직임을 감
			
			black_bt.addActionListener(this);
			red_bt.addActionListener(this);
			blue_bt.addActionListener(this);
			green_bt.addActionListener(this);
			yellow_bt.addActionListener(this);
			orange_bt.addActionListener(this);
			white_bt.addActionListener(this);
			violet_bt.addActionListener(this);
			combo.addItemListener(this);
			
			reset.addActionListener(this);
			
			
			
		}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		// item리스너에서 값을 받아오는 곳.
		
		Object obj = e.getSource();
		if (obj==combo) {
			int size = (Integer)combo.getSelectedItem();
			can.w = size;
			can.h = size;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼을 누르면 액션을 수행하는 
		
		Object obj = e.getSource();
		
		if (obj == black_bt) {
			can.c = Color.black;
		} if (obj == blue_bt) {
			can.c = Color.blue;
		} if (obj == red_bt) {
			can.c = Color.red;
		} if (obj == yellow_bt) {
			can.c = Color.yellow;
		} if (obj == white_bt) {
			can.c = Color.white;
		} if (obj == violet_bt) {
			can.c = Color.MAGENTA;
		} if (obj == green_bt) {
			can.c = Color.green;
		} if (obj == orange_bt) {
			can.c = Color.orange;
		} if (obj == reset) {
			new FrameEx2();
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// 마우스를 드래그 하면 액션을 수행하는 곳
		
		can.x = e.getX();
		can.y = e.getY();
		can.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// 쓰지 않음 

	}

	public static void main(String[] args) {
		// 프로그램 시작
		new FrameEx2();
	}

}
