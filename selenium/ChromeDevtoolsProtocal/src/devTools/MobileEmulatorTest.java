package devTools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		/*//Generally we will create driver object with webDriver interface but that will not support chrome dev tools interaction with selenium so that is why we are using specific ChromeDriver class for that.
		ChromeDriver driver = new ChromeDriver();
		
		
		DevTools devTools = driver.getDevTools();
		
		//We have to establish session from selenium to dev tools
		
		devTools.createSession();
		
		//send command to CDP methods -> CDP methods will invoke and get access to chrome dev tools
		
		//You can open this url and read the description of method what you want to give 
		//https://chromedevtools.github.io/devtools-protocol/tot/Emulation/#method-setDeviceMetricsOverride
		
		//First 4 parameters are required and remaining are Optional so we are wrapping them with Optioanl.empty
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.className("navbar-toggler")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@routerlink='/library']")).click();*/
		
		EdgeDriver driver = new EdgeDriver();
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		devTools.send(org.openqa.selenium.devtools.v95.emulation.Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.className("navbar-toggler")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@routerlink='/library']")).click();
		
		
		
		
		
		
	}
}
