package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest_firefox {
	
	@Test
	public void step01() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("firefox");
//		caps.setPlatform(Platform.WIN10);
//		
//		caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//		caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.55.101:4444"), caps);
		driver.get("https://www.rahulshetty.com/");
		System.out.println(driver.getTitle());
		driver.close();
	}

}
