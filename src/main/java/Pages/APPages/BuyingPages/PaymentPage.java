package Pages.APPages.BuyingPages;

import Pages.APPages.APBasePage;
import org.openqa.selenium.By;

public class PaymentPage extends APBasePage {

    private final By payByBankWireButtonLocator = By.cssSelector("a.bankwire");

    public PaymentConfirmationPage selectPayByBankWire() {
        clickOnElement(payByBankWireButtonLocator);
        return new PaymentConfirmationPage();
    }
}
