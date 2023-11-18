package test;

import java.util.Arrays;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnnotation {
	
	//The advantage of this data provider is it will run testcase 3 times based on length of the getData data provider.
	@Test(dataProvider="getData")
	public void step01(String un, String pw) {
		System.out.println("un: " + un);
		System.out.println("pw: "+ pw);
		System.out.println("----------------------------");
		
	}
	
	@DataProvider
	public Object[][] getData() {
		/*
		 * 1st combination - first username and password
		 * 2nd combination - second username and password
		 * 3rd combination - third username and password
		 */
		Object[][] data = new Object[3][2];
		
		System.out.println("length: " + data.length);
		String[][] values = {{"firstusername", "firstPW"}, {"secondusername", "secondPW"}, {"thirdusername", "thirdPW"}};
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < 2; j++) {
				data[i][j] = values[i][j];
			}
		}
		System.out.println("------------------------------------");
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.println("value " + i + ", " + j + " : " + data[i][j]);
			}
		}
		
		return data;
		
	}

}
