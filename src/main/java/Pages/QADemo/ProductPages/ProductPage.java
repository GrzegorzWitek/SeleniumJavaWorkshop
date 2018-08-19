package Pages.QADemo.ProductPages;

import Pages.QADemo.ContentBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends ContentBasePage {

    private final By buyButtonBy = By.cssSelector("input.wpsc_buy_button");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addToCart(){
        clickOnElement(buyButtonBy);
        waitForAddToCartMessage();
        return this;
    }
}
