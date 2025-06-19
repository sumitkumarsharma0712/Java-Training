
public class Test {

	public static void main(String[] args) {
//		String str = null;
//		System.out.println(str.length());
	
		int[] arr = {1,2,3,4,7,7};
		try {
			System.out.println(arr[5]);
		}catch (Exception e) {
			System.out.println("Exception occurred:" + e);
			
		}
		System.out.println("End of program");
		

	}

}
