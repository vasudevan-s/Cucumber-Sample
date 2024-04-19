package com.saucelabs.mydemoapp.stepdefinitions;

import com.saucelabs.mydemoapp.pages.mobile.AuthPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/*
Created By: Vasudevan Sampath

 SignInStepDefinition.java is a Cucumber step definition file for feature implementation.
 @Before is used for POM class initialization
 */
public class SignInStepDefinition {
    private AuthPage authPage;

    @Before()
    public void init() {
        authPage = new AuthPage();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        authPage.navigateToLoginPage();
        Assert.assertTrue(authPage.isLoginPageVisible(), "Login screen is not active");
    }

    @Given("I input a invalid {} and {}")
    public void iInputAInvalidAndor(String username, String password) {
        authPage.enterUserName(username);
        authPage.enterPassword(password);
    }

    @Then("I should get an error message indicating {}")
    public void iShouldGetAnErrorMessageIndicating(String message) {
        Assert.assertEquals(authPage.getFailedLoginMessage(), message, "Not valid");
    }

    @Given("I have selected an available username and password from the login screen")
    public void iHaveSelectedAnAvailableUsernameAndPasswordFromTheLoginScreen() {
        authPage.clickLoginAutoFill();
    }

    @When("I click on the Login button")
    public void iClickOnTheLoginButton() {
        authPage.signIn();
    }

    @And("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() throws Exception {
        Assert.assertTrue(authPage.isSignInSuccessful(), "Login failed");
    }
}