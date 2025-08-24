package ex_05_TestNGExamples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting023_All_Annotations {

	@BeforeSuite
	public void demo1() {
		System.out.println("BeforeSuite");
	}
	
	@BeforeTest
	public void demo2() {
		System.out.println("BeforeTest");
	}
	
	@BeforeClass
	public void demo3() {
		System.out.println("BeforeClass");
	}
	
	@BeforeMethod
	public void demo4() {
		System.out.println("BeforeMethod");
	}
	
	@Test
	public void demo5() {
		System.out.println("Test");
	}
	
	@AfterMethod
	public void demo6() {
		System.out.println("AfterMethod");
	}
	
	@AfterClass
	public void demo7() {
		System.out.println("AfterClass");
	}
	
	@AfterTest
	public void demo8() {
		System.out.println("AfterTest");
	}
	
	@AfterSuite
	public void demo9() {
		System.out.println("AfterSuite");
	}
	
	
	
}
