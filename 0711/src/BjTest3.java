import java.util.*;
public class BjTest3 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int su = 0;
		
		for (int i=1; i<=n; i++){
			su=(n-i)+1;
			System.out.println(su);
		} 
	}

}
