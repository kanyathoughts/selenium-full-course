package testcases.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_14 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input#password")).sendKeys("learning");
		//select the user checkbox
		driver.findElement(By.xpath("//label[*=' User']/span[@class='checkmark']")).click();
		//wait Until modal body is visible.
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.modal-body")));
		System.out.println(driver.findElement(By.cssSelector("div.modal-body")).getText().trim());
		//click on OK button in popup
		driver.findElement(By.cssSelector("button#okayBtn")).click();
		//select the consultant option from the dropdown
		WebElement dropDwonElement = driver.findElement(By.cssSelector("select.form-control"));
		Select dropDownList = new Select(dropDwonElement);
		dropDownList.selectByValue("consult");
		System.out.println(dropDownList.getFirstSelectedOption().getText().trim());
		//Click on accept terms checkbox
		driver.findElement(By.xpath("//label[@for='terms']/descendant::input[@name='terms']")).click();
		//Click on signin button
		driver.findElement(By.cssSelector("input#signInBtn")).click();
		//wait Until to load new page
		wait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));
		//Click on all the Add buttons in side the page
		List<WebElement> listOfAllItems = driver.findElements(By.xpath("//app-card-list/app-card"));
		for (WebElement value: listOfAllItems) {
			value.findElement(By.xpath("/descendant::button[@class='btn btn-info']")).click();
		}
		
		//Click on checkout button
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
		//wait Until final checkout button visible
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@type='button' and @class='btn btn-success']")));
		driver.close();

	}

}
