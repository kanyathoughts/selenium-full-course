package testcases.selenium;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope_19 {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		//get how many links available in the page by using tagname "a"

		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//Limiting web driver scope
		//get links count from footer section and I wanted to limit my browser for that footer section only. I don't want to check all the links inside the browser
		
		WebElement footer = driver.findElement(By.cssSelector(".footer_top_agile_w3ls.gffoot.footer_style"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		//get the links count from first section of footer section
		WebElement firstSection = footer.findElement(By.xpath("//td[1]/ul"));
		System.out.println(firstSection.findElements(By.tagName("a")).size());
		
		String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
		
		//click on each link inside the first section and check if links are working.
		for (int i =1; i < firstSection.findElements(By.tagName("a")).size(); i++) {
			//if we click on link then it will open in the same tab and we can click other links of parent page.
			//If we do control + click then link will open in new tab and focus will be on our parent page only then we can click on next links as well.
			firstSection.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink); //instead of normal click we have to pass the keys to be pressed inside the send keys method.
		}
		Thread.sleep(10000);
		//Get the page titles of all opened links in new tabs by window handles
		Set<String> windowHandle = driver.getWindowHandles();
		System.out.println(windowHandle.size());
		for (String s : windowHandle) {
			System.out.println(driver.switchTo().window(s).getTitle().trim());
		}
		
		System.out.println("------------------------------------------------Another way of doint it by using iterator---------------------------------------------------------------");
		
		Iterator<String> itr = windowHandle.iterator();
		while(itr.hasNext()) {
			System.out.println(driver.switchTo().window(itr.next()).getTitle().trim());
		}
	}

}
