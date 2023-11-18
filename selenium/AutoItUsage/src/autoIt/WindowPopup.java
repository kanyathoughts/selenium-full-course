package autoIt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPopup {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Syntax is "https://username:password@siteURL" then selenium will understand the username and password and grab them from URL. We can handle this with CDP as well.
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();

	}

}
