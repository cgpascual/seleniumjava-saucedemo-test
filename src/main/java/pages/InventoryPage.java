package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class InventoryPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartButton;

    public InventoryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getPageTitle(){

        return getText(pageTitle);
    }


    public void addBackpackToCart(){

        click(backpackAddButton);
    }

    public CartPage clickCart(){
        click(cartButton);
        WaitUtils.debugSleep(3);

        return new CartPage(driver);
    }
}