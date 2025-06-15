package Student_study;
class atm1  {
	private int a;
	void setRupees(int a) {//getter function
		this.a=a;
		
	}
	int  getRupees() {  //setter function
		return a;
		
	}

}
public class atm {
	public static void main(String[] args) {
		atm1 x=new atm1();
		x.setRupees(89000);
		System.out.println("amount = "+ x.getRupees());
	}
}
