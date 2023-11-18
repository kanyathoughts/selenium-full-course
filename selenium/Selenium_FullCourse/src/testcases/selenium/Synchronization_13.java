package testcases.selenium;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Synchronization_13 {

	public static void main(String[] args) {
		/*Implicit wait - Hey wait for maximum time(Ex: 5 seconds) before throwing exception
		If the object finds within 2 seconds then selenium won't wait till 5 seconds and it will continue the execution after finding the element 
		If the object is not identified within 5 seconds then selenium will throw exception
		Pros: Readable code
		Cons: Performance cause issues are not caught
		*/
		
		/*Explicit wait
		It is specific to particular webelement.
		Pros: Wait is applied only on the targeted elements so no performance issues
		Cons: More lines of code for every element.
		*/
		
		/*
		 * Explicit wait can be achieved in 2 ways:
		 * WebDriverWait (Eg: 10sec)
		 * FluentWait (Eg: 10sec and polling=4sec) This is exactly similar to WebDriverWait but slight difference
		 * If we are working on credit card payment then in first 3 seconds it will accept the card
		 * In next 3 seconds it will display payment is processing
		 * in next 3 seconds it will display payment successful. And all the texts displaying have the same tags and same properties so with WebDriverWat we can find first it within 3 seconds and 
		 * it will go check for confirmation button but it will not visible in that case flentwait is very helpfu;
		 */
		//Thread.sleep
		//If we give 5 seconds wait, even tough webelement found in 3 sec then also selenium is keep on waiting till 5 seconds.
		//Fluent wait
		//DOM - Document Objectory Model which is the Html code of that page/web browser
		
		//Fluent wait Example
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		//Wait is interface and FluentWait class is extending Wait interface.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement wb = wait.until(new Function<WebDriver, WebElement>() {

			
			@Override
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed()) {
					return driver.findElement(By.xpath("//div[@id='finish']/h4"));
				}
				return null;
			}
		});
		
		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText().trim());
		//Fluent wait is not famous than WebDriverWait and in interviews it will be asked more.
		//Both FluentWait and WebDriverWait are the calsses that will implement the "Wait" interface.
		//In WebDriverWait we have inbuilt methods to identify webelements and in FluentWait we have to write our customized methods.

	}

}
