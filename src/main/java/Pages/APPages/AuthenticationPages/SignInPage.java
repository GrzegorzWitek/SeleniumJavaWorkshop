package Pages.APPages.AuthenticationPages;

import Pages.APPages.APBasePage;
import Pages.APPages.BuyingPages.AddressPage;
import org.openqa.selenium.By;

public class SignInPage extends APBasePage {

    private final By emailInputLocator = By.cssSelector("input#email");
    private final By passwordInputLocator = By.cssSelector("input#passwd");
    private final By signInButtonLocator = By.cssSelector("button#SubmitLogin");

    public SignInPage enterEmailAddress(String email) {
        provideInput(emailInputLocator,email);
        return this;
    }

    public SignInPage enterPasword(String password) {
        provideInput(passwordInputLocator,password);
        return this;
    }

    public AddressPage clickSignInButton() {
        clickOnElement(signInButtonLocator);
        return new AddressPage();
    }

    public boolean isPasswordInput() {
        return findElement(passwordInputLocator).equals(windowsHelper.getActiveElement());
    }
}
