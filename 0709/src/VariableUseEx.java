
public class VariableUseEx {
	
	public static void main (String[] args) {
		
		int hour = 3; //int 형의 변수 hour 선언, 값 초기화.
		int minute = 5;
		System.out.println(hour + "시간" + minute + "분");
		
		int totalMinute = (hour*60) + minute;
		System.out.println("총" + totalMinute + "분");
		
	}

}
