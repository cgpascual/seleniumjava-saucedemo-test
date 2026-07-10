package tests;


import base.BaseTest;
import dataproviders.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;


public class LoginTests extends BaseTest {

    @Test(groups = {"smoke"}, dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void validLoginTest(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login(username, password);
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
    }
}