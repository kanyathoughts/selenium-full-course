package kanya.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kanya.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		//Extends means parent to child so we can give child to parent as well by using super keyword.
		//Parent doesn't have the knowledge of driver object so that's why we are serving driver to our parent
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//This is the General way we create elements but driver.findElement this is everyTime biggest way to declare so in next line we can simplify this with one Annotation 
	//WebElement userName = driver.findElement(By.id("userEmail"));
	
	//This concept is called PageFactory Concept and we can have one more question, how this guy knows about driver object that is why we initialized "PageFactory.initElements(driver, this);" inside the constructor.
	@FindBy(id="userEmail")
	WebElement userName;
	
	@FindBy(id="userPassword")
	WebElement passWord;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public void loginApplication(String uN, String pW) {
		userName.sendKeys(uN);
		passWord.sendKeys(pW);
		loginButton.click();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public String getErrorMessage() {
		waitUntilElementToAppear(By.cssSelector("[class*='flyInOut']"), 5);
		return errorMessage.getText();
	}
	

}
