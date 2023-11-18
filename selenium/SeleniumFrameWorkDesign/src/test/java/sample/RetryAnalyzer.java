package sample;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//In this way we can handle flaky tests 
public class RetryAnalyzer implements IRetryAnalyzer{

	int count=0;
	int maxCount=1;
	@Override
	public boolean retry(ITestResult arg0) {
		if(count<maxCount) {
			count++;
			return true; //As long as it will return true it will keep on retrying the failed tests.
		}
		return false; //When it return false then it will stop retrying execute failed tests.
	}

}
