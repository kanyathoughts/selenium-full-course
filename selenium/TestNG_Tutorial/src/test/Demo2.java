package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo2 {
	
	//before class it will execute only one time
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}
	
	//before each and evry method this will execute
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	//Generally first step will get execute but we have given dependsOnMethods Condition where it will dependent on setp02 so step02 will get execute first and then only step01 will get execute.\
	//We can define groups and dependsOnMethods variables at a time by using comma separator.
	//We can mention any number of steps
	@Test(dependsOnMethods={"step02", "step03"},groups={"smoke"})
	public void step01() {
		System.out.println("hello");
	}

	@Test(groups={"smoke"})
	public void step02() {
		System.out.println("This is step02");
	}
	
	@Test
	public void step03() {
		System.out.println("This is step03");
	}
	
	//after each and every method this will execute
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
	}
	
	//after class it will execute only one time.
	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}
	
	@AfterTest
	public void lastExecutionDuplicate() {
		System.out.println("last execution duplicate");
	}
}
