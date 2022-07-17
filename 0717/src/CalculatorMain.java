
public class CalculatorMain {

	public static void main(String[] args) {
		

		Calculatoer c1 = new Calculatoer();
		c1.powerOn();
		
		int result1 = c1.plus(5, 6);
		System.out.println("result1: " + result1);
		
		byte x = 10;
		byte y = 4;
		double result2 = c1.divide(x, y);
		System.out.println("result2: " + result2);
		
		c1.powerOff();
		
		
		

	}

}
