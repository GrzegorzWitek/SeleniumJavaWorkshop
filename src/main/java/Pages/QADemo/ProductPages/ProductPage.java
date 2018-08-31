package Pages.QADemo.ProductPages;

import Pages.QADemo.ContentBasePage;
import org.openqa.selenium.By;

public class ProductPage extends ContentBasePage {

    private final By buyButtonBy = By.cssSelector("input.wpsc_buy_button");

    public ProductPage addToCart(){
        clickOnElement(buyButtonBy);
        waitForAddToCartMessage();
        return this;
    }
}
