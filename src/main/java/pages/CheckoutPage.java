package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterCustomerInformation(String firstName, String lastName, String postalCode) {
        type(firstNameField, firstName);
        type(lastNameField,lastName);
        type(postalCodeField,postalCode);
    }

    public CheckoutOverviewPage clickContinue() {
        click(continueButton);
//        WaitUtils.debugSleep(3);
        return new CheckoutOverviewPage(driver);
    }
}