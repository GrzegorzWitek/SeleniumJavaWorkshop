package APTests;

import Driver.Driver;
import Pages.APPages.APMainPage;
import TestConfig.MasterTest;
import org.junit.Before;

public class APBaseTest extends MasterTest {
    protected APMainPage mainPage;

    @Before
    public void initializeDriver(){
        Driver.getDriver(Driver.getBrowserName()).navigate().to("http://automationpractice.com");
        mainPage = new APMainPage();
    }

}
