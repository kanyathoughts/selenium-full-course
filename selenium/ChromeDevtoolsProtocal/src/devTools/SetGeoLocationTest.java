package devTools;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocationTest {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		// Creating hashmap for the parameters
		Map<String, Object> deviceParams = new HashMap<>();
		deviceParams.put("latitude", 40);
		deviceParams.put("longitude", 30);
		deviceParams.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", deviceParams);
		
		driver.get("https://google.com/");
		driver.findElement(By.name("q")).sendKeys("Netflix", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("(//h1[@class='our-story-card-title'])[1]")).getText());
	}

}
