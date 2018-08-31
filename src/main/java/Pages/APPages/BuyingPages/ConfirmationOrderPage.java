package Pages.APPages.BuyingPages;

import Pages.APPages.APBasePage;
import org.openqa.selenium.By;

public class ConfirmationOrderPage extends APBasePage {

    private final By orderSummaryTitleLocator = By.cssSelector("div.box>p");

    public String getConfirmationMessage() {
        return getLabelText(orderSummaryTitleLocator);
    }
}
