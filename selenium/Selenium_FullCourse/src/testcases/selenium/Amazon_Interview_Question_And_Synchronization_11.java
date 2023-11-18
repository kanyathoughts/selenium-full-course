package testcases.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon_Interview_Question_And_Synchronization_11 {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\kdarisi\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); This implicit wait is deprecated and use Duration instead of deprecated one.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1)); //we are declaring it globally and it will applicable to all web elements.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		
		driver.manage().window().maximize();
		addItems(driver);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//waiting explicitly to load promocode input
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("RahulShettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println("Explicit wait============================================================================");
		//Explicit wait
		//waiting explicitly to load after clicking on apply button.
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText().trim());
		
		driver.close();
		

	}
	
	private static void addItems(WebDriver driver) throws InterruptedException {
	
		//get all the products and by taking index click on one particular vegetable
		List<WebElement> allProducts = driver.findElements(By.cssSelector(".product-name"));

		// Get all the product names
		List<String> productNames = new ArrayList<String>();
		for (int k = 0; k < allProducts.size() - 2; k++) {
			productNames.add(allProducts.get(k).getText().trim().split("-")[0].trim());
		}
				
		String[] items = { "Brocolli", "Cucumber", "Beetroot" };
		// Convert from array to list
		List<String> itemsNeeded = Arrays.asList(items);

		// Print all the product names
		for (String value : productNames) {
			System.out.println("value: " + value);
		}
				
		//whenever product matches then click on Add to cart button.
		for (int i = 0; i < productNames.size(); i++) {
			String name = productNames.get(i).trim();

			for (String item : itemsNeeded) {
				if (name.equals(item)) {
					// click on "ADD TO CART" button of particular vegetable.
					//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(); //we are depending on text but this text is changing every time so please don't depend on dynamic text.
					driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
					break;
				}
			}
		}

		Thread.sleep(3000);
	}

}
