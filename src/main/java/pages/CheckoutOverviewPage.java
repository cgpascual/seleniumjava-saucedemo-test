package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "summary_info")
    private WebElement orderSummary;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isOrderSummaryDisplayed() {
        return orderSummary.isDisplayed();
    }

    public CheckoutCompletePage clickFinish() {
        click(finishButton);
//        WaitUtils.debugSleep(3);

        return new CheckoutCompletePage(driver);
    }
}