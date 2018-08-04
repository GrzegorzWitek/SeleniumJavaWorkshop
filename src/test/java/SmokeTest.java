import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeTest {
    @Test
    public void openPageTest(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://automationpractice.com");
        Assert.assertEquals("Wrong page title",
                "My Store", driver.getTitle());
        driver.quit();
    }

    @Test
    public void openLoginPageTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://automationpractice.com");
        driver.findElement(By.cssSelector("button.button-search"))
                .click();

        Assert.assertEquals("Wrong page title",
                "Search - My Store", driver.getTitle());
        driver.quit();
    }
}
