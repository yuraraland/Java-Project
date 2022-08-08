import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VenechiaFrame extends JFrame {
   //Venechia게임을 만들 프레임
   
   JPanel cards;
   CardLayout cl;
   JPanel p1, south_p;
   JButton go_bt;
   JTextField id_tf;
   
   JPanel p2, sou_p, nor_p, nor_p2;
   JTextField input;
   JButton start_bt;
   
   JMenuBar bar;
   JMenu file_m;
   JMenuItem rank_item, exit_item;
   
   int score;
   String[] ar = {"사과", "딸기", "포도", "바나나", "원숭이", "호랑이",
         "조랑말", "토끼", "사자", "구름", "김밥"};
//   ArrayList<WordVO> list;
   
   
   public VenechiaFrame() {
      
   //p1셋팅 
   p1 = new JPanel(new BorderLayout());
   south_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
   south_p.add(new JLabel("NAME"));
   south_p.add(id_tf = new JTextField(10));
   south_p.add(go_bt = new JButton("입장!"));
   p1.add(south_p, BorderLayout.SOUTH);
   //p1셋팅 끝
   
   //p2셋팅
   p2 = new JPanel(new BorderLayout());
   sou_p = new JPanel();
   sou_p.add(new JLabel("입력: "));
   sou_p.add(input = new JTextField(10));
   p2.add(sou_p, BorderLayout.SOUTH);
   nor_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
   nor_p.add(start_bt = new JButton("START!"));
   nor_p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
   JLabel score_lb = new JLabel();
   nor_p2.add(score_lb);
   score_lb.setForeground(Color.blue);
   score_lb.setFont(new Font("Selif", Font.BOLD, 30));
   score_lb.setText(String.valueOf(score));
   
   p2.add(nor_p, BorderLayout.EAST);
   p2.add(nor_p2, BorderLayout.WEST);
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
         System.exit(0);
      }
      
   });
   
   go_bt.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
         
         String str = id_tf.getText().trim();
         int x = str.length();
         
         if(x < 1) {
            JOptionPane.showMessageDialog(VenechiaFrame.this, "이름을 입력하세요!");
         } else {
            StringBuffer sb = new StringBuffer();
            sb.append(str);
            sb.append("님의 게임창");
            VenechiaFrame.this.setTitle(sb.toString());
            cl.show(card, "card2");
         }
         
      }
   });
   
   
      
   }//생성자의 끝 

   public static void main(String[] args) {
      //프로그램 시작
      
      new VenechiaFrame();

   }

}
