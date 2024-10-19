package com.saucelabs.mydemoapp.stepdefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.testng.Reporter;
import pro.vasudevan.automation.unifiedtestframework.config.IWebDriverConfig;

/*
Created By: Vasudevan Sampath

 CucumberTestBaseStepDefinition.java runs before and after all scenarios. The event is used
 to initialize the mobile driver. Cleanup is done after use. The TestNG test context
 is used to read the parameters from the xml file for driver initialization.
 */
public class CucumberTestBaseStepDefinition {
    @BeforeAll()
    public static void before_all() {
        IWebDriverConfig.initDriver(Reporter.getCurrentTestResult().getTestContext());
    }

    @AfterAll()
    public static void after_all() {
        IWebDriverConfig.tearDown();
    }
}
