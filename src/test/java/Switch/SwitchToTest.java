package Switch;

import Pages.SwitchTo.SwitchMiddleFrame;
import Pages.SwitchTo.SwitchNewWindowPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;

public class SwitchToTest extends SwitchToBaseTest {

    @Test
    public void CheckTitleAfterSwitchingWindow(){
        String expectedOldPageTitle = "A Page with 3 Frames";
        String expectedNewPageTitle = "HTML Learning Package © Nigel Martin 2000";

        SwitchNewWindowPage switchNewWindowPage = mainPage.goToLowerFrame()
                .clickOpenInNewTabLink();
        String newPageTitle = switchNewWindowPage.getPageTitle();
        mainPage = switchNewWindowPage.returnToMainPage();
        String oldPageTitle = mainPage.getPageTitle();

        Assert.assertEquals("Wrong page title in new page", expectedNewPageTitle, newPageTitle);
        Assert.assertEquals("Wrong page title in old page", expectedOldPageTitle, oldPageTitle);
    }

    @Test
    public void CheckAndAcceptAlert(){
        SwitchMiddleFrame switchMiddleFrame = mainPage.goToMiddleFrame()
                .clickSubmitButton();
        String alertText = switchMiddleFrame.getAlertText();
        switchMiddleFrame.acceptAlert();

        Assert.assertEquals("Wrong alert message",
                "\nThe NAME field is blank.\n\nPlease enter your name.",alertText);
    }

    @Test
    public void CheckTabNavigation(){
        String name = "testName";
        boolean isBrowserInput = mainPage.goToMiddleFrame()
                .enterNameText(name + Keys.TAB)
                .isBrowserInputActive();

        Assert.assertTrue("Wrong element is active. Browser textarea should be active.",
                isBrowserInput);
    }
}
