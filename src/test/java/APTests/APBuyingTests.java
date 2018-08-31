package APTests;

import org.junit.Assert;
import org.junit.Test;

public class APBuyingTests extends APBaseTest{

    @Test
    public void AddFirstElementToCart(){
        String email = "zzz@z.com";
        String password = "zzzzz";
        String expectedConfirmationMessage = "Product successfully added to your shopping cart";

        String confirmationMessage = mainPage.clickQuickViewOverProduct()
                .clickAddToCart()
                .getConfirmationMessage();

        Assert.assertTrue("Confirmation message has wrong text. Is " + confirmationMessage + " but should be: " + expectedConfirmationMessage,
                confirmationMessage.contains(expectedConfirmationMessage));
    }

    @Test
    public void BuyFirstProduct(){
        String email = "zzz@z.com";
        String password = "zzzzz";
        String expectedConfirmationMessage = "Your order on My Store is complete.";

        String confirmationMessage = mainPage.clickQuickViewOverProduct()
                .clickAddToCart()
                .clickProceedToCheckout()
                .increaseQty()
                .clickProceedToCheckout()
                .enterEmailAddress(email)
                .enterPasword(password)
                .clickSignInButton()
                .clickProcessdToCheckout()
                .checkTermsOfService()
                .clickProcessToCheckout()
                .selectPayByBankWire()
                .clickConfirmMyOrder()
                .getConfirmationMessage();

        Assert.assertEquals("Confirmation message has wrong text",
                expectedConfirmationMessage, confirmationMessage);
    }

}
