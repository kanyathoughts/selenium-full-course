package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {
	//We are giving URL parameter value inside the xml file in the test suite level.
	//We are grabbing that value into String value urlName 
	@Parameters({"URL", "key"})
	@Test
	public void paramTest(String urlName, String key) {
		System.out.println("param Test");
		System.out.println("urlName: " + urlName);
		System.out.println("key: " + key);
	}

}
