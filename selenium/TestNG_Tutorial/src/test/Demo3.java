package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo3 {
	@Test
	public void webLoginCarLoan() {
		System.out.println("web Login car loan");
	}
	
	@Test
	public void mobileLoginCarLoan() {
		System.out.println("mobile Login car loan");
	}
	
	//We can skip the test case by giving enabled attribute value is false
	@Test(enabled=false)
	public void mobileLogin1CarLoan() {
		System.out.println("mobile Login1 car loan");
	}
	
	@Test(dependsOnMethods={"mobileLoginCarLoan"})
	public void mobileLogin2CarLoan() {
		System.out.println("mobile Login2 car loan");
	}
	
	@Test(dependsOnMethods={"mobileLoginCarLoan"})
	public void mobileLogin3CarLoan() {
		System.out.println("mobile Login3 car loan");
	}
	
	//This will wait till 4 seconds before failing that step directly.
	@Parameters({"URL"})
	@Test(timeOut=4000)
	public void APILoginCarLoan(String url) {
		System.out.println("API Login car loan");
		System.out.println("car loan url: " + url);
	}

}
