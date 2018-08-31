package QADemoTests;

import Driver.Driver;
import Pages.QADemo.MainPage;
import TestConfig.MasterTest;
import org.junit.Before;

public class POPBaseTest extends MasterTest {
    protected MainPage mainPage;

    @Before
    public void initializeDriver(){
        mainPage = Driver.loadPopMainPage();
    }

}
