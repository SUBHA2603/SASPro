package com.mystore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.SearchPage;
import com.mystore.utilities.Log;

public class SearchResultTest extends BaseClass {
	HomePage home;
	SearchPage search;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void intializeDriver(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void disposeDriver() {
		getDriver().quit();
	}
	
	@Test(groups= {"Sanity"})
	public void noProductTest() {
		Log.startTestCase("\"noProductTest\"");
		
		home = new HomePage();
		home.enterText("kurta");
		search = home.searchProd();
		String actualMsg = search.actualTitle();
		String expMsg = "No results were found for your search \"kurta\"";
		Assert.assertEquals(actualMsg, expMsg);		
		
		Log.endTestCase("\"noProductTest\"");
		
	}
	
	@Test(groups= {"Smoke", "Sanity"})
	public void validProductTest() {
		Log.startTestCase("\"validProdcutTest\"");
		
		home = new HomePage();
		home.enterText("Blouse");
		search = home.searchProd();
		Boolean isProductPresent = search.productSearch();
		Assert.assertTrue(isProductPresent);
		
		Log.endTestCase("\"validProdcutTest\"");
	}
	

}
