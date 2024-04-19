package com.saucelabs.mydemoapp.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/*
Created By: Vasudevan Sampath

 TestRunner.java is the main Test Runner for the suite (Specified in the TestNG xml file - Mobile.xml)
 */
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"com.saucelabs.mydemoapp.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true,
        publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {
    @DataProvider
    @Override
    public Object[][] scenarios () {
        return super.scenarios();
    }
}
