package Pages.QADemo.BuyingPages;

import Pages.QADemo.ContentBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends ContentBasePage {

    private final By removeProductButton = By.cssSelector("input[value='Remove']");
    private final By checkoutContentBy = By.cssSelector("div.entry-content");
    private final By continueToCheckoutButton = By.cssSelector("a.step2");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage clickRemoveProduct(){
        clickOnElement(removeProductButton);
        return new CheckoutPage(driver);
    }

    public CheckoutSummaryPage clickContinueButton(){
        clickOnElement(continueToCheckoutButton);
        return new CheckoutSummaryPage(driver);
    }

    public String getCheckoutContent(){
        return getLabelText(checkoutContentBy);
    }
}
