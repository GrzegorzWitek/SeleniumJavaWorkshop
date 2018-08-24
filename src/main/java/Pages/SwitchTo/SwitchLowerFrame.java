package Pages.SwitchTo;

import Pages.QADemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchLowerFrame extends BasePage {

    private final By openInNewTabLinkLocator = By.cssSelector("td>a[target='_blank']");
    public SwitchLowerFrame(WebDriver driver) {
        super(driver);
    }

    public SwitchNewWindowPage clickOpenInNewTabLink(){
        clickOnElement(openInNewTabLinkLocator);
        switchFromMainToNextWindow();
        return new SwitchNewWindowPage(driver, this.mainHandler);
    }

}
