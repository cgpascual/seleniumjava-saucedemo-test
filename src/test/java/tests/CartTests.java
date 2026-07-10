package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;


public class CartTests extends BaseTest {

    @Test(groups = {"regression"})
    public void verifyAddProductToCart() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        inventoryPage.addBackpackToCart();

        CartPage cartPage = inventoryPage.clickCart();
        Assert.assertEquals(cartPage.getCartItemCount(), 1);
    }

    @Test(groups = {"regression"})
    public void verifyRemoveProductFromCart() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        inventoryPage.addBackpackToCart();
        CartPage cartPage = inventoryPage.clickCart();
        cartPage.removeProduct();

        Assert.assertEquals(cartPage.getCartItemCount(), 0);
    }
}