import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.FlowView.FlowStrategy;

public class VenechiaDialog extends JDialog {
	
	VenechiaFrame parent;
	
	JPanel center_p, p1, p2, p3, p4, p5;
	String path = "c:/javatest";
	
	public VenechiaDialog(VenechiaFrame parent) {
		
		this.parent = parent;
		
		center_p = new JPanel(new GridLayout(5, 1));
		p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
		center_p.add(p1);
		center_p.add(p2);
		center_p.add(p3);
		center_p.add(p4);
		center_p.add(p5);
		
		this.add(center_p);
		
		this.setBounds(150, 200, 200, 300);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
			
			
		});
		

		
	}
	
private void loadScore() {
	 ObjectInputStream ois = null;
	 ArrayList<Ranking> list = null;
		   
	 try {
		 File f = new File(path);
		 if(f.exists()) {
				ois = new ObjectInputStream(new FileInputStream(f));
				Object obj = ois.readObject();
				
				if(obj != null);
				list = (ArrayList<Ranking>) obj;
				
				int cnt = 0;
				for(Ranking rank : list) {
				 
					StringBuffer sb = new StringBuffer();
					sb.append(++cnt);
					sb.append(". ");
					sb.append(rank.getUserName());
					sb.append(rank.getScore());
					sb.append(" ");
					sb.append(rank.getDate());
					System.out.println(sb.toString());
					switch(cnt) {
					case 1:
						p1.removeAll();
						p1.add(new JLabel(sb.toString()));
						p1.updateUI();
						break;
					case 2:
						p2.removeAll();
						p2.add(new JLabel(sb.toString()));
						p2.updateUI();
						break;
					case 3:
						p3.removeAll();
						p3.add(new JLabel(sb.toString()));
						p3.updateUI();
						break;
					case 4:
						p4.removeAll();
						p4.add(new JLabel(sb.toString()));
						p4.updateUI();
						break;
					case 5:
						p5.removeAll();
						p5.add(new JLabel(sb.toString()));
						p5.updateUI();
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	   }
	

}


