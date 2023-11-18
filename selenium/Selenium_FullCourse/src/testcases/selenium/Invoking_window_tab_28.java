package testcases.selenium;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Invoking_window_tab_28 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//driver.switchTo().newWindow(WindowType.TAB); //This will open new tab in browser but focus will stay in the parent tab only.
		
		driver.switchTo().newWindow(WindowType.WINDOW); //This will open new window but focus will stay in the parent window only.
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		
		driver.navigate().to("https://rahulshettyacademy.com/");
		
		Thread.sleep(5000);
		
		//Get the first course name
		String text = driver.findElements(By.xpath("//a[contains(@href, 'https://courses.rahulshettyacademy.com/p')]")).get(1).getText().trim();
		
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		//entering first course name into name edit field
		WebElement nameEditField = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
		nameEditField.sendKeys(text);
		
		//Taking screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copy src file to local directory
		Files.copy(src, new File ("./fullScreenShot.png"));
		
		//Capture web element screenshot
		File nameEditFieldSS = nameEditField.getScreenshotAs(OutputType.FILE);
		Files.copy(nameEditFieldSS, new File("nameEditFieldSS.png"));
		
		//get height and width of particular web element
		System.out.println("height: " + nameEditField.getRect().getDimension().getHeight());
		System.out.println("width: " + nameEditField.getRect().getDimension().getWidth());
		
		

	}

}
