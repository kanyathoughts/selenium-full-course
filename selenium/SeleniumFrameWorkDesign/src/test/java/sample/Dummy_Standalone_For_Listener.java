package sample;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy_Standalone_For_Listener {
	
	@Test
	public void step01() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Global declaration of implicit wait for any sync issues
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/client/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//input[@placeholder='email@example.com']")).sendKeys("kanya@gmail.com");
		
		
		driver.findElement(By.id("userPassword")).sendKeys("Kanya@9134");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(3000);
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream().filter(p -> p.findElement(By.tagName("b")).getText().equalsIgnoreCase("zara coat 3")).findFirst().orElse(null);
		prod.findElement(By.xpath("//button[text()=' Add To Cart']")).click();
		
		//Here we can simply click on "Add to cart" button in a single line without using any steams and all.
		//driver.findElement(By.xpath("//div[@class='card' and contains(.,'zara coat 3')]//button[text()=' Add To Cart']")).click();
		
		//We have to explicitly wait until "product is added" message is visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		Thread.sleep(3000);
		
		//Click on Cart button
		driver.findElement(By.cssSelector("button[routerlink$='cart']")).click();
		
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[contains(.,'zara coat 3')]//h3[text()='zara coat 3']")).isDisplayed(), true);
		
		//click on checkout button
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		Thread.sleep(2000);
		
		/*//Auto suggestive drop down for selecting country
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button/span[text()=' India']")).click();*/
		
		//Selecting Country using Actions class
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button/span[text()=' India']"))));
		a.click(driver.findElement(By.xpath("//button/span[text()=' India']"))).build().perform();
		
		
		
		Thread.sleep(3000);
		
		//click on place order
		
		driver.findElement(By.xpath("//a[contains(.,'Place Order')]")).click();
		Thread.sleep(3000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()=' Thankyou for the order. ']")).isDisplayed(), true);
		
		driver.close();
	}
}
