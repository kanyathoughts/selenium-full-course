package testcases.selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Window_Handling_Assignment_17 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		
		//Explicitly wait until click here link is visible.
		WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(clickHere));
		
		clickHere.click();
		//Storing window id's in set.
		Set<String> windows = driver.getWindowHandles();
		//Iterating into set to grab window id's
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		//Switching to child window.
		driver.switchTo().window(childId);
		System.out.println("child text: " + driver.findElement(By.tagName("h3")).getText().trim());
		//Switching back to parent window
		driver.switchTo().window(parentId);
		System.out.println("parent text: " + driver.findElement(By.tagName("h3")).getText().trim());
	}

}
