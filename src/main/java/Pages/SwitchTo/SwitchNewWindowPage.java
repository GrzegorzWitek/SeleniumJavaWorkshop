package Pages.SwitchTo;

import Pages.BasePage;

public class SwitchNewWindowPage extends BasePage {

    public SwitchNewWindowPage(String handler) {
        mainHandler=handler;
    }

    public SwitchMainPage returnToMainPage() {
        windowsHelper.closeWindow();
        switchToMain();
        return new SwitchMainPage();
    }
}
