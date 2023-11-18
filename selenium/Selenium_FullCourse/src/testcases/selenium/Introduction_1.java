package testcases.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v95.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;

public class Introduction_1 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Invoke browser
		 * ---------------
		 * browser can be invoked from different browsers
		 * 1. Chrome, We have chrome Driver and our script will interact with chrome driver first and chrome driver will interact with chrome browser
		 * Same for all other browsers as well.
		 */
		
		/*To access the chrome browser, we have chrome driver file and we have to set the property
		One more way is also there. we don't need to set the property everytime in the file.
		Paste all the browser drivers in one folders and create one variable inside the environament variables (Ex: SELENIUM_HOME)
		Open Path Variable and give that SELENIUM_HOME inside the path (Ex:%SELENIUM_HOME%) and save it. Restart the laptop then only this trick will work.*/
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kdarisi\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		
		//In this way we can see all the System keys and their values (Total System Properties)
		/*for (Object key: System.getProperties().keySet()) {
			System.out.println(key);
			System.out.println(System.getProperties().get(key));
			System.out.println("----------------------------------------------------------------------------------------------");
			
		}*/
		
		/*Web driver is an interface and it has common unimplemented methods so all browser drivers will implement the methods from Web Driver interface
		So that's why we will see same methods from all browsers 
		ChromeDriver Class will implement the WebDriver interface and it has it's own methods so we can use them if we create object like below:
		
		ChromeDriver driver = new ChromeDriver();
		then you can see all methods from WebDriver interface and own methods from ChromeDriver class as well.
		 */		
		WebDriver driver = new ChromeDriver(); //we will only see WebDriver interface methods.
		//get method will open the given URL in the browser.
		driver.get("https://rahulshettyacademy.com/");
		Thread.sleep(5000);
		//It will get the title of the page
		System.out.println(driver.getTitle());
		//It will get the current url of the page. 
		//URL full form -> Uniform Resource Locator
		System.out.println(driver.getCurrentUrl());
		//You have to use one of them because if the browser is already closed by close method then no browser is available to quit so test will get fail.
		driver.close(); //It will close the browser. It will close the window which got opened earlier.
		//driver.quit(); //It will close all the windows opened in browser
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\kdarisi\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
		
		//Launch edge 
		WebDriver edgeDriver = new EdgeDriver();
		edgeDriver.get("https://rahulshettyacademy.com/");
		Thread.sleep(5000);
		edgeDriver.close();
	}
	
}
