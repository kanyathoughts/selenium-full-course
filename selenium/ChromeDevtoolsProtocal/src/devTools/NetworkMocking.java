package devTools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.fetch.Fetch;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//We want to mock the http request and responses by giving inside the code for that we have to use Fetch domain
		//A domain for letting clients substitute browser's network layer with client code.
		
		//we must enable Fetch connection
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		//We have to pause the request and do our operation and we will do continue request with our client code to get altered response
		
		devTools.addListener(Fetch.requestPaused(), request -> {
			if (request.getRequest().getUrl().contains("shetty")) {
				String mockedURL = request.getRequest().getUrl().replace("shetty", "badGuy");
				
				System.out.println(mockedURL);
				//Once we we done with all the modifications we have to continue request with modified changes
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedURL), Optional.empty(), Optional.empty(), 
						Optional.empty(), Optional.empty()));
				//if any request doesn't contains shetty then request is being paused so we have to continue the request even it doesn't contains shetty
			} else {
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.empty(), Optional.empty(), Optional.empty(), 
						Optional.empty(), Optional.empty()));
			}
		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
		
		Thread.sleep(3000);
		//We have given badGuy in the request url and that guy has only one book in his library and then web page will display "OOPS only one book is available"
		System.out.println(driver.findElement(By.tagName("p")).getText());
	}

}
