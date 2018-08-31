package Pages.APPages.BuyingPages;

import Pages.APPages.APBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends APBasePage {

    private final By proceedToCheckoutButtonLocator = By.cssSelector("button[name='processAddress']");

    public ShippingPage clickProcessdToCheckout() {
        clickOnElement(proceedToCheckoutButtonLocator);
        return new ShippingPage();
    }
}
