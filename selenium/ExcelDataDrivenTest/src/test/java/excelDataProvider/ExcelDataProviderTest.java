package excelDataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProviderTest {
	
	//Final motto is we can only return map separately but in the form of arrays we can not return single dimensional arrays, we have to return all the values from single dimensional array.
	
	@Test(dataProvider="getData")
	public void excelDataProvider(String greeting, String message, int id) {
		System.out.println(greeting);
		System.out.println(message);
		System.out.println(id);
	}
	
	@Test(dataProvider="getData2")
	public void excelDataProvider2(HashMap<Object, Object> map) {
		System.out.println("entered");
		System.out.println(map);
	}
	
	@Test(dataProvider="getData3")
	public void excelDataProvider3(Object[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
	
	@Test(dataProvider="getData4")
	public void excelDataProvider4(List<String> data) {
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}
	}
	
	@Test(dataProvider="getDataFromExcel")
	public void dataFromExcel(String greeting, String message, String id) throws IOException {
		/*Object[][] data = getDataFromExcel();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(data[i][j]);
			}
			System.out.println("-----------------------------");
		}*/
		
		System.out.println(greeting);
		System.out.println(message);
		System.out.println(id);
	}
	
	//from normal data
	@DataProvider
	public Object[][] getData() {
		Object[][] data = {
							{"hello", "text", 1}, 
							{"bye", "message", 143}, 
							{"solo", "call", 453}
						};
		return data;
	}
	
	//from hash map
	@DataProvider
	public Object[][] getData2() {
		HashMap<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("greeting", "hello");
		map1.put("message", "text");
		map1.put("id", 1);
		
		HashMap<Object, Object> map2 = new HashMap<Object, Object>();
		map2.put("greeting", "bye");
		map2.put("message", "message");
		map2.put("id", 143);
		
		HashMap<Object, Object> map3 = new HashMap<Object, Object>();
		map3.put("greeting", "solo");
		map3.put("message", "call");
		map3.put("id", 453);
		
		return new Object[][] {
									{map1},
									{map2}, 
									{map3}
								};
	}
	
	//from one dimensional array
	@DataProvider
	public Object[][] getData3() {
		Object[] data1 = {"hello", "text", 1};
		Object[] data2 = {"bye", "message", 143};
		Object[] data3 = {"solo", "call", 453};
		Object[][] finalData = {
							{data1}, 
							{data2}, 
							{data3}
						};
		return finalData;
	}
	
	//from list
	@DataProvider
	public Object[][] getData4() {
		List<String> List1 = Arrays.asList("hello", "text", "1");
		List<String> List2 = Arrays.asList("bye", "message", "143");
		List<String> List3 = Arrays.asList("solo", "call", "453");
		Object[][] finalListData = {
				{List1}, 
				{List2}, 
				{List3}
			};
		return finalListData;
	}

	//from Excel
	@DataProvider
	public Object[][] getDataFromExcel() throws IOException {
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\kdarisi\\Downloads\\TempData2.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getPhysicalNumberOfRows();
		Row firstRow = sheet.getRow(0);
		int colCount = firstRow.getLastCellNum();
		Object[][] excelData = new Object[rowCount-1][colCount];
		for (int i = 0 ; i < rowCount-1; i++) {
			Row row = sheet.getRow(i+1);
			for (int j = 0;  j < row.getLastCellNum(); j++) {
				excelData[i][j] = row.getCell(j).getStringCellValue();
			}
		}
		wb.close();
		return excelData;
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("------------------------------------------");
	}
}
