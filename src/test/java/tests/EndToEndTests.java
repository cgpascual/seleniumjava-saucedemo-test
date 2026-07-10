package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

public class EndToEndTests extends BaseTest {

    @Test(groups = {"regression", "e2e"})
    public void completePurchaseFlow() {

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");

        inventoryPage.addBackpackToCart();

        CartPage cartPage = inventoryPage.clickCart();

        CheckoutPage checkoutPage = cartPage.clickCheckout();
        checkoutPage.enterCustomerInformation("Test", "User", "10001");

        CheckoutOverviewPage overviewPage = checkoutPage.clickContinue();

        CheckoutCompletePage completePage = overviewPage.clickFinish();
        Assert.assertTrue(completePage.isOrderCompleted());
    }
}