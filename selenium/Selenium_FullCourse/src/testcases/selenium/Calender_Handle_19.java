package testcases.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender_Handle_19 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//Clicking on calender web element
		driver.findElement(By.xpath("//div[contains(@class,'elementor-field-group-travel_comp_date')][1]")).click();
		//Click on next button till our desired month reaches.
		String month = "May";
		while (! driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText().trim().contains(month)) {
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
			Thread.sleep(1000);
		}
		//Clicking on exact day inside the month.
		String day = "25";
		List<WebElement> days = driver.findElements(By.className("flatpickr-day"));
		int daysCount = days.size();
		for (int i = 0; i < daysCount; i++) {
			String text = days.get(i).getText().trim();
			if (text.equalsIgnoreCase(day)) {
				days.get(i).click();
				break;
			}
		}
		
		Thread.sleep(3000);
		//open makemytrip as realtime example
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		Thread.sleep(2000);
		//first month group
		WebElement monthOne = driver.findElement(By.xpath("//div[@class='DayPicker-Month'][1]"));
		//WebElement monthTwo = driver.findElement(By.xpath("//div[@class='DayPicker-Month'][2]"));
		
		String newMonth = "March";
		String newDate = "27";
		
		while (! monthOne.getText().trim().contains(newMonth)) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			Thread.sleep(2000);
		}
		
		List<WebElement> newDays = monthOne.findElements(By.xpath("//div[@class='DayPicker-Day']"));
		for (int i = 0; i < newDays.size(); i++) {
			if (newDays.get(i).getText().trim().contains(newDate)) {
				newDays.get(i).click();
				break;
			}
		}
	}
}
