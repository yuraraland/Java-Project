
public class AutoboxingEx2 {

	Integer var;
	public void setInt(int i) {
		var = i;
	}
	public Integer getInt() {
		return var;
	}
	public static void main (String[] args) {
		AutoboxingEx2 a1 = new AutoboxingEx2();
		a1.setInt(10000);
		int res = a1.getInt();
		System.out.println("res :"+res);
	}
}