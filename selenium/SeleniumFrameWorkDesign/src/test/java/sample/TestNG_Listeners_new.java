package sample;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNG_Listeners_new implements ITestListener {
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed and entered into 'onTestSuccess' listener block.");
		BufferedImage image;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File(System.getProperty("user.dir") + "\\RunResults\\" + result.getName() +".png"));
		} catch (HeadlessException | AWTException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {

		//We can even know at which testcase that entered into this failed block by printing result.
		System.out.println("Test failed and entered into 'onTestFailure' listener block. " + result.getName());
		
		BufferedImage image;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File(System.getProperty("user.dir") + "\\RunResults\\" + result.getName() +".png"));
		} catch (HeadlessException | AWTException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
