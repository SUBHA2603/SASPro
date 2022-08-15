package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SignInPage extends BaseClass {
	
	MyAccount myAcc;
	WebDriverWait wait;
	Action action = new Action();
	
	@FindBy (id="email")
	private WebElement username;
	
	@FindBy (id="passwd")
	private WebElement password;
	
	@FindBy (id="SubmitLogin")
	private WebElement submit;
	
	@FindBy (xpath="//div[contains(@class, 'alert-danger')]/ol/li")
	private WebElement failedAuth;
	
	public void enterCredential(String uname, String pwd) {
	   action.enterText(username, uname);
	   action.enterText(password, pwd);
	   
	}
	
	public MyAccount successOnSignIn() {
		action.click(submit, getDriver());
		wait.until(ExpectedConditions.titleContains("My account - My Store"));
		return new MyAccount();	
	}
	
	public String failedAuthOnSignIn() {
		action.click(submit, getDriver());
		wait.until(ExpectedConditions.visibilityOf(failedAuth));
		return failedAuth.getText();
	}
	
	public SignInPage() {
		PageFactory.initElements(getDriver(), this);
		wait = new WebDriverWait(getDriver(), 10);
	}

}
