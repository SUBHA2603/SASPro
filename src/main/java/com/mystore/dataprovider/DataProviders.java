package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="credentials")
	public Object[][] getCredential() {
		Object[][] data = new Object [][] {
			{"dd@dd.com", "ff@2333", "invalid"},
			{"admin@xyz.com", "admin@123", "valid"}			
		};
		
		return data;
	}

}
