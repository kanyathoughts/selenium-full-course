package sample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import kanya.AbstractComponents.AbstractComponent;
import kanya.PageObjects.ProductCatelouge;
import kanya.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest{
	
	//It will show you errors as we are expecting Before method and after method from parent class and those methods are not having same group name.
	//Remedy for that is put "alwaysRun=true" attribute to both BeforeMethod and AfterMethods.
	@Test(groups={"ErrorHandling"})
	public void errorHandling() {
		lp.loginApplication("kanya@gmail.com", "kanya");
		System.out.println(lp.getErrorMessage());
	}
	
	@Test
	public void prodcutErrorHandling() throws InterruptedException, IOException {
		//Login
		lp.loginApplication("satya@gmail.com", "Satya@9134");
		
		ProductCatelouge pc = new ProductCatelouge(driver);
		pc.addProductToCart("ZARA COAT 3");
		
		//Click on Cart button
		new AbstractComponent(driver).gotoCartPage();
		
		Thread.sleep(5000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[contains(.,'zara coat 3')]//h3[text()='zara coat 33']")).isDisplayed(), false);
	}
}
