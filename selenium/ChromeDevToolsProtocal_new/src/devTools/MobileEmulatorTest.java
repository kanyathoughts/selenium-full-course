package devTools;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.emulation.Emulation;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		/*driver.findElement(By.className("navbar-toggler")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@routerlink='/library']")).click();*/

	}

}
