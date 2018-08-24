package Pages.SwitchTo;

import Pages.QADemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchMainPage extends BasePage {
    public SwitchMainPage(WebDriver driver) {
        super(driver);
    }

    public SwitchUpperFrame goToUpperFrame(){
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='htmlf.htm']")));
        return new SwitchUpperFrame(driver);
    }

    public SwitchMiddleFrame goToMiddleFrame(){
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='message.htm']")));
        return new SwitchMiddleFrame(driver);
    }

    public SwitchLowerFrame goToLowerFrame(){
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='tags.htm']")));
        return new SwitchLowerFrame(driver);
    }
}
