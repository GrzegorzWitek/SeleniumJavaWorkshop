package Driver;

import Pages.QADemo.MainPage;
import Pages.SwitchTo.SwitchMainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (null == driver) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void quit() {
        if(null != driver) {
            getDriver().quit();
        }
        driver = null;
    }

    public static void  openPage(String url) {
        getDriver().navigate().to(url);
    }
    public static MainPage loadPopMainPage() {
        getDriver().navigate().to("http://store.demoqa.com");
        return new MainPage();
    }

    public static String getTitle(){
        return getDriver().getTitle();
    }

    public static SwitchMainPage loadSwitchMainPage() {
        getDriver().navigate().to("http://www.maths.surrey.ac.uk/explore/nigelspages/frame2.htm");
        return new SwitchMainPage();
    }



}

