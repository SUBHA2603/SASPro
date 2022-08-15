package com.mystore.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.base.BaseClass;

public class Action extends BaseClass {

	public void click (WebElement ele, WebDriver driver)
	{
		try {
			Actions action = new Actions(driver);
			action.moveToElement(ele).click().build().perform();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void enterText (WebElement ele, String text)
	{ 
		try {
			if(ele.isDisplayed())
			{
				ele.clear();
				ele.sendKeys(text);
			}

		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		//String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				//+ dateName + ".png";
		return destination;
	}

}
