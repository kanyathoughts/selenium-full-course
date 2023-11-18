package testcases.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1_8 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kdarisi\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(), 3);
		
		driver.findElement(By.name("checkBoxOption1")).click();
		Assert.assertEquals(driver.findElement(By.name("checkBoxOption1")).isSelected(), true);
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("checkBoxOption1")).click();
		Assert.assertEquals(driver.findElement(By.name("checkBoxOption1")).isSelected(), false);
		

	}

}
