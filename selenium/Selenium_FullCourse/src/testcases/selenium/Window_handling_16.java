package testcases.selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_handling_16 {

	public static void main(String[] args) throws InterruptedException {
		//In selenium the new tab opened from parent window is also considered as child window.
		//new tab/new window is considered as child window only.
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		Thread.sleep(2000);
		
		Set<String> windows = driver.getWindowHandles(); //It will get the windows id's of all windows. [parentid, childid]
		System.out.println(windows);
		
		Iterator<String> iterator = windows.iterator(); //We are iterating through set (windows) to get the child window ID.
		String parentWindowId = iterator.next();
		String childWindowId = iterator.next();
		
		driver.switchTo().window(childWindowId); //Switching to window by specifying the id.
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText().trim());
		String mailId = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().trim().split("at")[1].trim().split("with")[0].trim();
		System.out.println("mailId:" + mailId);
		
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#username")).sendKeys(mailId);
	}

}
