package Pages.QADemo.PartsPages;

import Pages.QADemo.BasePage;
import Pages.QADemo.BuyingPages.CheckoutPage;
import Pages.QADemo.ProductPages.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    private final By goToCardButton = By.cssSelector("div#header_cart");
    private final By searchInput = By.cssSelector("input.search");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage clickCartButton(){
        clickOnElement(goToCardButton);
        return new CheckoutPage(driver);
    }

    public SearchResultPage searchProduct(String searchProductName){
        provideInput(searchInput, searchProductName + Keys.ENTER);
        return new SearchResultPage(driver);
    }
}
