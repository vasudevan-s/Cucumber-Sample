package com.saucelabs.mydemoapp.pages.mobile;

import com.saucelabs.mydemoapp.objectrepository.AppObjectRepository;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pro.vasudevan.config.IWebDriverConfig;
import pro.vasudevan.constants.Global;
import pro.vasudevan.helpers.IScrollHelper;
import pro.vasudevan.misc.Common;

import java.util.Random;
import java.util.function.Supplier;

/*
Created By: Vasudevan Sampath

 ProductsPage.java is a Selenium Page Object Model standard for Product screen specifics
 */
public class ProductsPage extends AppObjectRepository {

    // get product list count
    final Supplier<Integer> productListCount = () -> productList.size();

    public void navigateToProductsList() {
        bottomCatalogItem.click();
    }

    public void selectRandomProduct() {
        productList.get(new Random().nextInt(productListCount.get())).click();
        Common.waitForAnyExpectedCondition(ExpectedConditions.visibilityOf(addToCart), 120);
    }
    public boolean isSelectedProductDisplayed() {
        try {
            Thread.sleep(2000);
            IScrollHelper.swipe(Global.SwipeOptions.UP);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return addToCart.isDisplayed();
    }
    public int addToCart(int numberOfItems) {
        int count = 0;
        minusButton.click();
        for (int i = 1; i <= numberOfItems; i++) {
            plusButton.click();
            count++;
        }
        addToCart.click();
        return count;
    }
    public boolean isShoppingCartCountValid(int num) {
        try {
            Thread.sleep(2000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        int cartCount = IWebDriverConfig.getDriver() instanceof IOSDriver ?
                Integer.parseInt(optionCart.getFirst().getAttribute("label")) :
                Integer.parseInt(optionCart.getFirst().getAttribute("text"));

        return cartCount == num;
    }
}
