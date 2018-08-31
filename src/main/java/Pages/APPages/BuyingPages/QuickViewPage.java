package Pages.APPages.BuyingPages;

import Pages.APPages.APBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuickViewPage extends APBasePage {

    private final By addToCartButtonLocator = By.cssSelector("#add_to_cart>button");

    public AddingToCartPage clickAddToCart(){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("[id*='fancybox-frame']")));
        clickOnElement(addToCartButtonLocator);
        windowsHelper.backToDefaultContent();
        return new AddingToCartPage();
    }
}
