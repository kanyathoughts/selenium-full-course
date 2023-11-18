package testcases.selenium;

public class TestNG_Notes {

		//TestNG is a testing framework inspired from JUnit and NUnit but introducing some new functionalities that make it more powerful and easier to use
		/*
		 * To work with TestNG we need to update pm.xml with TestNG dependency and we need to install TestNG plugin inside Eclipse using Eclipse Marketplace.
		 */
	
	/**
	 * Testng xml file is the heart of the testng framework
	 * 
	 * hierarchy is test suite > tests(modules) > classes
	 * 
	 * A test suite contains multiple test modules and inside classes tag, we can add multiple class names to be executed.
	 */
	
	/**
	 * Jenkins Basic Notes:
	 * ___________________________________
	 * 
	 * Jenkins to work in your local machine we have to install jenkins for windows around 90mb file
	 * 
	 * Once it downloaded we have to give port number(8081) where it will run on local host
	 * 
	 * we can create one freestylejob and we can add parameters as well.
	 * 
	 * As we are doing from maven we have to give maven command to run our test
	 * 
	 * Inside the configure, inside the "build steps" we have to select "Invoke top-level Maven targets" and we can give our command to execute our profiles
	 * 
	 * To select our code from jenkins, inside the advanced options we have to select "Use custom workspace"  and we can give our local path for the project
	 * 
	 * We have one logic on how to trigger build periodically:
	 * ------------------------------------------------------
	 * 
	 * We have to click on "Build Triggers" menu inside the configure and click on Build periodically option
	 * 
	 * we have one logic with 5 stars(* * * * *) 
	 * -------------------------------------------
	 * first star represents minutes (0-59)
	 * Second star represents hours (0-23)
	 * 3rd star represents day in month (1-31)
	 * 4rth star represents month in year (1-12)
	 * 5th star represents day of the week (0-7) where 0 is sunday and continues
	 */
	
	/**
	 * static should be avaoided for parallel tests run why bacuase static represents common space alloacation among all the threads in that case it will affect the concept of parallel test execution.
	 * 
	 * Parallel tests run based on individual thread cretaion and don't over ride the another test driver as another test will have the another thread but 
	 * if we introduce the static concept into the picture then memory management will come into picture and drivers will get override and parallel execution will get fail everytime.
	 */
	
	/**
	 * To grab Excel data into our testcases we have to use Apache POI Api library and we have add all the related jars for that.
	 */

	
	
}
