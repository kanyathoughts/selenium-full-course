package devTools;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.fetch.Fetch;
import org.openqa.selenium.devtools.v95.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v95.network.model.ErrorReason;

public class NetworkFailedRequest {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//If we want to check errors when any request is failed in the real time but we don't know when the request is going to fail
		//For that we can manually fail the particular request with any specified reason
		
		//We are getting request url's if they have only shetty inside it
		Optional<List<RequestPattern>> patterns =  Optional.of(Arrays.asList(new RequestPattern(Optional.of(".*shetty.*"), Optional.empty(), Optional.empty())));
		
		//we must enable Fetch connection
		devTools.send(Fetch.enable(patterns, Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), request -> {
			//we are failing request
			Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED);
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
		
	}

}
