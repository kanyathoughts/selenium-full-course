package kanya.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="button[routerlink$='cart']")
	WebElement cart;
	
	public void waitUntilElementToAppear(By findBy, int secondsToWait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	
	public void gotoCartPage() {
		cart.click();
	}
	
	
	

}
