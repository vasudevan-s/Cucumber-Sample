package com.saucelabs.mydemoapp.objectrepository;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pro.vasudevan.config.IDriverConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

/*
Created By: Vasudevan Sampath

 AppObjectRepository.java has object definitions
 */
public abstract class AppObjectRepository {
    @iOSXCUITFindBy(accessibility = "tab bar option menu")
    @AndroidFindBy(accessibility = "open menu")
    @CacheLookup
    protected WebElement bottomMenuItem;

    @iOSXCUITFindBy(accessibility = "menu item log in")
    @AndroidFindBy(accessibility = "menu item log in")
    @CacheLookup
    protected WebElement loginMenuItem;

    @iOSXCUITFindBy(accessibility = "Username input field")
    @AndroidFindBy(accessibility = "Username input field")
    protected WebElement userNameInputField;

    @iOSXCUITFindBy(accessibility = "Password input field")
    @AndroidFindBy(accessibility = "Password input field")
    protected WebElement passwordInputField;

    @iOSXCUITFindBy(accessibility = "Provided credentials do not match any user in this service.")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Provided credentials do not match any user in this service.\"]")
    @CacheLookup
    protected WebElement invalidLoginErrorMessage;

    @iOSXCUITFindBy(accessibility = "bob@example.com-autofill")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"bob@example.com\"]")
    protected WebElement loginIdAutoFill;

    @iOSXCUITFindBy(accessibility = "menu item log out")
    @AndroidFindBy(accessibility = "Logout button")
    @CacheLookup
    protected WebElement logoutMenuItem;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Log Out\" AND label == \"Log Out\" AND type == \"XCUIElementTypeButton\"")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout")
    @CacheLookup
    protected WebElement logoutAlertDialog;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"OK\"`]")
    @AndroidFindBy(id = "android:id/button1")
    @CacheLookup
    protected WebElement logoutAlertConfirmation;

    @iOSXCUITFindBy(accessibility = "Login button")
    @AndroidFindBy(accessibility = "Login button")
    @CacheLookup
    protected WebElement signIn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"store item\"]")
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"store item\"])")
    protected List<WebElement> productList;

    @iOSXCUITFindBy(accessibility = "Add To Cart button")
    @AndroidFindBy(accessibility = "Add To Cart button")
    @CacheLookup
    protected WebElement addToCart;

    @iOSXCUITFindBy(accessibility = "counter plus button")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView")
    protected WebElement plusButton;

    @iOSXCUITFindBy(accessibility = "counter minus button")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter minus button\"]/android.widget.ImageView")
    protected WebElement minusButton;

    @iOSXCUITFindBy(accessibility = "tab bar option cart")
    @AndroidFindBy(xpath = "//android.widget.TextView")
    protected List<WebElement> optionCart;

    @iOSXCUITFindBy(accessibility = "tab bar option catalog")
    @AndroidFindBy(accessibility = "Go Shopping button")
    @CacheLookup
    protected WebElement bottomCatalogItem;

    protected AppObjectRepository() {
        if (IDriverConfig.getDriver() instanceof AppiumDriver) {
            PageFactory.initElements(new AppiumFieldDecorator(IDriverConfig.getDriver()), this);
        }
    }
}
