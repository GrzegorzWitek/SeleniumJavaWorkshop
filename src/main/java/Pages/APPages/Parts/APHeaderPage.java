package Pages.APPages.Parts;

import Pages.APPages.AuthenticationPages.SignInPage;
import Pages.BasePage;
import org.openqa.selenium.By;

public class APHeaderPage extends BasePage {

    private final By signInButtonLocator = By.cssSelector("a.login");

    public SignInPage clickSignIn(){
        clickOnElement(signInButtonLocator);
        return new SignInPage();
    }
}
