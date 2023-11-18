package testcases.selenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Table_Handling_26 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		Thread.sleep(2000);
		
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered']"));
		
		//clicking on the veg column to make it ascending order
		driver.findElement(By.xpath("//th[contains(.,'Veg')]//span[contains(@class,'sort-icon')]")).click();
		
		Thread.sleep(2000);
		List<WebElement> AscenVegData = table.findElements(By.xpath("//td[1]"));
		List<String> AscendingVeggies = AscenVegData.stream().map(veg -> veg.getText().trim()).collect(Collectors.toList());
	
		
		System.out.println("AscendingVeggies: " + AscendingVeggies);
		
		List<String> expectedAscendingVeggies = AscendingVeggies.stream().sorted().collect(Collectors.toList());
		
		System.out.println("expectedAscendingVeggies: " + expectedAscendingVeggies);
		
		boolean isMatch = expectedAscendingVeggies.removeAll(AscendingVeggies);
		Assert.assertEquals(isMatch, true);
		
		List<String> price;
		//Get the price of exact vegetable
		do {
			List<WebElement> rows = table.findElements(By.xpath("//td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPrice(s)).collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));
		
			if (price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		}while(price.size() < 1);
		
		//filter items in table
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
		Thread.sleep(2000);
		List<WebElement> firstColumnItems = driver.findElements(By.xpath("//tr//td[1]"));
		
		Assert.assertEquals(firstColumnItems.size(), (int) firstColumnItems.stream().filter(s -> s.getText().contains("Rice")).count());
		
	}
	
	private static String getPrice(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText().trim();
	}

}
