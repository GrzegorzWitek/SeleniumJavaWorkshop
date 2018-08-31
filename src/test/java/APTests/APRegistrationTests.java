package APTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;

public class APRegistrationTests extends APBaseTest{

    @Test
    public void CheckInputOrder(){

        boolean isPasswordInput = mainPage.Header.clickSignIn()
                .enterEmailAddress("Mail" + Keys.TAB)
                .isPasswordInput();

        Assert.assertTrue("Wrong element is active",
                isPasswordInput);
    }
}
