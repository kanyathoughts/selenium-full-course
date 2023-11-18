package testcases.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_Handle_10 {

	public static void main(String[] args) throws InterruptedException {
		String text = "Kanya";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kdarisi\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		//We are switching browser context to alert because alert is not related to html and it is related to java script and we can not inspect alerts.
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept(); //positive response
		Thread.sleep(2000);
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss(); //Negative response.
		Thread.sleep(1000); 
		
		//If we want to check whether the web element is present inside the browser we have to use isDisplayed() method.
		
		//Debugging in eclipse
		/*
		 * 1. we have to put the break point at any line to debug the code.
		 * 2. it will execute till the debug point reaches and will pause the execution once it reached debug point
		 * 3. to proceed to next lines press F6(Step over)
		 * 4. to go inside the method press F5(Step into)
		 * 5. To resume our test press F8(resume)
		 * 6. If we have multiple breakpoints and pressing F8 will resume your test till reaches next break point and we have to proceed with our F6/F5/F8.
		 */
	}

}
