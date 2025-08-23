package ex_02_RA_Concepts;

public class APITesting_Lab03_NP {

	// No Design pattern
	public void step1() {
		System.out.println("Step 1");
	}
	
	public void step2() {
		System.out.println("Step 2");
	}
	
	public void step3(String name) {
		System.out.println("Step 3");
	}
	public static void main(String[] args) {
		APITesting_Lab03_NP nbp = new APITesting_Lab03_NP();
		nbp.step2();
		nbp.step1();
		nbp.step3("Mangesh");
		
	}
}
