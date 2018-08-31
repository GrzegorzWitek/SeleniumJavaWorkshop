package Pages.SwitchTo;

import Pages.BasePage;
import org.openqa.selenium.By;

public class SwitchLowerFrame extends BasePage {

    private final By openInNewTabLinkLocator = By.cssSelector("td>a[target='_blank']");

    public SwitchNewWindowPage clickOpenInNewTabLink(){
        clickOnElement(openInNewTabLinkLocator);
        switchFromMainToNextWindow();
        return new SwitchNewWindowPage(this.mainHandler);
    }

}
