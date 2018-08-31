import Driver.Driver;
import TestConfig.MasterTest;
import junit.framework.AssertionFailedError;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmokeTest extends MasterTest {

    String emailAddress = "jurijgagarin@gmail.com";
    String gmailURL = "https://www.gmail.com";

    @Test
    public void openPageTest(){
        Driver.openPage("http://automationpractice.com");
        Assert.assertEquals("Wrong page title",
                "My Store", Driver.getTitle());
    }

    @Test
    public void openLoginPageTest(){
        Driver.openPage("http://automationpractice.com");
        Driver.getDriver().findElement(By.cssSelector("button.button-search"))
                .click();

        Assert.assertEquals("Wrong page title",
                "Search - My Store", Driver.getTitle());
    }

    @Test
    public void NoWait(){
        Driver.openPage(gmailURL);
        WebElement emailField = Driver.getDriver().findElement(By.cssSelector("#identifierId"));
        emailField.clear();
        emailField.sendKeys(emailAddress);
        WebElement nextButton = Driver.getDriver().findElement(By.cssSelector("#identifierNext"));
        nextButton.click();
        WebElement profileIdentifier = Driver.getDriver().findElement(By.cssSelector("#profileIdentifier"));
    }

    @Test
    public void ImplicitWait(){
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.openPage(gmailURL);
        WebElement emailField = Driver.getDriver().findElement(By.cssSelector("#identifierId"));
        emailField.clear();
        emailField.sendKeys(emailAddress);
        WebElement nextButton = Driver.getDriver().findElement(By.cssSelector("#identifierNext"));
        nextButton.click();
        WebElement profileIdentifier = Driver.getDriver().findElement(By.cssSelector("#profileIdentifier"));
    }

    @Test
    public void ImplicitWaitNotPassing(){
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.openPage(gmailURL);
        WebElement emailField = Driver.getDriver().findElement(By.cssSelector("#identifierId"));
        emailField.clear();
        emailField.sendKeys(emailAddress);
        WebElement nextButton = Driver.getDriver().findElement(By.cssSelector("#identifierNext"));
        nextButton.click();
        WebElement profileIdentifier = Driver.getDriver().findElement(By.cssSelector("#profileIdentifier"));
        String emailActual = profileIdentifier.getText();
        Assert.assertEquals("Email address is different than expected. Expected email: " + emailAddress +
                ". Actual email: " + emailActual , emailAddress, profileIdentifier.getText());
    }

    @Test
    public void ExplicitWaitNoAssertion(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        Driver.openPage(gmailURL);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identifierId")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#profileIdentifier")));
        WebElement emailField = Driver.getDriver().findElement(By.cssSelector("#identifierId"));
        emailField.clear();
        emailField.sendKeys(emailAddress);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identifierNext")));
        WebElement nextButton = Driver.getDriver().findElement(By.cssSelector("#identifierNext"));
        nextButton.click();
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#profileIdentifier"), emailAddress));
    }

    @Test
    public void ExplicitWait(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        Driver.openPage(gmailURL);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identifierId")));
        WebElement emailField = Driver.getDriver().findElement(By.cssSelector("#identifierId"));
        emailField.clear();
        emailField.sendKeys(emailAddress);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identifierNext")));
        WebElement nextButton = Driver.getDriver().findElement(By.cssSelector("#identifierNext"));
        nextButton.click();
        try {
            wait.until(ExpectedConditions.textToBe(By.cssSelector("#profileIdentifier"), emailAddress));
        } catch (TimeoutException e){
            throw new AssertionFailedError("The email address displayed was different than expected. " + e.getMessage());
        }
    }

    @Test
    public void ExplicitWaitFailingAssertion(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        Driver.openPage(gmailURL);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identifierId")));
        WebElement emailField = Driver.getDriver().findElement(By.cssSelector("#identifierId"));
        emailField.clear();
        emailField.sendKeys(emailAddress);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identifierNext")));
        WebElement nextButton = Driver.getDriver().findElement(By.cssSelector("#identifierNext"));
        nextButton.click();
        By profileIdentifier = By.cssSelector("#profileIdentifier");

        try {
            wait.until(ExpectedConditions.textToBe(profileIdentifier, emailAddress));
        } catch (TimeoutException e){
            throw new AssertionFailedError("The email address displayed was different than expected. " + e.getMessage());
        }
        String actualEmailAddress = Driver.getDriver().findElement(profileIdentifier).getText();

        Assert.assertEquals("Email address is different than expected. " +
                        "Expected: " + emailAddress + ". Actual : " + actualEmailAddress,
                "jakistammail@gmail.com", actualEmailAddress);
    }

    @Test
    public void listTest(){
        int noOfElements = 7;
        String productName = "dress";

        Driver.openPage("http://automationpractice.com");
        List<WebElement> webElementList = Driver.getDriver().findElements(By.cssSelector("ul#homefeatured div.product-container a.product-name"));
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

        Driver.openPage("http://automationpractice.com");
        List<WebElement> webElementList = Driver.getDriver().findElements(By.cssSelector("ul#homefeatured div.product-container"));
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

    @Test
    public void softAssertion(){
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(true).as("Simple checking true value")
                .isFalse();
        softAssertions.assertThat(false).as("Simple checking false value")
                .isTrue();
        softAssertions.assertThat("Ala").as("Comparing two strings")
                .isEqualTo("Ola");
        softAssertions.assertThat(100).as("Comparing integers")
                .isGreaterThan(200);

        softAssertions.assertAll();
    }
}
