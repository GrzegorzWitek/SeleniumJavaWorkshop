package Pages.SwitchTo;

import Pages.BasePage;
import org.openqa.selenium.By;

public class SwitchMiddleFrame extends BasePage {

    private final By submitButtonLocator = By.cssSelector("input[value='Submit']");
    private final By nameInputLocator = By.cssSelector("input[name='name']");
    private final By browserInputLocator = By.cssSelector("textarea[name='browser']");

    public SwitchMiddleFrame clickSubmitButton(){
        clickOnElement(submitButtonLocator);
        return this;
    }

    public SwitchMiddleFrame enterNameText(String name){
        provideInput(nameInputLocator,name);
        return this;
    }

    public boolean isBrowserInputActive(){
        return windowsHelper.getActiveElement().equals(findElement(browserInputLocator));
    }
}
