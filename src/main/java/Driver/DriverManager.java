package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    public static WebDriver createChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.56.102:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static WebDriver createFirefoxDriver(){
        FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.56.102:4444/wd/hub"),options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
