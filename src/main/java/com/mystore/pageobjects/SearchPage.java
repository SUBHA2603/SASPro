package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SearchPage extends BaseClass {
	
	@FindBy (xpath="//p[@class='alert alert-warning']")
	private WebElement errorMsg;
	
	@FindBy (xpath="//a[@title='Blouse']")
	private WebElement product;
	
	public String actualTitle() {
		return errorMsg.getText();
	}
	
	public boolean productSearch() {
		boolean productPresent = false;
		if (product.isDisplayed())
			productPresent = true;
		
		return productPresent;
	}
	
	public SearchPage() {
		PageFactory.initElements(getDriver(), this);
	}


}
