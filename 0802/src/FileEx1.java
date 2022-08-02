

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.synth.SynthProgressBarUI;

public class FileEx1 extends JFrame {
	
	JPanel north_p;
	JTextField url_tf;
	JButton bt1;
	JLabel lb;
	JList<String> list;
	
	
	//폴더명만 담을 배열
	String[] folders;
	ArrayList<String> f_list;
	
	
	public FileEx1() {
		
		Font font = new Font("serif", Font.BOLD, 18);
		f_list = new ArrayList<String>();
		
		north_p = new JPanel(new BorderLayout());
		north_p.add(lb = new JLabel("경로:"), BorderLayout.WEST);
		lb.setFont(font); //생성 후, 글꼴 지정
		north_p.add(url_tf = new JTextField());
		url_tf.setFont(font);//생성 후, 글꼴 지정
		north_p.add(bt1 = new JButton("←"), BorderLayout.EAST);
		bt1.setFont(font);
		this.add(north_p, BorderLayout.NORTH);
		
		list = new JList<String>();
		list.setFont(font);
		this.add(new JScrollPane(list));
		//현재 창의 가운데에 추가한다.
		
		this.setBounds(300, 200, 500, 600);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//창의 x버튼을 누를 때 호출되는 영역.
				System.exit(0); //프로그램 종료.
			}
			
		});
		
		url_tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//url_tf에서 엔터를 쳤을 때 호출되는 영역
				viewlist();
				
			}

		});
		
		list.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				// 클릭한 카운트를 얻어낸다. (더블클릭을 가려내야 한다)
				
				int cnt = e.getClickCount();
				
				if (cnt == 2) {
					//더블클릭했을 때 수행하는 곳
					String selected = list.getSelectedValue();
					//더블클릭한 곳에 선택된 문자열 값을 얻어낸다.
					
					//선택된 폴더병을 url_tf뒤에 붙여야 한다.
					//이때 마지막이 "/"이 없다면 "/" 포함하여 붙여넣어야 한다.
					
					//먼저 url_tf에 있는 문자열을 가져온다.
					
					//먼저 url_tf에 있는 문자열을 가져온다.
					String url_str = url_tf.getText().trim();
					StringBuffer sb = new StringBuffer();
					//마지막 문자값을 얻어낸다.
					
					char ch = url_str.charAt(url_str.length()-1);
					if(ch == '/') {
						sb.append(url_str);
						sb.append(selected);
						
					} else {
						sb.append(url_str);
						sb.append("/");
						sb.append(selected);
						
					}
					url_tf.setText(sb.toString());
					viewlist();
				}
				
			}
			
		});
		
		bt1.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				//back기능 버튼을 클릭했을 때
				//먼저 url_tf에 있는 문자열을 얻어낸다.
				
				/*int a = url_tf.getText().lastIndexOf("/");
				String str = url_tf.getText().substring(0, a);
				if (str.length()<3) {
					url_tf.setText(str+"/");
				} else {
				url_tf.setText(str);
				}
				
				viewlist();*/
				
				String url_str = url_tf.getText().trim();
				int idx = url_str.lastIndexOf("/");
				
				if (idx != -1) {
					String path = url_str.substring(0, idx);
					if(idx == 2) {
						StringBuffer sb = new StringBuffer(path);
						sb.append("/");
						path = sb.toString();
					}
					url_tf.setText(path);
					viewlist();
				}
					
				}
			
		});
		
		
	}//생성자의 끝
	
	
	private void viewlist() {
		//먼저 사용자가 입력한 경로를 문자열로 얻어낸다.
		
		String path = url_tf.getText();
		
		//1자라도 입력되었을 때만 수행하도록 하자
		if(path.length() > 0) {
			File f = new File(path);
			
			//생성된 파일객체가 디렉토리일 경우에만 수행한다.
			
			if(f.isDirectory() && f.exists()){
				//생성된 파일객체가 디렉토리이고, 실제 존재한다면 
				//디렉토리 내부에 하위 요소들이 있을 것이다.
				//그 하위 요소들을 얻어내자!
				//String[] ar = f.list(); //간단하게 하위의 이름들을 
				//얻는데에는 정말 좋은 방법이지만, 폴더인지 파일인지 구분할 수 없다.
				
				File[] ar = f.listFiles();
				
				//결국 사용할 변수는 folder라는 배열인데, ar 안에
				//디렉토리가 몇 개가 있는지를 확인하지 못하여 folders 배열을
				//생성할 수 없다. 이때 필요한 것이 바로 ArrayList이다.
				
				f_list = new ArrayList<String>();
				
				for(int i=0; i<ar.length; i++) {
					if(ar[i].isDirectory() && !ar[i].isHidden()) {
						//디렉토리이면서 숨김 폴더가 아닌 경우
						f_list.add(ar[i].getName());
					}
				}
				
				//폴더(디렉토리)의 이름들만 f_list라는 ArrayList에 저장된 상태.
				//f_list에 있는 모두를 folders에 저장
				
				folders = new String[f_list.size()]; //f_list.size 만큼 배열 생성
				f_list.toArray(folders); //
				
				
				//얻어낸 하위요소들을 저장한다.
				//list.setListData(ar);
				list.setListData(folders);
				
			}
		}
		
		
		
	}


	public static void main(String[] args) {
		// 프로그램 시작
		new FileEx1();
	}

}