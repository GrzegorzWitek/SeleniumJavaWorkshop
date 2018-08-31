package Pages;

import Driver.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    public WindowsHelper windowsHelper;
    protected WebDriverWait wait;
    protected String mainHandler;
    protected Actions actions;

    public BasePage(){
        wait = new WebDriverWait(Driver.getDriver(), 30);
        actions = new Actions(Driver.getDriver());
        windowsHelper=new WindowsHelper();
    }

    public String getPageTitle(){
        return Driver.getTitle();
    }

    protected void provideInput(By inputBy, CharSequence value){
        WebElement input = Driver.getDriver().findElement(inputBy);
        input.clear();
        input.sendKeys(value);
    }

    protected void clickOnElement(By elementBy){
        Driver.getDriver().findElement(elementBy).click();
    }

    protected String getLabelText(By elementBy){
        return Driver.getDriver().findElement(elementBy).getText();
    }

    protected WebElement findElement(By elementBy){
        return Driver.getDriver().findElement(elementBy);
    }

    protected List<WebElement> findElements(By elementBy){
        return Driver.getDriver().findElements(elementBy);
    }

    protected void switchFromMainToNextWindow(){
        mainHandler = windowsHelper.switchToNextWindow();
    }

    protected void switchToMain(){
        windowsHelper.switchToWindow(mainHandler);
    }

}
