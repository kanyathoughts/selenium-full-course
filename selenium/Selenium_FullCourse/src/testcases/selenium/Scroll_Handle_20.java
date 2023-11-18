package testcases.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll_Handle_20 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Scrolling can not handle by selenium/leanft we have to handle that by javascript
		//scrollBy is used for both vertical scroll and horizontal scroll
		/*
		 * scrollBy(500, 0) //scroll right
		 * scrollBy(-500, 0) //scroll left
		 * scrollBy(0,500) //scroll down
		 * scrollBy(0, -500) //scroll up
		 * scrollBy(5000, 5000) //both scroll right and scroll down will perform
		 * scrollBy(-5000, -5000) //both scroll left and scroll up will perform
		 */
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//This is window scrolling not to any specific element
		jse.executeScript("window.scrollBy(0,500)"); //It will scroll down for (500 y coordinates)
		
		//jse.executeAsyncScript("window.scrollBy(0, -500)"); //It will scroll up by (500 y coordinates)
		
		Thread.sleep(3000);
		//This is specific to web element in the browser document
		jse.executeScript("document.querySelector(\"div[class='tableFixHead']\").scrollTop=500"); //Scroll top means not scrollup it is equal to all data to up means scroll down
		//If you want to scroll up completely then give scrollTop=-500
		
		int amountColumnIndex = getColumnIndexFromTable(driver, "Amount");
		System.out.println(amountColumnIndex);
		int newCount = amountColumnIndex + 1;
		int sum = 0;
		List<WebElement> amountColumnData =  driver.findElements(By.xpath("(//table[@id='product'])[2]//td[" + newCount  + "]"));
		for (WebElement value : amountColumnData) {
			sum = sum + Integer.valueOf(value.getText().trim());
		}
		System.out.println("total sum: " + sum);
		
		int actualSum = Integer.valueOf(driver.findElement(By.cssSelector(".totalAmount")).getText().trim().split(":")[1].trim());
		System.out.println("Actual sum: " + actualSum);
		Assert.assertEquals(sum, actualSum);
	}
	
	/*
	 * It will give the column index value by taking column name in the table.
	 */
	private static int getColumnIndexFromTable(WebDriver driver, String columnName) {
		List<WebElement> columnsList = driver.findElements(By.xpath("(//table[@id='product'])[2]//th"));
		for (int i = 0; i <= columnsList.size(); i++) {
			if (columnsList.get(i).getText().trim().equalsIgnoreCase(columnName)) {
				return i;
			}
		}
		return -1;
		
	}
}
