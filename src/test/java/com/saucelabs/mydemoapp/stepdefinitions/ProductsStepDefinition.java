package com.saucelabs.mydemoapp.stepdefinitions;

import com.saucelabs.mydemoapp.pages.mobile.ProductsPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/*
Created By: Vasudevan Sampath

 ProductsStepDefinition.java is a Cucumber step definition file for feature implementation.
 @Before is used for POM class initialization
 */
public class ProductsStepDefinition {
    private ProductsPage productsPage;
    private int itemsCount = 0;

    @Before()
    public void init() {
        productsPage = new ProductsPage();
    }

    @Given("I am on the list of products page")
    public void iAmOnTheListOfProductsPage() {
        productsPage.navigateToProductsList();
    }

    @When("I randomly select an available product from the list")
    public void iRandomlySelectAnAvailableProductFromTheList() {
        productsPage.selectRandomProduct();
    }

    @Then("I should be navigated to the selected product page")
    public void iShouldBeNavigatedToTheSelectedProductPage() {
        Assert.assertTrue(productsPage.isSelectedProductDisplayed(), "Not on the selected product page");
    }

    @And("I add {} of the product selected to the shopping cart")
    public void iAddOfTheProductSelectedToTheShoppingCart(int numberOfItems) {
        itemsCount = productsPage.addToCart(numberOfItems);
    }

    @Then("The shopping cart should display the correct count of the product added")
    public void theShoppingCartShouldDisplayTheCorrectCountOfTheProductAdded() {
        Assert.assertTrue(productsPage.isShoppingCartCountValid(itemsCount), "Expected value is not matching the actual value");
    }
}
