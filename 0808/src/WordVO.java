import java.awt.Color;

public class WordVO extends Thread {
	
	int x;
	int y = -30;
	int speed;
	String str;
	Color c;
	VenechiaFrame f;
	
	public WordVO (String str, VenechiaFrame f) {
		
		this.str = str;
		this.f = f;
		this.x = (int)(Math.random()*f.getWidth());
		this.speed = (int)(Math.random()*980+20);
		
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		this.c = new Color(red, green, blue);
		
	}

	@Override
	public void run() {
		
		while(true) {
			
			y+=3;
			
			if (y > f.center_p.getSize().height) {
				break; 
			} f.center_p.repaint();
			
			try {
				Thread.sleep(speed);
			} catch(Exception e) {
				
			}
		} f.list.remove(this); 
		
	}
	
	
	

}
