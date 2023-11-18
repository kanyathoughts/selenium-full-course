package testcases.selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Screenshot_Handle_23 {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		//maximize window
		driver.manage().window().maximize();
		
		//It will delete all the cookies
		//driver.manage().deleteAllCookies();
		
		//driver.manage().deleteCookieNamed("skli"); //delete cookie by it's name
		
		driver.manage().deleteCookieNamed("OptanonConsent"); //you will get the cookie name from inspect tool
		//inside developer toll(inspect) click on application and under storage section expand cookies section and select the link(url) to see how many cookies available for that link.
		
		
		//Taking screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Copying the file to our desired location.
		Files.copy(src, new File("./screenshot.png"));
		
		

	}

}
