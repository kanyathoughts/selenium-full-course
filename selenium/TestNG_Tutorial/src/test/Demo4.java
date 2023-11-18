package test;

import org.testng.annotations.Test;

public class Demo4 {
	
	@Test
	public void webLoginHomeLoan() {
		System.out.println("web Login Home loan");
	}
	
	@Test(groups={"smoke"})
	public void mobileLoginHomeLoan() {
		System.out.println("mobile Login Home loan");
	}
	
	@Test
	public void APILoginHomeLoan() {
		System.out.println("API Login Home loan");
	}

}
