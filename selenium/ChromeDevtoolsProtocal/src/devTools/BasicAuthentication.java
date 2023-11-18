package devTools;

import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class BasicAuthentication {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//This basic authentication is useful in some cases where some web pages will ask for username and password before redirecting and that will not have any locators to handle them through selenium.
		Predicate<URI> predicate = uri -> uri.getHost().contains("httpbin.org");
		
		((HasAuthentication)driver).register(predicate, UsernameAndPassword.of("foo", "bar"));
		
		driver.get("https://httpbin.org/basic-auth/foo/bar");

	}

}
