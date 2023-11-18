package testcases.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2_9 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kdarisi\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//name
		driver.findElement(By.name("name")).sendKeys("Kanya");
		//email
		driver.findElement(By.name("email")).sendKeys("kanyakumari950@gmail.com");
		//password
		driver.findElement(By.cssSelector("#exampleInputPassword1")).sendKeys("Jashu");
		//checkbox
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		//Dropdown
		WebElement dropDown = driver.findElement(By.cssSelector("#exampleFormControlSelect1"));
		Select genderList = new Select(dropDown);
		genderList.selectByIndex(1);
		Thread.sleep(1000);
		//Radio button
		driver.findElement(By.xpath("//label[text()='Student']/preceding-sibling::input")).click();
		//Calender
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("08/27/2022");
		//submit button
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText().trim());
	}

}
