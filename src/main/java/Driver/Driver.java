package Driver;

import Pages.QADemo.MainPage;
import Pages.SwitchTo.SwitchMainPage;
import org.openqa.selenium.WebDriver;

import static Driver.DriverManager.createChromeDriver;
import static Driver.DriverManager.createFirefoxDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (null == driver) {
            driver = createChromeDriver();
        }
        return driver;
    }

    public static WebDriver getDriver(EBrowser browser) {
        switch (browser){
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
            case CHROME:
            default:
                driver = createChromeDriver();
                break;
        }
        return driver;
    }

    public static EBrowser getBrowserName(){
        switch(System.getProperty("browserName").toLowerCase()){
            case "firefox":
                return EBrowser.FIREFOX;
            case "chrome":
            default:
                return EBrowser.CHROME;
        }
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