package com.mystore.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mystore.actiondriver.Action;

public class ExtentManager {
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	Action action = new Action();
	
	public static void setExtent() throws IOException {
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		htmlReporter= new ExtentSparkReporter("C:\\Users\\amita\\Desktop\\Sunny\\Workspace\\SASTest\\test-output\\ExtentReport\\MyReport" +"_"+ dateName+".html");
		htmlReporter.loadXMLConfig("C:\\Users\\amita\\Desktop\\Sunny\\Workspace\\SASTest\\extent-config.xml");

		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "MySASProject");
		extent.setSystemInfo("Tester", "Sunny");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}
	public static void endReport() {
		extent.flush();
	}
}
