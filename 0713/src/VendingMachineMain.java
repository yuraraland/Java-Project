import java.util.*;
public class VendingMachineMain {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	VendingMachine vm1 = new VendingMachine();
	
	
	
	System.out.println("\"Insert coin\"");
	int coin = scan.nextInt();
	
	vm1.menu(coin);
	
	System.out.println();
	
	int pick = scan.nextInt();
	
	System.out.println(vm1.choice(pick) + "를 선택하셨습니다.");
	
	System.out.println("잔돈: " + vm1.change(coin)+"원.");
	

	
	}

}
