package Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindowsHelper {
    volatile WebDriver driver = Driver.getDriver();

    public String switchToNextWindow(){
        String mainHandler = driver.getWindowHandle();
        for (String handler : driver.getWindowHandles()) {
            if(!handler.equals(mainHandler)){
                driver.switchTo().window(handler);
                return mainHandler;
            }
        }
        throw new UnsupportedOperationException("Cannot change window, exist only one hadler");
    }

    public void switchToWindow(String handler){
        driver.switchTo().window(handler);
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public WebElement getActiveElement() {
        return  driver.switchTo().activeElement();

    }

    public void closeWindow(){
        driver.close();
    }

    public void switchToFrame(By targetFrameBy){
        driver.switchTo().frame(driver.findElement(targetFrameBy));
    }

    public void backToDefaultContent(){
        driver.switchTo().defaultContent();
    }

}
