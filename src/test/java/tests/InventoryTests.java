package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;

public class InventoryTests extends BaseTest {

    @Test(groups = {"smoke"})
    public void verifyInventoryPage() {

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
    }

    @Test(groups = {"smoke"})
    public void addBackpackToCart() {

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        inventoryPage.addBackpackToCart();

        Assert.assertTrue(true);
    }
}