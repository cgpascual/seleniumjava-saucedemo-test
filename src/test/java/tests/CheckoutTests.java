package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

public class CheckoutTests extends BaseTest {

    @Test(groups = {"regression"})
    public void completeCheckout() {

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        inventoryPage.addBackpackToCart();

        CartPage cartPage = inventoryPage.clickCart();

        CheckoutPage checkoutPage = cartPage.clickCheckout();
        checkoutPage.enterCustomerInformation("John", "Automation", "12345");

        CheckoutOverviewPage overviewPage = checkoutPage.clickContinue();
        Assert.assertTrue(overviewPage.isOrderSummaryDisplayed());

        CheckoutCompletePage completePage = overviewPage.clickFinish();
        Assert.assertEquals(completePage.getConfirmationMessage(), "Thank you for your order!");
    }
}