package com.mystore.utilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() throws IOException {

		htmlReporter= new ExtentSparkReporter("C:\\Users\\amita\\Desktop\\Sunny\\Workspace\\SASTest\\test-output\\ExtentReport\\MyReport.html");
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
