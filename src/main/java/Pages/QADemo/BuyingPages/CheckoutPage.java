package Pages.QADemo.BuyingPages;

import Pages.QADemo.ContentBasePage;
import org.openqa.selenium.By;

public class CheckoutPage extends ContentBasePage {

    private final By removeProductButton = By.cssSelector("input[value='Remove']");
    private final By checkoutContentBy = By.cssSelector("div.entry-content");
    private final By continueToCheckoutButton = By.cssSelector("a.step2");

    public CheckoutPage clickRemoveProduct(){
        clickOnElement(removeProductButton);
        return new CheckoutPage();
    }

    public CheckoutSummaryPage clickContinueButton(){
        clickOnElement(continueToCheckoutButton);
        return new CheckoutSummaryPage();
    }

    public String getCheckoutContent(){
        return getLabelText(checkoutContentBy);
    }
}
