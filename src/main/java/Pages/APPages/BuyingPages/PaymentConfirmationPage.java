package Pages.APPages.BuyingPages;

import Pages.APPages.APBasePage;
import org.openqa.selenium.By;

public class PaymentConfirmationPage extends APBasePage {

    private final By confirmOrderButtonLocator = By.cssSelector("p#cart_navigation>button[type='submit']");

    public ConfirmationOrderPage clickConfirmMyOrder() {
        clickOnElement(confirmOrderButtonLocator);
        return new ConfirmationOrderPage();
    }
}
