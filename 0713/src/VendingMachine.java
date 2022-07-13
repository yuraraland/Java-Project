
public class VendingMachine {
	
	Drink dr1 = new Drink();
	int coin;
	int pickNum;
	
	public void menu (int c) {
		
		this.coin=c;
		
		if (c>=900) {
			for (int i=0; i<4; i++) {
			System.out.print((i+1)+"."+dr1.drinkName(i)+" ");
						}
			} else if (c>=700 && c<900 ) {
				for (int i=0; i<3; i++) {
					System.out.print((i+1)+"."+dr1.drinkName(i)+" ");
				}
			} else if (c>=500 && c<700) {
				for (int i=0; i<2; i++) {
					System.out.print((i+1)+"."+dr1.drinkName(i)+" ");
				}
			} else {
				System.out.println("\"Be short of money\"");
			}

	}
	
	public String choice (int p) {
		this.pickNum=(p-1);
		return dr1.drinkName((p-1));
	}
	
	public int change (int c) {
		return (c-dr1.drinkPrice(this.pickNum));
	}
	

}