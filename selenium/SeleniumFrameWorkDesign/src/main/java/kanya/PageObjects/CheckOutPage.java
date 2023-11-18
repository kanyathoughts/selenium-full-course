package kanya.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kanya.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
	
	By countryFindBy = By.xpath("//button/span[text()=' India']");
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), countryName).build().perform();
		waitUntilElementToAppear(countryFindBy, 5);
		a.click(driver.findElement(countryFindBy)).build().perform();
	}
	

	

}
