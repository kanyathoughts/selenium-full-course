package testcases.selenium;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSL_Check_22 {

	public static void main(String[] args) {
		//Chrome options will declare the behavior of the browser by setting few options.
		ChromeOptions option = new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		
		//We can add chrome extensions to our newly launched chrome browser.
		option.addExtensions(new File("C:\\Users\\kdarisi\\Downloads\\ChroPath.crx"));
		
		//It will allow to proxy the chrome driver 
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444"); //This is http proxy and we have to give ipaddress:port number
		option.setCapability("proxy", proxy);
		
		//It will block all the pop up's 
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking")); //open https://chromedriver.chromium.org/capabilities for more info.
		
		//we can change chrome downloads directory path.
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		option.setExperimentalOption("prefs", prefs);
		
		//open chrome in incognito mode
		option.addArguments("--incognito");
		
		//Same methods available in all other browsers
		FirefoxOptions option1 = new FirefoxOptions();
		option1.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://expired.badssl.com/"); //This is not secure web site so it will show you "it's not secured" and you have to click on Advanced button and click on proceed then only page will open.
		driver.manage().window().maximize();
		System.out.println(driver.getTitle().trim());
	}

}
