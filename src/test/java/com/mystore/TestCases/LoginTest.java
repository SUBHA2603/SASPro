package com.mystore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.MyAccount;
import com.mystore.pageobjects.SignInPage;
import com.mystore.utilities.Log;

public class LoginTest extends BaseClass {
	
	HomePage homePage;
	SignInPage signIn;
	MyAccount myAcc;
	
	@BeforeMethod
	public void intializeDriver() {
		launchApp();
	}
	
	@AfterMethod
	public void disposeDriver() {
		getDriver().quit();
	}
	
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void verifySignIn(String uname, String pwd, String credentialType) {
		
		Log.startTestCase("\"VerifySignIn\"");

		if (credentialType.equals("valid")) {
			homePage = new HomePage();

			signIn = homePage.clickOnSignIn();

			signIn.enterCredential(uname, pwd);
			myAcc = signIn.successOnSignIn();

			String actualTitle = myAcc.getTitle();
			String expectedTitle = "My account - My Store";

			Assert.assertTrue(expectedTitle.equals(actualTitle));
		}
		
		else if (credentialType.equals("invalid")) {
			
			homePage = new HomePage();

			signIn = homePage.clickOnSignIn();
			
			signIn.enterCredential(uname, pwd);
			String actualErrorMsg = signIn.failedAuthOnSignIn();
			
			String expectedErrorMsg = "Authentication failed.";

			Assert.assertTrue(expectedErrorMsg.contains(actualErrorMsg));
			
			Log.endTestCase("\"VerifySignIn\"");
			
		}
	}

}
