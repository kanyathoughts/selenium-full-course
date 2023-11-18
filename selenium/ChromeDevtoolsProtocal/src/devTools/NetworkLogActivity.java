package devTools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.network.Network;
import org.openqa.selenium.devtools.v95.network.model.Request;

public class NetworkLogActivity {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//we must enable network connection
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		//Event will get Fired when page is about to send HTTP request.
		devTools.addListener(Network.requestWillBeSent(), request -> {
			Request req = request.getRequest();
			System.out.println(req.getUrl());
			System.out.println(request.getRequestId());
		});
		
		//Event will get fired when HTTP response is available.
		devTools.addListener(Network.responseReceived(), receiver -> {
			
			org.openqa.selenium.devtools.v95.network.model.Response res =  receiver.getResponse();
			System.out.println(res.getStatus());
			if (res.getStatus().toString().startsWith("4")) {
				System.out.println(res.getUrl() + " is failing with status code: " + res.getStatus());
			}
			System.out.println(res.getUrl());
			
		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
		
	}

}
