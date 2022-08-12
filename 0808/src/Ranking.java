import java.io.Serializable;

public class Ranking implements Serializable {
	
	String userName = null;
	int score;
	String date;
	
	public Ranking(String name, int score, String date) {
		
		this.userName = name;
		this.score = score;
		this.date = date;
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	};
	
	public String getDate() {
		return date;
	};
	
	public void setDate() {
		this.date = date;
	};
 	
	
	
	
}
