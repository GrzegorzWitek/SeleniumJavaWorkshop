package Pages.QADemo.ProductPages;

import Pages.QADemo.ContentBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends ContentBasePage {

    public ProductPage openProduct(String productName) {
        clickOnElement(By.xpath("//a[text()='" + productName + "']"));
        return new ProductPage();
    }
}
