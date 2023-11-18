package testcases.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Locators2_4 {

	public static void main(String[] args) throws InterruptedException {
		String userName = "Kanya";
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kdarisi\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		
		//We can run our code in any browser.
		System.setProperty("webdriver.edge.driver", "C:\\Users\\kdarisi\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		String passWord = getPassWord(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize(); //maximize the window.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait means it will wait till the next element visible up to 10 seconds. 
		//And it will continue the execution process if it find the next element even in 2 seconds also then it won't wait for 10 seconds.
		driver.findElement(By.id("inputUsername")).sendKeys(userName);
		driver.findElement(By.name("inputPassword")).sendKeys(passWord);
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		driver.findElement(By.className("submit")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText().trim());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText().trim(), "Hello " + userName + ",");
		//By taking inner text also we can find out element and this is only in xpath and we don't have any logic for this in CSS.
		driver.findElement(By.xpath("//button[text()='Log Out']")).click(); 
	//	driver.findElement(By.xpath("//*[text()='Log Out']")).click(); //we can give this also then it will take any tag which has Log Out as inner text.
		
		Thread.sleep(2000);
		driver.close();

	}
	
	public static String getPassWord(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
		Thread.sleep(2000);
		String pwdContent = driver.findElement(By.cssSelector(".infoMsg")).getText().trim();
		return pwdContent.split("'")[1].split("'")[0].trim();
	}

}
