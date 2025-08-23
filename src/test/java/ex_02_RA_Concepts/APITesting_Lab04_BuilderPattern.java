package ex_02_RA_Concepts;

public class APITesting_Lab04_BuilderPattern {

	// instead of returning void return yourself 
	public APITesting_Lab04_BuilderPattern step1() {
		System.out.println("Step 1");
		return this;
	}
	
	public APITesting_Lab04_BuilderPattern step2() {
		System.out.println("Step 2");
		return this;
	}
	
	public APITesting_Lab04_BuilderPattern step3(String name) {
		System.out.println("Step 3");
		return this;
	}
	
	public static void main(String[] args) {
		
		APITesting_Lab04_BuilderPattern bp = new APITesting_Lab04_BuilderPattern();
		bp.step1().step2().step3("Mangesh");
	}
}
