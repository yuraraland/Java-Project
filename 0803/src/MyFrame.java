
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyFrame extends JFrame {
	
	//화면에 들어갈 객체 생성
	JMenuBar bar;
	JMenu file_m, edit_m;
	JMenuItem new_item, open_item, save_item, saveAs_item, exit_item;
	JMenuItem find_item, change_item;
	JTextArea ta;
	File selected_file;
	
	public MyFrame() {
		
		file_m = new JMenu("파일");
		file_m.add(new_item = new JMenuItem("새로 만들기"));
		file_m.add(open_item = new JMenuItem("열기"));
		file_m.add(save_item = new JMenuItem("저장"));
		file_m.add(saveAs_item = new JMenuItem("다른 이름으로 저장..."));
		file_m.addSeparator(); //구분선
		file_m.add(exit_item = new JMenuItem("종료"));
		
		edit_m = new JMenu("편집");
		edit_m.add(find_item = new JMenuItem("찾기"));
		edit_m.add(change_item = new JMenuItem("바꾸기"));
		
		bar = new JMenuBar();
		bar.add(file_m);
		bar.add(edit_m);
		
		this.setJMenuBar(bar);
		this.add(new JScrollPane(ta = new JTextArea()));
		
		this.setBounds(100, 200, 600, 600);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		//이벤트 감지자 등록
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser("c:/");
				
				int cmd = jfc.showOpenDialog(MyFrame.this);
				
				if(cmd==JFileChooser.APPROVE_OPTION) {
					
					selected_file = jfc.getSelectedFile(); //선택한 파일을 selected_file에 준다.
					
					viewData(); //뷰데이타라는 함수 호출.
					
				}
				
			}
			
			
		});//open_item의 끝
		
		save_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(selected_file == null) {
					saveAs(); //선택된 파일이 없다면, 다른 이름으로 저장하시겠습니까? 함수 호출
				} else {
					save();
				}
				
			}
			
		}); //save_item의 끝
		
		saveAs_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				saveAs();
				
			}
		}); //saveAs_item의 끝
		
		new_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				selected_file = null;
				ta.setText("");
				MyFrame.this.setTitle("");
				
			}
		}); //new_item의 끝
		
		exit_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		
	}//생성자의 끝
	

	void saveAs() {
		
		JFileChooser jfc = new JFileChooser("c:/");
		int cmd = jfc.showSaveDialog(this);
		
		if (cmd == JFileChooser.APPROVE_OPTION) {
			selected_file = jfc.getSelectedFile();
			if (selected_file.exists()) {
				int res = JOptionPane.showConfirmDialog(jfc, "덮어씌울까요?", " 취소", JOptionPane.YES_NO_OPTION);
			 
			if ( res != JOptionPane.YES_OPTION) {
				return;
			} 
		} 
	}
		save();
	}//saveAs의 끝


	void save() {
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream(selected_file);
			bos = new BufferedOutputStream(fos);
			
			byte [] buf = ta.getText().getBytes();
			
			bos.write(buf, 0, buf.length);
			bos.flush(); //방출
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(fos != null) {
					fos.close();
				} if(bos != null) {
					bos.close();
					this.setTitle(selected_file.getName());
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}//save의 끝


	void viewData() {  
		
		FileInputStream fis = null; //파일을 읽어들이는 fis라는 객체
		byte [] buf = new byte[2048]; //파일을 한 바이트씩 넣을 배열(바구니) 생성
		int redcnt = 0; 
		ta.setText(""); //JTextArea 초기화.
		this.setTitle(selected_file.getName()); //타이틀에 선택된 이름 표시
		
		
		try {
			fis = new FileInputStream(selected_file);
			
			try {
				while ((redcnt=fis.read(buf)) != -1) {
					
					String str = new String(buf, 0, redcnt);
					ta.append(str);
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} 
		
	} //viewData의 끝;
	
	



	public static void main(String[] args) {
		//프로그램 시작
		
		new MyFrame();

	}

}
