package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    protected WebDriverWait wait;
    protected WebDriver driver;
    protected String mainHandler;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void switchFromMainToNextWindow(){
        mainHandler = driver.getWindowHandle();
        for (String handler : driver.getWindowHandles()) {
            if(!handler.equals(mainHandler)){
                driver.switchTo().window(handler);
                break;
            }
        }
    }

    public void switchToWindow(String handler){
        driver.switchTo().window(handler);
    }

    public void switchToMain(){
        switchToWindow(mainHandler);
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    protected void provideInput(By inputBy, CharSequence value){
        WebElement input = driver.findElement(inputBy);
        input.clear();
        input.sendKeys(value);
    }

    protected void clickOnElement(By elementBy){
        driver.findElement(elementBy).click();
    }

    protected String getLabelText(By elementBy){
        return driver.findElement(elementBy).getText();
    }

    protected WebElement findElement(By elementBy){
        return driver.findElement(elementBy);
    }

    protected List<WebElement> findElements(By elementBy){
        return driver.findElements(elementBy);
    }

}
