package com.mystore.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class MyAccount extends BaseClass {
	
	public String getTitle() {
		return getDriver().getTitle();
	}
	
	public MyAccount() {
		PageFactory.initElements(getDriver(), this);
	}

}
