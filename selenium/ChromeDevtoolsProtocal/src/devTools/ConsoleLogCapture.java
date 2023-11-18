package devTools;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogCapture {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.partialLinkText("Selenium")).click();
		driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();

		LogEntries entry = driver.manage().logs().get(LogType.BROWSER); //get log entries object
		 
		List<LogEntry> logs = entry.getAll(); //with logentry object with getall method we are getting all the logs
		for (LogEntry log: logs) {
			System.out.println(log);
		}
	}

}
