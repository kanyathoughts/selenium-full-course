package test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo1 {

	//Anything inside main method will only work in java test because here java compiler is used
	//We can still execute our steps with testng by using test ng compiler
	
	//This is test level execution (inside suite we have test modules)
	//we have given this in Demo1 and Demo1 we have given inside "Personal loan" test module so the below BeforeTest will execute first before the "Personal loan" test module
	//The scope is only to the related test folder
	@BeforeTest
	public void firstExecution() {
		System.out.println("first execution");
	}
	
	//We can define BeforeSuite in any test but this BeforeSuite will execute first
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I'm the first");
	}
	
	//We can define AfterSuite in any test but this AfterSuite will execute last
	@AfterSuite
	public void afterSuite() {
		System.out.println("I'm the last");
	}
	//Every step will act as a separate test case
	@Test(groups={"smoke"})
	public void step01() {
		System.out.println("hi");
		//This will fail the test
		Assert.assertTrue(false);
	}
	
	@Parameters({"URL"})
	@Test
	public void step02(String url) {
		System.out.println("Bye");
		System.out.println("personal loan url: " + url);
	}
	
	@AfterTest
	public void lastExecution() {
		System.out.println("last execution");
	}
	

}
