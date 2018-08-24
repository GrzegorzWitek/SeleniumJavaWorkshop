package Pages.SwitchTo;

import Pages.QADemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchMiddleFrame extends BasePage {

    private final By submitButtonLocator = By.cssSelector("input[value='Submit']");
    private final By nameInputLocator = By.cssSelector("input[name='name']");
    private final By browserInputLocator = By.cssSelector("textarea[name='browser']");

    public SwitchMiddleFrame(WebDriver driver) {
        super(driver);
    }

    public SwitchMiddleFrame clickSubmitButton(){
        clickOnElement(submitButtonLocator);
        return this;
    }

    public SwitchMiddleFrame enterNameText(String name){
        provideInput(nameInputLocator,name);
        return this;
    }

    public boolean isBrowserInputActive(){
        return driver.switchTo().activeElement().equals(driver.findElement(browserInputLocator));
    }
}