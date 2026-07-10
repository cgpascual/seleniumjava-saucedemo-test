package pages;


import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;


public class CartPage extends BasePage {

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(className = "inventory_item_name")
    private WebElement productName;

    @FindBy(className = "cart_item")
    private java.util.List<WebElement> cartItems;

    @FindBy(className = "btn_secondary")
    private WebElement removeButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductName() {
        return getText(productName);
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public void removeProduct() {
        click(removeButton);
    }

    public CheckoutPage clickCheckout() {
        click(checkoutButton);
//        WaitUtils.debugSleep(3);
        return new CheckoutPage(driver);
    }
}