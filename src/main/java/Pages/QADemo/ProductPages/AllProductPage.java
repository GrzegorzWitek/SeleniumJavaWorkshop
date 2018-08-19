package Pages.QADemo.ProductPages;

import Pages.QADemo.ContentBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AllProductPage extends ContentBasePage {

    private final By productListBy = By.cssSelector("a.wpsc_product_title");
    private final By productBuyButtonBy = By.cssSelector("input.wpsc_buy_button");

    public AllProductPage(WebDriver driver) {
        super(driver);
    }

    public AllProductPage addToCart(String productName){
        List<WebElement> productList = findElements(productListBy);
        for (int i=0; i<productList.size(); i++) {
            if(productList.get(i).getText().equals(productName)){
                WebElement buyButton = findElements(productBuyButtonBy).get(i);
                buyButton.click();
                waitForAddToCartMessage();
                return this;
            }
        }
        throw new UnsupportedOperationException("Not existing product: " + productName);
    }
}
