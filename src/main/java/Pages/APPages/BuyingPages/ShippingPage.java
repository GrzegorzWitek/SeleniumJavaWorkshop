package Pages.APPages.BuyingPages;

import Pages.APPages.APBasePage;
import org.openqa.selenium.By;

public class ShippingPage extends APBasePage {

    private final By termsOfServiceCheckboxLocator = By.cssSelector("input#cgv");
    private final By proceedToCheckoutButtonLocator = By.cssSelector("button[name='processCarrier']");

    public ShippingPage checkTermsOfService() {
        clickOnElement(termsOfServiceCheckboxLocator);
        return this;
    }

    public PaymentPage clickProcessToCheckout() {
        clickOnElement(proceedToCheckoutButtonLocator);
        return new PaymentPage();
    }
}
