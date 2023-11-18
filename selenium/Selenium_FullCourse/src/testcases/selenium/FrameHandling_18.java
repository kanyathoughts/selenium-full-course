package testcases.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandling_18 {

	public static void main(String[] args) {
		//Frame is a part of website which displays independent content in the browser/website
		//we can deploy frame container in any webpage.
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		//get the number of frames in page.
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//Switching to frame using webelement of the frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		driver.findElement(By.cssSelector("#draggable")).click(); //no such element exception because it is inside the frame.
		
		Actions a = new Actions(driver);
		WebElement draggableElement = driver.findElement(By.cssSelector("#draggable"));
		a.dragAndDropBy(draggableElement, 
				draggableElement.getLocation().x + 1000, draggableElement.getLocation().y + 200).build().perform();
		
		//Once all the operations done inside the frame we have to come back to default content
		driver.switchTo().defaultContent();
		
	}

}
