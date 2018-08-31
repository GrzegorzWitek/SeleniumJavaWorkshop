package Pages.APPages.BuyingPages;

import Pages.APPages.APBasePage;
import Pages.APPages.AuthenticationPages.SignInPage;
import org.openqa.selenium.By;

public class ShoppingCartSummaryPage extends APBasePage {

    private final By increaseButtonLocator = By.cssSelector("i.icon-plus");
    private final By proceedToCheckoutButtonLocator = By.cssSelector("p.cart_navigation > a[title='Proceed to checkout']");


    public ShoppingCartSummaryPage increaseQty() {
        clickOnElement(increaseButtonLocator);
        return this;
    }

    public SignInPage clickProceedToCheckout() {
        clickOnElement(proceedToCheckoutButtonLocator);
        return new SignInPage();
    }
}
