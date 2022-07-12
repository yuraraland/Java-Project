
public class Lotto {

	public static void main(String[] args) {
		
		int[] arr = new int[6];
		
		for(int i=0; i<arr.length;) {
			int su = (int)(Math.random()*45+1);
			boolean b = true;
			arr[i] =su;
				for (int j=0; j<i; j++) {
					if (arr[i]==arr[j]) {
						b=false;
						break;
					}
				} if (b) {
					++i;
				}
		}
	 for (int k=0; k<arr.length; k++) {
		System.out.printf("%-3d", + arr[k]);
	}
	 
	}

}
