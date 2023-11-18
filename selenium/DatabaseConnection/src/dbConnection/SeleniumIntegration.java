package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumIntegration {
	public static void main(String[] args) throws SQLException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com/");
		String host = "localhost";
		String port = "3306";
		String databaseName = "QADBT";
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + databaseName, "root", "Kanya@9134");
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from credentials where name=\"kanya\"");
		rs.next();
		String userName = rs.getString("userName");
		String passWord = rs.getString("passWord");
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(passWord);
		Thread.sleep(3000);
	}

}
