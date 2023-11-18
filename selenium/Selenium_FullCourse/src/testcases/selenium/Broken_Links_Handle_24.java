package testcases.selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Broken_Links_Handle_24 {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Broken link is nothing but the URL of the particular link is not working
		//we can see generally see 404 (or) 500 error then url is not working
		//404 is the status code if the status code is more than 400 then the url is broken and it will not work.
		
		driver.manage().window().maximize();
		Thread.sleep(5000);

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, 5000)"); //scroll down to end
		
		SoftAssert a = new SoftAssert();
		
		List<WebElement> allLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for (WebElement link: allLinks) {
			String url = link.getAttribute("href").trim();
			
			//openConnection is a method inside the URL class and it is used to say link is broken or not without opening the link in browser 
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			
			//SoftAssertion is assertion which will proceed the execution even after any test fails in middle
			a.assertTrue(responseCode < 400, link.getText().trim());
			
		}
		a.assertAll();//You should give this at the end otherwise softassert will catch the failures but it won't report it at the end.
		//Otherwise test will always pass even failures present inside the test.
		
		
	}

}
