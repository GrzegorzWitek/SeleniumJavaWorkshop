package Pages.QADemo;

import Pages.BasePage;
import Pages.QADemo.PartsPages.HeaderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContentBasePage extends BasePage {

    private By addedToCardMessage = By.cssSelector("div.alert.addtocart");

    public HeaderPage header;

    public ContentBasePage() {
        header = new HeaderPage();
    }

    protected void waitForAddToCartMessage(){
        wait.until(ExpectedConditions.visibilityOf(findElement(addedToCardMessage)));
    }
}
