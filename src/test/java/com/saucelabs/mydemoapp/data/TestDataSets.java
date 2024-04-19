package com.saucelabs.mydemoapp.data;

import org.testng.annotations.DataProvider;

/*
Created By: Vasudevan Sampath
 TestDataSets.java has implementation methods using TestNG test data format.
 */
public class TestDataSets {

    @DataProvider(name="LoginDataProvider")
    public Object [][] getLoginData() {
        return new Object[][] {
                {"bob@example.com", "10203040"},
                {"alice@example.com", "10203040"}
        };
    }
}
