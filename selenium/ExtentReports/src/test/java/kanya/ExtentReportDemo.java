package kanya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	
	ExtentReports extent;
	@BeforeTest
	public void config() {
		//ExtentReport //ExtentSparkReporter This is the helper object for the extent reports object so we need to pass the extentSparkReporter object to the ExtentReports object.
		String path = System.getProperty("user.dir") + "/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Kanya");
		
	}
	
	@Test
	public void initialDemo() {
		ExtentTest test = extent.createTest("Initial Demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.close();
		//explicitly failing test
		test.fail("Results do not match");
		extent.flush();
	}

}
