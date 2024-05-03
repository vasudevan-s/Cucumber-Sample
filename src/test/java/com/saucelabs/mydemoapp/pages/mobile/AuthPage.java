package com.saucelabs.mydemoapp.pages.mobile;

import com.saucelabs.mydemoapp.objectrepository.AppObjectRepository;
import pro.vasudevan.constants.Global;
import pro.vasudevan.helpers.IScrollHelper;
import pro.vasudevan.misc.Common;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*
Created By: Vasudevan Sampath

 AuthPage.java is a Selenium Page Object Model standard for auth specifics
 */
public class AuthPage extends AppObjectRepository {

    public boolean isLoginPageVisible() {
        if (Common.waitForAnyExpectedCondition(ExpectedConditions.visibilityOf(userNameInputField)) != null) {
            IScrollHelper.swipe(Global.SwipeOptions.UP);
        }
        return loginIdAutoFill.isDisplayed();
    }
    public void navigateToLoginPage() {
        if (Common.waitForAnyExpectedCondition(ExpectedConditions.visibilityOf(bottomMenuItem), 120) != null) {
            bottomMenuItem.click();
            loginMenuItem.click();
        }
    }
    public void clickLoginAutoFill() {
        loginIdAutoFill.click();
    }
    public void signIn() {
        signIn.click();
    }

    public void enterUserName(String username) {
        userNameInputField.sendKeys(username + "\n");
    }
    public void enterPassword(String password) {
        passwordInputField.sendKeys(password + "\n");
    }

    public String getFailedLoginMessage() {
        return invalidLoginErrorMessage.getText();
    }

    public boolean isSignInSuccessful() {
        bottomMenuItem.click();
        Common.waitForAnyExpectedCondition(ExpectedConditions.visibilityOf(loginMenuItem)).click();
        return Common.waitForAnyExpectedCondition(ExpectedConditions.invisibilityOf(loginIdAutoFill));
    }
    public void signOut() {
        bottomMenuItem.click();
        logoutMenuItem.click();
        Common.waitForAnyExpectedCondition(ExpectedConditions.visibilityOf(logoutAlertDialog)).click();
        Common.waitForAnyExpectedCondition(ExpectedConditions.visibilityOf(logoutAlertConfirmation)).click();
    }
    public boolean isSignOutSuccessful() {
        return Common.waitForAnyExpectedCondition(ExpectedConditions.visibilityOf(loginIdAutoFill)).isDisplayed();
    }
}
