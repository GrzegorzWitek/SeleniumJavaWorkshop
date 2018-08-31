package Switch;

import Driver.Driver;
import Pages.SwitchTo.SwitchMainPage;
import TestConfig.MasterTest;
import org.junit.Before;

public class SwitchToBaseTest extends MasterTest {
    protected SwitchMainPage mainPage;

    @Before
    public void initializeDriver(){
        mainPage = Driver.loadSwitchMainPage();
    }

}
