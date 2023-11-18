package testcases.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdowns_Handling_7 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kdarisi\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(3000);
		
		//Static drop downs have the tag "Select".
		//Drop downs with select tag
		WebElement dropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select list = new Select(dropDown);
		list.selectByIndex(3);
		System.out.println(list.getFirstSelectedOption().getText().trim());
		list.selectByVisibleText("AED");
		System.out.println(list.getFirstSelectedOption().getText().trim());
		list.selectByValue("INR"); //This is the value of the value attribute inside the option tag.
		//(Ex: <option value="INR">INR</option>)
		System.out.println(list.getFirstSelectedOption().getText().trim());
		
		//Deselect will supported by multiple selection dropdowns
		
		driver.findElement(By.id("divpaxinfo")).click(); //click on "1 Adult" dropdown
		Thread.sleep(2000);
		int i = 1;
		while (i < 5)  //Click on + button Of adult addition 4 times.
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
			Thread.sleep(1000);
		}
		driver.findElement(By.id("btnclosepaxoption")).click(); //click on Done button.
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//Download "ChroPath" plugin in chrome for better experience.
		//Dynamic Dropdowns 
		//Why we call them dynamic dropdowns because the dropdown items will get change based upon the user action.
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		//Clicking on To dropdown
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //here we have given normal xpath inside the parenthesis to useful in dynamic dropdowns.
		//This is very effective xpath
		//Syntax: parent Xpath space child Xpath
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		//This one is not working need to ask some one.
		//driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']")).findElement(By.xpath("//a[@value='MAA']")).click();
		
		//Auto suggestive drop downs
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("Ind");
		Thread.sleep(2000);
		
		List<WebElement> listOfCountries = driver.findElements(By.cssSelector("li[class='ui-menu-item']")); //we are placing multiple find elements in the list and taking the elements.
		for (WebElement value : listOfCountries) {
			System.out.println(value.getText().trim());
		}
		for (WebElement value : listOfCountries) 
		{
			if (value.getText().equals("India")) 
			{
				value.click();
				break;
			}
		}
		
		//Check box count and click checkbox and verify checkbox selected
		//Clicking on checkbox
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		//Count of checkboxes in page
		System.out.println("size: " + driver.findElements(By.xpath("//div[@id='discount-checkbox'] //input[@type='checkbox']")).size());
		Assert.assertEquals(driver.findElements(By.xpath("//div[@id='discount-checkbox'] //input[@type='checkbox']")).size(), 5);
		
		
		//Calender (Date selection) (Basics)
		driver.findElement(By.xpath("//input[contains(@name,'mainContent$view_date1')]")).click();
		Thread.sleep(2000);
		//Clicking on current date.
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click(); //Here in class name if we have spaces then we have to replace the spaces with dot otherwise css.
		//Beacuse space has special feature in css i.e. separate parent and child with spaces.
		
		
		//Verify element is enabled (or) Disabled.
		boolean status = driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled(); 
		//This will not work sometimes in selenium. So we have to concentrate on attributes which are changing from enable to diable (or) from disable to enable
		
		System.out.println("status: " + status);
		
		
		Assert.assertEquals(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"), true);
		
		//click on round trip button then return date should be enabled by changing opacity value from 0.5 to 1
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"), true);
		

	}

}