package testcases.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table_Handling_12 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://qef-linux8-us-dm.deloitte.com:8080/");
		System.out.println("page is opened");
		Thread.sleep(5000);
	
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Worx2000");
		driver.findElement(By.xpath("//button[@type='submit' and text()='Sign In']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//p[text()='Demo Client 1']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Demo Project A']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@href='#/project-1/configuration']")).click();
		Thread.sleep(5000);
		customPropertyEditButtonClick("Custom Property Tag", driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@nztype='dashed']")).click();
		driver.findElement(By.xpath("//nz-form-item[contains(*, 'Default')]/child::nz-form-control/descendant::input[4]")).sendKeys("Tag4");
		driver.findElement(By.xpath("//button[@type='button' and contains(., 'Save')]")).click();
		
		

	}

	//Clicks on edit button of Custom Property value
	private static void customPropertyEditButtonClick(String customProperty, WebDriver driver) {
		int value = driver.findElements(By.xpath("(//table)[2]//th")).size();
		driver.findElement(By.xpath("(//table)[2]//td[contains(.,'" + customProperty+ "')]/parent::tr/child::td[" + value + "]//i")).click();
		
	}
}
