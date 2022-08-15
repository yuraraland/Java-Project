import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class VenechiaFrame extends JFrame {
   //Venechia게임을 만들 프레임
   
   JPanel cards;
   CardLayout cl;
   JPanel p1, south_p, south_p2, cen_p;
   JButton go_bt;
   JTextField id_tf;
   
   JPanel p2, sou_p, nor_p, nor_p2, center_p;
   JTextField input;
   JButton start_bt;
   JLabel score_lb = new JLabel();
   
   JMenuBar bar;
   JMenu file_m;
   JMenuItem rank_item, exit_item;
   Boolean start_status;
   String path = "/Users/yura/eclipse-workspace/rank.obj";
   
   int score;
   String[] ar = {"사과", "딸기", "포도", "바나나", "원숭이", "호랑이",
         "조랑말", "토끼", "사자", "구름", "김밥"};
   ArrayList<WordVO> list = new ArrayList<WordVO>();
   Thread thread;
   
   ArrayList<Ranking> r_list = new ArrayList<Ranking>();
   String userName;
   
   public VenechiaFrame() {
      
   //p1셋팅 
   p1 = new JPanel(new BorderLayout());
   cen_p = new JPanel() {

	@Override
	public void paint(Graphics g) {
		
		Image img = new ImageIcon("/Users/yura/eclipse-workspace/venechia.jpeg").getImage();
		g.drawImage(img, 0, 0, cen_p.getWidth(), cen_p.getHeight(), this);
	}
	 
	   
	   
   };
   
   south_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
   south_p.add(new JLabel("NAME"));
   south_p.add(id_tf = new JTextField(10));
   south_p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
   south_p2.add(go_bt = new JButton("입장"));
   south_p.setBackground(Color.white);
   south_p2.setBackground(Color.white);
   JPanel subp = new JPanel(new GridLayout(2, 1));
   subp.add(south_p);
   subp.add(south_p2);
   p1.add(cen_p, BorderLayout.CENTER);
   p1.add(subp, BorderLayout.SOUTH);

   //p1셋팅 끝
   
   //p2 = new JPanel(new BorderLayout());
   
   //center_p 셋팅
   center_p = new JPanel(new BorderLayout()) {

	@Override
	public void paint(Graphics g) {
		
		Image img = createImage(this.getSize().width, this.getSize().height);
		Graphics img_g = img.getGraphics();
		
		Iterator<WordVO> it = list.iterator();
		while(it.hasNext()) {
			WordVO vo = it.next();
			
			img_g.setColor(vo.c);
			img_g.drawString(vo.str, vo.x, vo.y);
		}
		
		g.drawImage(img, 0, 0, this);
	}
	 
	 
   };
   
   
   JPanel north_p2 = new JPanel(new GridLayout(1, 2));
   
   p2 = new JPanel(new BorderLayout());
   
   sou_p = new JPanel();
   sou_p.add(new JLabel("입력: "));
   sou_p.add(input = new JTextField(10));
   
   p2.add(sou_p, BorderLayout.SOUTH);
   
   nor_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
   nor_p.add(start_bt = new JButton("START!"));
   
   nor_p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
   nor_p2.add(score_lb);
   
   score_lb.setForeground(Color.blue);
   score_lb.setFont(new Font("Selif", Font.BOLD, 30));
   score_lb.setText(String.valueOf(score));
   
   north_p2.add(nor_p2);
   north_p2.add(nor_p);
   
   p2.add(north_p2, BorderLayout.NORTH);
   
   p2.add(center_p);  
   //p2 셋팅 끝
   
   bar = new JMenuBar();
   file_m = new JMenu("파일");
   file_m.add(rank_item = new JMenuItem("순위"));
   file_m.add(exit_item = new JMenuItem("종료"));
   bar.add(file_m);
   
   this.setJMenuBar(bar);

   JPanel card = new JPanel(new CardLayout());
   this.setLayout(cl = new CardLayout());
   this.getContentPane().add(card);
   card.setLayout(cl);
   
   
   card.add("card1", p1);
   card.add("card2", p2);
  
   
   this.add(card);
   this.setBounds(100, 200, 500, 700);
   this.setVisible(true);
   this.addWindowListener(new WindowAdapter() {

      @Override
      public void windowClosing(WindowEvent e) {
    	 saveScore();
         System.exit(0);
      }
      
   });
   
   go_bt.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
         
         userName = id_tf.getText().trim();
        
         
         if(userName.length() < 1) {
            JOptionPane.showMessageDialog(VenechiaFrame.this, "이름을 입력하세요!");
            id_tf.setText("");
            return;
         } else {
            StringBuffer sb = new StringBuffer();
            sb.append(userName);
            sb.append("님의 게임창");
            VenechiaFrame.this.setTitle(sb.toString());
            cl.show(card, "card2");
         }
         
      }
   });
   
   start_bt.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int dropTime = 1000;
		
		if (thread == null) {
			thread = new Thread() {

				@Override
				public void run() {
					
					start_status = false;
					while(true) {
						try {
							Thread.sleep(dropTime);
						} catch (Exception e2) {
							// TODO: handle exception
						}
						
						int idx = (int)(Math.random()*ar.length);
						String str = ar[idx];
						
						WordVO vo = new WordVO(str, VenechiaFrame.this);
						
						list.add(vo);
						
						vo.start();
					}
					
					
				}
			
				
				
			};
			
			thread.start();
			start_bt.setEnabled(false);
		} 
		
		
		
	}
	
	
});
   
   exit_item.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		saveScore();
		System.exit(0);
		
	}
});
   
   input.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str = input.getText().trim();
		
		if (str.length()>0) {
			ArrayList<WordVO> c_list = (ArrayList<WordVO>)list.clone();
			
			Iterator<WordVO> it = c_list.iterator();
			
			while(it.hasNext()) {
				WordVO vo = it.next();
				
				if (vo.str.equals(str)) {
					list.remove(vo);
					score += 10;
					
					score_lb.setText(String.valueOf(score));
					
				}
			}
			
			input.setText("");
			
		}
		
	}
});
   
   rank_item.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		new VenechiaDialog(VenechiaFrame.this);
		
		
	}
});
   
   
      
   }//생성자의 끝 
   
   
   
   private void saveScore() {
	   
	   ObjectOutputStream oos;
	   ObjectInputStream ois;
	   int index = -1; //index값이 -1 이 아니면 score를 저장해야 하고,
	   //그렇지 않으면 저장할 필요가 없는 경우다.
	   
	
	   try {
		//먼저 파일로부터 저장된 ArrayList 또는 배열을 가져온다.
		  
		   File f = new File(path);
		   	if(f.exists()) {
		   		//파일 연결하는 스트림 생성
		   ois = new ObjectInputStream(new FileInputStream(f));
		   Object obj = ois.readObject();
		   
		   if (obj != null) {
			   ArrayList<Ranking> list = (ArrayList<Ranking>) obj;
			   //위는 앞서 게임을 한 사람들의 고득점자 5명까지를 기억하고 있다.
			   //내 점수 (score)가 이 사람들의 점수보다 높은지? 알아봐야 한다.
			   int idx = 0;
		      
			   //저장된 인원이 5명이 안 되면 비교없이 무조건 저장되도록 한다.
			   if(list.size() > 5) {
			   for(Ranking rank : list) {
				   if (score > rank.getScore()) {
					   //내 점수가 더 큰 경우!
					   index = idx;
					   break;
				   } 
				   idx++;
				   
				   if(idx >= 4) {
					   break;
				   }
			   }   
		  } else {
			  for(Ranking rank : list) {
				  if(score > rank.getScore()) {
					  index = idx;
					  break;
				  }
				  idx++;
			  }
			   if(index == -1)
				   index = list.size();
	}
			   
			   //index값이 여전히 -1을 유지하고 있다면 내 점수를 저장하지 않아도 된다.
			   if (index != -1) {
				   
				   Ranking rank = new Ranking();
				   
				   Date now = new Date(System.currentTimeMillis());
				   String date = now.toString();
				   
				  
				   rank.setUserName(userName);
				   rank.setScore(score);
				   rank.setDate(date);
				   //저장된 인원이 5명 이상일 때만 마지막 저장된 것을 삭제한다.
				   
				   if(list.size() >= 5)
					   list.remove(list.size()-1); //마지막 점수 객체 삭제 
				   
				   list.add(index, rank);
				   
				   oos = new ObjectOutputStream(new FileOutputStream(f));
				   oos.writeObject(list);
			   }
			   
		   }
		}//if문의 끝!
		   	else { // 처음 할 때 딱 한 번 수행!
		   		
				   Date now = new Date(System.currentTimeMillis());
				   String date = now.toString();
				   Ranking rank = new Ranking();
				   ArrayList list = new ArrayList<Ranking>();
				   list.add(rank);
				   
				   oos = new ObjectOutputStream(new FileOutputStream(f));
				   oos.writeObject(list);
		   		
		   	}
		   
	} catch (Exception e) {
		e.printStackTrace();
	}
	   
   }
   
 

   public static void main(String[] args) {
      //프로그램 시작
      
      new VenechiaFrame();

   }

}


