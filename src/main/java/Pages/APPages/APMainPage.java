package Pages.APPages;

import Pages.APPages.BuyingPages.QuickViewPage;
import org.openqa.selenium.By;

public class APMainPage extends APBasePage {

    private final By firstProductBoxLocator = By.cssSelector("ul#homefeatured>li:nth-of-type(1)>div");
    private final By quickViewButtonLocator = By.cssSelector("a.quick-view");

    public QuickViewPage clickQuickViewOverProduct() {
        actions.moveToElement(findElement(firstProductBoxLocator)).build().perform();
        findElement(firstProductBoxLocator).findElement(quickViewButtonLocator).click();

        return new QuickViewPage();
    }

}
