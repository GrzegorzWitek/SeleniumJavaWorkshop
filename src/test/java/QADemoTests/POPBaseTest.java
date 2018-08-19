package QADemoTests;

import Pages.QADemo.MainPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class POPBaseTest {
    private WebDriver driver;
    protected MainPage mainPage;

    @Before
    public void initializeDriver(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://store.demoqa.com");
        mainPage = new MainPage(driver);
    }

    @After
    public void quitDriver(){
        driver.quit();
    }
}
