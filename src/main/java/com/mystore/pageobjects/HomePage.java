package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class HomePage extends BaseClass {
	
	SearchPage searchPage;
	SignInPage signInPage;
	WebDriverWait wait;
	
	Action action = new Action();

	
	@FindBy (name="search_query")
	private WebElement searchBox;
	
	@FindBy (xpath="//button[@name='submit_search']")
	private WebElement submitSearch;
	
	@FindBy (xpath = "//a[@title='Log in to your customer account']")
	private WebElement signIn;
	
	public void enterText(String product) {
		action.enterText(searchBox, product);		
	}
	
	public SearchPage searchProd() {
		action.click(submitSearch, getDriver());		
		wait.until(ExpectedConditions.titleContains("Search - My Store"));
		return new SearchPage();
	}
	
	public SignInPage clickOnSignIn() {
		action.click(signIn, getDriver());		
		wait.until(ExpectedConditions.titleContains("Login - My Store"));
		return new SignInPage();
	}
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
		wait = new WebDriverWait(getDriver(), 10);
	}	

}
