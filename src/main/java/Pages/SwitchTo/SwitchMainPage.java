package Pages.SwitchTo;

import Pages.BasePage;
import org.openqa.selenium.By;

public class SwitchMainPage extends BasePage {

    public SwitchUpperFrame goToUpperFrame(){
        windowsHelper.switchToFrame(By.cssSelector("frame[src='htmlf.htm']"));
        return new SwitchUpperFrame();
    }

    public SwitchMiddleFrame goToMiddleFrame(){
        windowsHelper.switchToFrame(By.cssSelector("frame[src='message.htm']"));
        return new SwitchMiddleFrame();
    }

    public SwitchLowerFrame goToLowerFrame(){
        windowsHelper.switchToFrame(By.cssSelector("frame[src='tags.htm']"));
        return new SwitchLowerFrame();
    }
}
