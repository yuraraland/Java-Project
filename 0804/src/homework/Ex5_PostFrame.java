package homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.print.attribute.standard.JobMediaSheetsCompleted;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Ex5_PostFrame extends JFrame {
	
	JPanel north_p, center_p;
	JTextField postNum_tf, ad_tf;
	JButton bt1;
	JComboBox<String> cb = new JComboBox<String>();
	JList<String> c_list;
	String addStr;
	
	public Ex5_PostFrame() {
		
		north_p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		north_p.add(postNum_tf = new JTextField(5));
		
		
		File f = new File("c:/eclipse-workspace/util/zipcode_db");
		File [] f_list = f.listFiles();
		for (int i=0; i<f_list.length; i++) {
			String str = f_list[i].getName();
			int num = str.indexOf(".");
			addStr = str.substring(0, num);
			cb.addItem(addStr);
		}
		north_p.add(cb);
		north_p.add(new JLabel("도로명:"));
		
		north_p.add(ad_tf = new JTextField(10));
		north_p.add(bt1 = new JButton("검색"));
		
		c_list = new JList<String>();
		this.add(new JScrollPane(c_list));
		
		
		this.add(north_p, BorderLayout.NORTH);
		
		
		
		this.setBounds(100, 200, 450, 600);
		this.setVisible(true);
		this.setTitle("우편번호 검색");
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
			
		});
		
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			 	
			 searchAddr();
			 
			}
		});
		
		
		
		
	}
		
	
	

	protected void searchAddr() {
		//사용자가 입력한 도로명 가져오기\
		
		String ads = ad_tf.getText().trim();
		
		if(ads.length()<1) {
			JOptionPane.showMessageDialog(this, "도로명을 입력해 주세요");
			ad_tf.setText("");
			ad_tf.requestFocus();
			return;
		}
		
		String city = cb.getItemAt(cb.getSelectedIndex());
		String path = String.format("c:/eclipse-workspace/util/zipcode_db/%s.txt", city);
		
		File f = new File(path);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			
			ArrayList<String> list = new ArrayList<String>();
			String str = null;
			
			while((str=br.readLine()) != null) {
				String[] ar = str.split("\\|");
				StringBuffer sb = new StringBuffer();
				
				if (ar[8].contains(ads)) {
					sb.append(ar[0]);
					sb.append(" : ");
					sb.append(ar[8]);
					
					list.add(sb.toString());
				}
				
			}
			
			String[] ad_ar = new String[list.size()];
			list.toArray(ad_ar);
			c_list.setListData(ad_ar);
			
		} catch (Exception e) {
 			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		c_list.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				String pick = (String)c_list.getSelectedValue();
				postNum_tf.setText(pick.substring(0, 6));
			}
			
			
		});
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Ex5_PostFrame();

	}

}
