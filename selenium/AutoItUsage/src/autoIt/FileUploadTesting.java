package autoIt;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class FileUploadTesting {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		
		//changing default downloads directory
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
		options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.ilovepdf.com/jpg_to_pdf");
		driver.findElement(By.xpath("//span[text()='Select JPG images']")).click();
		Thread.sleep(3000);
		/*WebElement acceptAll = driver.findElement(By.xpath("//span[text()='Accept All']"));
		if(acceptAll.isDisplayed()) {
			acceptAll.click();
		}*/
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\kdarisi\\Downloads\\FileUpload.exe");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Convert to PDF']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		String filePath = getLatestFilePath(System.getProperty("user.dir"), "");
		System.out.println(filePath.split("\\.")[1].trim());
		Assert.assertEquals("pdf", filePath.split("\\.")[1].trim());
		/**
		 * Automating window Controls with Selenium:



· Handling Window Authentication Pop Up
http://Username:Password@SiteURL

· Driver.get();

· Handling File Upload from Windows using AutoIT


What is AutoIT
Install AutoIT
AutoIT Scripting
Integrating AutoIT with Selenium



//Shift focus to the file upload windows

//set text/path into file name edit box

//click open to upload file



Au3info- record window component objects

Build Script -scite.exe

Save it- .au3 extenstion

Convert file into .exe by compiling .au3 file

Call .exe file with Runtime class in java into your selenium tests





ControlFocus("Open","","Edit1")

ControlSetText("Open","","Edit1","C:\Users\rahul\Documents\check\visit.pdf")

ControlClick("Open","","Button1")




		 */
		

	}
	
	public static String getLatestFilePath(String folderPath, String destDir) {
		File[] files = new File(folderPath).listFiles();
		System.out.println("files size: " + files.length);
		if(files.length == 0 || files == null) {
			return null;
		}
		File lastModifiedFile = files[0];
		System.out.println("latest file modified: " + lastModifiedFile.lastModified());
		for(int i = 1; i < files.length; i++) {
			//System.out.println(files[i].lastModified());
			if(lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		if (!destDir.equals("") && new File(destDir).isDirectory() && lastModifiedFile.isFile()) {
			try {
				Files.move(lastModifiedFile, new File(destDir));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(destDir + "\\" + lastModifiedFile.getName());
			return destDir + "\\" + lastModifiedFile.getName();
		}
		System.out.println(lastModifiedFile.getAbsolutePath());
		System.out.println(lastModifiedFile.getName());
		return lastModifiedFile.getAbsolutePath();
	}

}
