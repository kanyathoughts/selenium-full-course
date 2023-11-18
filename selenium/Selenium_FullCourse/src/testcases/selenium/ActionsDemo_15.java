package testcases.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo_15 {

	public static void main(String[] args) throws InterruptedException {
		/**
		 * Actions Class is used for mouse hovering and keyboard operations.
		 * Double click on web element
		 * drag and drop 
		 * Entering text in capital letters
		 */
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		
		//move mouse to specific element
		//We need to give both build and perform methods at the end to perform this action.
		a.moveToElement(driver.findElement(By.xpath("//a[@class='nav-a nav-a-2   nav-progressive-attribute'][1]"))).build().perform();
		
		//Enter Capital letters in text box by holding shift key down and entering text and selecting text by double clicking
		a.moveToElement(driver.findElement(By.cssSelector("input#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//move to element and right click(context click)
		a.moveToElement(driver.findElement(By.xpath("//a[@class='nav-a nav-a-2   nav-progressive-attribute'][1]"))).contextClick().build().perform();
		
		//move to element by taking offset(x and y coordinates)
		a.moveByOffset(1526, 35).build().perform();
		
		//Checking with real time project
		driver.get("http://localhost:8080/#/clients");
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Worx2000");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		
		action.moveByOffset(487, 380).click().build().perform();
	}

}
