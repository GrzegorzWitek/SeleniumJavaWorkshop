package Pages.QADemo;
import Pages.QADemo.ProductPages.AllProductPage;
import Pages.QADemo.ProductPages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends ContentBasePage {

    private final By allProductsButton = By.xpath("//li[contains(@class,'menu-item')]//a[text()='All Product']");
    private final By iphone5CarouselItem = By.cssSelector("ul#slide_menu>a:nth-of-type(2)");
    private final By iphone5CarouselBuy = By.cssSelector("a[title='Buy Now']>img[alt='iPhone 5']");

    public AllProductPage clickAllProductMenu(){
        clickOnElement(allProductsButton);
        return new AllProductPage();
    }

    public MainPage clickIphoneCarouselItem(){
        clickOnElement(iphone5CarouselItem);
        return this;
    }

    public ProductPage clickIphoneCarouselBuy(){
        wait.until(ExpectedConditions.elementToBeClickable(findElement(iphone5CarouselBuy)));
        clickOnElement(iphone5CarouselBuy);
        return new ProductPage();
    }
}
