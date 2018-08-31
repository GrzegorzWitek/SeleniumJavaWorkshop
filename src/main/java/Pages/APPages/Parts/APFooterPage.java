package Pages.APPages.Parts;

import Pages.APPages.APExternalPage;
import Pages.BasePage;
import org.openqa.selenium.By;

public class APFooterPage extends BasePage {
    
    private final String socialLinksLocator = "#social_block li.";
    private final By facebookLinkLocator = By.cssSelector("#social_block li.facebook");
    private final By twitterLinkLocator = By.cssSelector("#social_block li.twitter");
    private final By youtubeLinkLocator = By.cssSelector("#social_block li.youtube");
    private final By googlePlusLinkLocator = By.cssSelector("#social_block li.google-plus");

    public APExternalPage clickSocialLink(String linkName){
        clickOnElement(By.cssSelector(socialLinksLocator+linkName));
        switchFromMainToNextWindow();
        return new APExternalPage();
    }

    public APExternalPage clickFacebookLink(){
        clickOnElement(facebookLinkLocator);
        switchFromMainToNextWindow();
        return new APExternalPage();
    }
    
    public APExternalPage clickTwitterLink(){
        clickOnElement(twitterLinkLocator);
        switchFromMainToNextWindow();
        return new APExternalPage();
    }
    
    public APExternalPage clickYoutubeLink(){
        clickOnElement(youtubeLinkLocator);
        switchFromMainToNextWindow();
        return new APExternalPage();
    }
    
    public APExternalPage clickGooglePlusLink(){
        clickOnElement(googlePlusLinkLocator);
        switchFromMainToNextWindow();
        return new APExternalPage();
    }
}
