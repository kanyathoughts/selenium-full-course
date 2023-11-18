package devTools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.network.Network;
import org.openqa.selenium.devtools.v95.network.model.ConnectionType;

public class NetworkSpeed {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//we must enable network connection
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		//We can handle network speed of the web page 
		//This will help you in condition where you have developed one page and it's working very fast in the nights but in the mornings 
		//it's facing some lagging issues for others so we need to slow down the network speed and test the web page.
		
		//Here the second parameter is important which is latency(in milli seconds) latency means delay so we are giving 3 seconds delay to load page.
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET))); //The last parameter is optional so that is why we have to wrap it inside optional
		
		devTools.addListener(Network.loadingFailed(), loadingFailed -> {
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
		});
		
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

}
