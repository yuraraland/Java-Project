package homework;
import java.util.*;


public class FlowerMain {

	public static void main(String[] args) {
		// 프로그램 시작
		FlowerVM vm = new FlowerVM();
		Scanner scan = new Scanner(System.in);
		
		vm.init();
		
		System.out.println("Insert Coin");
		int money = scan.nextInt();
		
		vm.insert(money);
		
		int num = scan.nextInt();
		
		vm.choice(num, money);
		
		
		

	}

}
