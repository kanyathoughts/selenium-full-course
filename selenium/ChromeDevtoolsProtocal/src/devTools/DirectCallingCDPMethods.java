package devTools;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class DirectCallingCDPMethods {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//Creating hashmap for the parameters
		Map<String, Object> deviceParams = new HashMap<>();
		deviceParams.put("width", 600);
		deviceParams.put("height", 1000);
		deviceParams.put("deviceScaleFactor", 50);
		deviceParams.put("mobile", true);
		
		//We are directly executing cdp method by calling below method
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceParams);

	}

}
