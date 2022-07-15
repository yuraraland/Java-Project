package homework;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;



public class FlowerVM  {
	
	
	int money;
	Flower[] fl = new Flower[4];
	
	public void init () {
		
		for(int i=0; i<fl.length; i++) {
			fl[i] = new Flower();
		}
		
		fl[0].Flower("장미", 25000, "2022-06-10");
		fl[1].Flower("소국", 17000, "2022-07-11");
		fl[2].Flower("백합", 20000, "2022-06-30");
		fl[3].Flower("안개꽃", 11000, "2022-07-04");
		
	}
	
	public void insert (int money) {
		
		
		
		for (int i=0; i<fl.length; i++) {
			
			LocalDate now = LocalDate.now();
			LocalDate date = LocalDate.parse(fl[i].make_date);
			Period days = date.until(now);
			
			if (days.getMonths()<1 && money >= fl[i].price) {
				System.out.print((i+1)+". "+fl[i].name+"  ");
			}
			
		} System.out.println("\n번호를 선택해 주세요!");
	}
	
	public void choice (int num, int money) {
		
		if (4 < num) {
			System.out.println("잘못 선택하셨습니다.");
		} else {
			System.out.println(fl[num-1].name + "을 선택하셨습니다. 잔돈: " + (money-fl[num-1].price));
		}
		
		
	}

}
