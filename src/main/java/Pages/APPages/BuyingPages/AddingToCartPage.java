package Pages.APPages.BuyingPages;

import Pages.APPages.APBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddingToCartPage extends APBasePage {

    private final By confirmationMessageLocator = By.cssSelector("div.layer_cart_product>h2");
    private final By proceedToCheckoutButtonLocator = By.cssSelector("a[title='Proceed to checkout']");

    public ShoppingCartSummaryPage clickProceedToCheckout() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.fancybox-overlay")));
        clickOnElement(proceedToCheckoutButtonLocator);
        return new ShoppingCartSummaryPage();
    }

    public String getConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessageLocator));
        return getLabelText(confirmationMessageLocator);
    }
}
