package kanya.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	public static ExtentReports getReportObject() {
		//ExtentReport //ExtentSparkReporter This is the helper object for the extent reports object so we need to pass the extentSparkReporter object to the ExtentReports object.
				String path = System.getProperty("user.dir") + "/reports/index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setDocumentTitle("Test Results");
				reporter.config().setReportName("Web Automation results");
				
				ExtentReports extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Kanya");
				return extent;
	}
}
