package testcases.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath_5 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * We have 2 types of X paths:
		 * 1. Absolute Xpath: It starts from html tag that is starting of the page and we have to write all the tags to reach particular element.
		 * We have to start Absolute Xpath with single slash (Ex: /html/head/div)
		 * 2. Relative Xpath: We have to start with double slashes for the first time and proceed with single slashes (Ex: //header/div/button[3])
		 * We can start with any tag.
		 */

		//Parent to child traverse and sibling to it's following siblings and sibling to it's preceding siblings
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kdarisi\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//Clicking on Login button by taking practice sibling
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		//Taking Login button and get practive button as it is preceding sibling
		System.out.println(driver.findElement(By.xpath("//header/div/button[2]/preceding-sibling::button")).getText());
		
		//From child to parent traversing
		//Taking practice button and going back to header and taking blinking object
		String blinkingText = driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/child::a[@class='blinkingText']")).getText().trim();
		System.out.println("blinkingText: " + blinkingText);
		
		driver.close();
		
		
	}

}
