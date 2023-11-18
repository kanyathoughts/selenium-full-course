package kanya.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kanya.AbstractComponents.AbstractComponent;

public class ProductCatelouge extends AbstractComponent{
	
	WebDriver driver;
	public ProductCatelouge(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

	//For the list of elements
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	public List<WebElement> getProductsList() {
		waitUntilElementToAppear(By.cssSelector(".mb-3"), 5);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		return getProductsList().stream().filter(p -> p.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
	}
	
	public void addProductToCart(String productName) throws InterruptedException {
		WebElement prod = getProductByName(productName);
		System.out.println("product inner text: " + prod.getText());
		prod.findElement(By.xpath("//button[text()=' Add To Cart']")).click();
		waitUntilElementToAppear(By.cssSelector("#toast-container"), 5);
		Thread.sleep(4000);
	}
	

}
