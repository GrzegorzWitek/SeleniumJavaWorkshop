package Switch;

import Pages.SwitchTo.SwitchMainPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToBaseTest {
    private WebDriver driver;
    protected SwitchMainPage mainPage;

    @Before
    public void initializeDriver(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://www.maths.surrey.ac.uk/explore/nigelspages/frame2.htm");
        mainPage = new SwitchMainPage(driver);
    }

    @After
    public void quitDriver(){
        driver.quit();
    }
}
