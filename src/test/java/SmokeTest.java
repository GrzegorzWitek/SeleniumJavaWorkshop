import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmokeTest {

    WebDriver driver;
    String emailAddress = "jurijgagarin@gmail.com";
    String gmailURL = "https://www.gmail.com";

    @Before
    public void SetUpDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void QuitDriver(){
        driver.quit();
    }

    @Test
    public void openPageTest(){
        driver.navigate().to("http://automationpractice.com");
        Assert.assertEquals("Wrong page title",
                "My Store", driver.getTitle());
    }

    @Test
    public void openLoginPageTest(){
        driver.navigate().to("http://automationpractice.com");
        driver.findElement(By.cssSelector("button.button-search"))
                .click();

        Assert.assertEquals("Wrong page title",
                "Search - My Store", driver.getTitle());
    }

    @Test
    public void NoWait(){
        driver.navigate().to(gmailURL);
        WebElement emailField = driver.findElement(By.cssSelector("#identifierId"));
        emailField.clear();
        emailField.sendKeys(emailAddress);
        WebElement nextButton = driver.findElement(By.cssSelector("#identifierNext"));
        nextButton.click();
        WebElement profileIdentifier = driver.findElement(By.cssSelector("#profileIdentifier"));
    }

    @Test
    public void ImplicitWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(gmailURL);
        WebElement emailField = driver.findElement(By.cssSelector("#identifierId"));
        emailField.clear();
        emailField.sendKeys(emailAddress);
        WebElement nextButton = driver.findElement(By.cssSelector("#identifierNext"));
        nextButton.click();
        WebElement profileIdentifier = driver.findElement(By.cssSelector("#profileIdentifier"));
    }

    @Test
    public void ImplicitWaitNotPassing(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(gmailURL);
        WebElement emailField = driver.findElement(By.cssSelector("#identifierId"));
        emailField.clear();
        emailField.sendKeys(emailAddress);
        WebElement nextButton = driver.findElement(By.cssSelector("#identifierNext"));
        nextButton.click();
        WebElement profileIdentifier = driver.findElement(By.cssSelector("#profileIdentifier"));
        String emailActual = profileIdentifier.getText();
        Assert.assertEquals("Email address is different than expected. Expected email: " + emailAddress +
                ". Actual email: " + emailActual , emailAddress, profileIdentifier.getText());
    }

    @Test
    public void ExplicitWaitNoAssertion(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.navigate().to(gmailURL);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identifierId")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#profileIdentifier")));
        WebElement emailField = driver.findElement(By.cssSelector("#identifierId"));
        emailField.clear();
        emailField.sendKeys(emailAddress);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identifierNext")));
        WebElement nextButton = driver.findElement(By.cssSelector("#identifierNext"));
        nextButton.click();
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#profileIdentifier"), emailAddress));
    }

    @Test
    public void ExplicitWait(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.navigate().to(gmailURL);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identifierId")));
        WebElement emailField = driver.findElement(By.cssSelector("#identifierId"));
        emailField.clear();
        emailField.sendKeys(emailAddress);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identifierNext")));
        WebElement nextButton = driver.findElement(By.cssSelector("#identifierNext"));
        nextButton.click();
        try {
            wait.until(ExpectedConditions.textToBe(By.cssSelector("#profileIdentifier"), emailAddress));
        } catch (TimeoutException e){
            throw new AssertionFailedError("The email address displayed was different than expected. " + e.getMessage());
        }
    }

    @Test
    public void ExplicitWaitFailingAssertion(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.navigate().to(gmailURL);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identifierId")));
        WebElement emailField = driver.findElement(By.cssSelector("#identifierId"));
        emailField.clear();
        emailField.sendKeys(emailAddress);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identifierNext")));
        WebElement nextButton = driver.findElement(By.cssSelector("#identifierNext"));
        nextButton.click();
        By profileIdentifier = By.cssSelector("#profileIdentifier");

        try {
            wait.until(ExpectedConditions.textToBe(profileIdentifier, emailAddress));
        } catch (TimeoutException e){
            throw new AssertionFailedError("The email address displayed was different than expected. " + e.getMessage());
        }
        String actualEmailAddress = driver.findElement(profileIdentifier).getText();

        Assert.assertEquals("Email address is different than expected. " +
                        "Expected: " + emailAddress + ". Actual : " + actualEmailAddress,
                "jakistammail@gmail.com", actualEmailAddress);
    }

    @Test
    public void listTest(){
        int noOfElements = 7;
        String productName = "dress";

        driver.navigate().to("http://automationpractice.com");
        List<WebElement> webElementList = driver.findElements(By.cssSelector("ul#homefeatured div.product-container a.product-name"));
        boolean exist = false;
        for (WebElement element:webElementList) {
            if(element.getText().toLowerCase().contains(productName)){
                exist = true;
                break;
            }
        }

        Assert.assertTrue("Wrong number of elements on page", webElementList.size() == noOfElements);
        Assert.assertTrue("Proper product doesn't exist", exist);
    }

    @Test
    public void listTestWithFind(){
        int noOfElements = 7;
        String productName = "dress";

        driver.navigate().to("http://automationpractice.com");
        List<WebElement> webElementList = driver.findElements(By.cssSelector("ul#homefeatured div.product-container"));
        boolean exist = false;
        for (WebElement element:webElementList) {
            if(element.findElement(By.cssSelector("a.product-name")).getText().toLowerCase().contains(productName)){
                exist = true;
                break;
            }
        }

        Assert.assertTrue("Wrong number of elements on page", webElementList.size() == noOfElements);
        Assert.assertTrue("Proper product doesn't exist", exist);
    }
}
