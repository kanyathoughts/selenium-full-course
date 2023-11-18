package testcases.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.*; //We have to write manually add this static import, eclipse will not identify static imports be default.

public class Relative_Locators_27 {
	
	@Test
	public void step01() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//label[contains(.,' Option1')]//input")).click();
	}
	
	public static void main(String[] args) {
		/**
		 * Relative locators is the new concept in the selenium from 4.0 version
		 * Few objects/web elements don't have the attributes to identify them so we have to relay on parent to child traverse to identify them
		 * To overcome this problem selenium came up with relative locators concept
		 * 
		 * We can identify any webelement based on it's above/below web elements
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.manage().window().maximize();
		//Relative locators as of now they are supporting only tag name locator
		
		//I wanted to identify "Name" web element which has only tag name
		//It is above the name input field so identifying it, above the name input field 
		WebElement nameInput = driver.findElement(By.xpath("//input[@name='name' and @type='text']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameInput)).getText());
		
		//We wanted to click on Date Of birth element to select date but
		//relative locators can not handle "flex" elements inside the DOM so it will find out the next below web element and clicks on that.
		
		WebElement DateOfBirth = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(DateOfBirth)).click();
		
		//to left of
		//selecting checkbox based upon it's label
		WebElement iceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
		
		//find out student label by it's radio button
		WebElement studentRadioButton = driver.findElement(By.xpath("//input[@class='form-check-input' and @id='inlineRadio1']"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(studentRadioButton)).getText());
	}

}
