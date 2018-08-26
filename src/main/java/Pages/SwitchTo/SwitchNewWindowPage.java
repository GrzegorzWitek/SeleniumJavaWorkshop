package Pages.SwitchTo;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;

public class SwitchNewWindowPage extends BasePage {
    public SwitchNewWindowPage(WebDriver driver) {
        super(driver);
    }

    public SwitchNewWindowPage(WebDriver driver, String handler) {
        super(driver);
        mainHandler=handler;
    }

    public SwitchMainPage returnToMainPage() {
        driver.close();
        switchToMain();
        return new SwitchMainPage(driver);
    }
}
