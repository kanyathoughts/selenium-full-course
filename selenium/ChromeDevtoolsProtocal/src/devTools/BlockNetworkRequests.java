package devTools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequests {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//we must enable network connection
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		//all the images with extension (.jpg) and all styling formats with extension (.css) will be blocked
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));
		
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
		System.out.println(driver.findElement(By.xpath("(//p)[1]")).getText());
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
	}

}
