package testcases.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_21 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		int rowsCount = driver.findElements(By.xpath("(//table[@id='product'])[1]//tr")).size();
		System.out.println("rowsCount: " + rowsCount);
		
		int columnsCount = driver.findElements(By.xpath("(//table[@id='product'])[1]//th")).size();
		System.out.println("columnsCount: " + columnsCount);
		
		System.out.println(driver.findElement(By.xpath("(//table[@id='product'])[1]//tr[3]")).getText().trim());
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind");
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ENTER);
	}

}
