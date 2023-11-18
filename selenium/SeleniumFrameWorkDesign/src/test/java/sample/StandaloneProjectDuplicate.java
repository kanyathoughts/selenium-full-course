package sample;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import kanya.AbstractComponents.AbstractComponent;
import kanya.PageObjects.CheckOutPage;
import kanya.PageObjects.ProductCatelouge;
import kanya.TestComponents.BaseTest;

public class StandaloneProjectDuplicate extends BaseTest{

	/*@Test(dataProvider="getData", groups={"purchase"})
	//You have to catch the data into the method
	public void step01(String email, String password, String productName) throws InterruptedException, IOException {
		//Login
		lp.loginApplication(email, password);
		Thread.sleep(5000);
		ProductCatelouge pc = new ProductCatelouge(driver);
		System.out.println("productName: " + productName);
		pc.addProductToCart(productName);
		
		//Click on Cart button
		new AbstractComponent(driver).gotoCartPage();
		
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[contains(.,'" + productName + "')]//h3[text()='" + productName + "']")).isDisplayed(), true);
		
		//click on checkout button
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		Thread.sleep(2000);
		
		CheckOutPage cp = new CheckOutPage(driver);
		cp.selectCountry("India");
		
		Thread.sleep(3000);
		
		//click on place order
		
		driver.findElement(By.xpath("//a[contains(.,'Place Order')]")).click();
		Thread.sleep(3000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()=' Thankyou for the order. ']")).isDisplayed(), true);
		
		
		Thread.sleep(5000);
		
	}*/
	
	@Test
	public void step01() throws InterruptedException, IOException {
		//Login
		lp.loginApplication("kanya@gmail.com", "Kanya@9134");
		Thread.sleep(5000);
		ProductCatelouge pc = new ProductCatelouge(driver);
		System.out.println("productName: " + "zara coat 3");
		pc.addProductToCart("zara coat 3");
		
		//Click on Cart button
		new AbstractComponent(driver).gotoCartPage();
		
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[contains(.,'" + "zara coat 3" + "')]//h3[text()='" + "zara coat 3" + "']")).isDisplayed(), true);
		
		//click on checkout button
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		Thread.sleep(2000);
		
		CheckOutPage cp = new CheckOutPage(driver);
		cp.selectCountry("India");
		
		Thread.sleep(3000);
		
		//click on place order
		
		driver.findElement(By.xpath("//a[contains(.,'Place Order')]")).click();
		Thread.sleep(3000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()=' Thankyou for the order. ']")).isDisplayed(), true);
		Thread.sleep(5000);
		
	}
	
	//To verify zara coat 3 is displaying in orders page
	
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void step02() throws InterruptedException {
		lp.loginApplication("kanya@gmail.com", "Kanya@9134");
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("button[routerlink$='myorders']")).click();
		new AbstractComponent(driver).waitUntilElementToAppear(By.tagName("TABLE"), 5);
		Assert.assertEquals(driver.findElement(By.xpath("(//table//td[text()='zara coat 3'])[1]")).isDisplayed(), true);
	}
	
	//@Test(dataProvider="getDataByHashMap", groups={"purchase"})
	//You have to catch the data into the method
	public void step03(HashMap<String, String> map) throws InterruptedException, IOException {
		//Login
		lp.loginApplication(map.get("email"), map.get("password"));
		Thread.sleep(5000);
		ProductCatelouge pc = new ProductCatelouge(driver);
		System.out.println("productName: " + map.get("productName"));
		pc.addProductToCart(map.get("productName"));
		
		//Click on Cart button
		new AbstractComponent(driver).gotoCartPage();
		
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[contains(.,'" + map.get("productName") + "')]//h3[text()='" + map.get("productName") + "']")).isDisplayed(), true);
		
		//click on checkout button
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		Thread.sleep(2000);
		
		CheckOutPage cp = new CheckOutPage(driver);
		cp.selectCountry("India");
		
		Thread.sleep(3000);
		
		//click on place order
		
		driver.findElement(By.xpath("//a[contains(.,'Place Order')]")).click();
		Thread.sleep(3000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()=' Thankyou for the order. ']")).isDisplayed(), true);
		
		
		Thread.sleep(5000);
		
	}
	
	
	//@Test(dataProvider="getDataByJson")
	//You have to catch the data into the method
	public void step04(HashMap<String, String> map) throws InterruptedException, IOException {
		//Login
		lp.loginApplication(map.get("email"), map.get("password"));
		Thread.sleep(5000);
		ProductCatelouge pc = new ProductCatelouge(driver);
		System.out.println("productName: " + map.get("productName"));
		pc.addProductToCart(map.get("productName"));
		
		//Click on Cart button
		new AbstractComponent(driver).gotoCartPage();
		
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[contains(.,'" + map.get("productName") + "')]//h3[text()='" + map.get("productName") + "']")).isDisplayed(), true);
		
		//click on checkout button
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		Thread.sleep(2000);
		
		CheckOutPage cp = new CheckOutPage(driver);
		cp.selectCountry("India");
		
		Thread.sleep(3000);
		
		//click on place order
		
		driver.findElement(By.xpath("//a[contains(.,'Place Order')]")).click();
		Thread.sleep(3000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()=' Thankyou for the order. ']")).isDisplayed(), true);
		
		
		Thread.sleep(5000);
		
	}
	
	public String getScreenshotFilePath(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File(System.getProperty("user.dir") + "/ReunResults/" + testCaseName + ".png"));
		return System.getProperty("user.dir") + "/ReunResults/" + testCaseName + ".png";
	}
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
								{"kanya@gmail.com", "Kanya@9134", "zara coat 3"}, 
								{"satya@gmail.com", "Satya@9134", "adidas original"}
							};
	}
	
	@DataProvider
	public Object[][] getDataByHashMap() {
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "kanya@gmail.com");
		map1.put("password", "Kanya@9134");
		map1.put("productName", "iphone 13 pro");
		
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("email", "satya@gmail.com");
		map2.put("password", "Satya@9134");
		map2.put("productName", "adidas original");
		
		return new Object[][] {{map1}, {map2}};
	}
	
	@DataProvider
	public Object[][] getDataByJson() throws IOException {
		List<HashMap<String, String>> data = readDataFromJson(System.getProperty("user.dir") + "\\src\\test\\java\\kanya\\data\\DataReaderFromJson.java");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
}
