package Pages.QADemo.BuyingPages;

import Pages.QADemo.ContentBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutSummaryPage extends ContentBasePage {

    private final By emailInputBy = By.cssSelector("input#wpsc_checkout_form_9");
    private final By firstNameInputBy = By.cssSelector("input#wpsc_checkout_form_2");
    private final By lastNameInputBy = By.cssSelector("input#wpsc_checkout_form_3");
    private final By addressInputBy = By.cssSelector("textarea#wpsc_checkout_form_4");
    private final By cityInputBy = By.cssSelector("input#wpsc_checkout_form_5");
    private final By stateInputBy = By.cssSelector("input#wpsc_checkout_form_6");
    private final By phoneInputBy = By.cssSelector("input#wpsc_checkout_form_18");
    private final By countryInputBy = By.cssSelector("select#wpsc_checkout_form_7");
    private final By purchaseButtonBy = By.cssSelector("input.make_purchase");

    public CheckoutSummaryPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutSummaryPage setEmail(String email){
        wait.until(ExpectedConditions.elementToBeClickable(findElement(emailInputBy)));
        provideInput(emailInputBy, email);
        return this;
    }

    public CheckoutSummaryPage setFirstName(String firstName){
        wait.until(ExpectedConditions.elementToBeClickable(findElement(firstNameInputBy)));
        provideInput(firstNameInputBy, firstName);
        return this;
    }

    public CheckoutSummaryPage setLastName(String lastName){
        wait.until(ExpectedConditions.elementToBeClickable(findElement(lastNameInputBy)));
        provideInput(lastNameInputBy, lastName);
        return this;
    }

    public CheckoutSummaryPage setAddress(String address){
        wait.until(ExpectedConditions.elementToBeClickable(findElement(addressInputBy)));
        provideInput(addressInputBy, address);
        return this;
    }

    public CheckoutSummaryPage setCity(String city){
        wait.until(ExpectedConditions.elementToBeClickable(findElement(cityInputBy)));
        provideInput(cityInputBy, city);
        return this;
    }

    public CheckoutSummaryPage setState(String state){
        wait.until(ExpectedConditions.elementToBeClickable(findElement(stateInputBy)));
        provideInput(stateInputBy, state);
        return this;
    }

    public CheckoutSummaryPage setPhone(String phone){
        wait.until(ExpectedConditions.elementToBeClickable(findElement(phoneInputBy)));
        provideInput(phoneInputBy, phone);
        return this;
    }

    public CheckoutSummaryPage setCountry(String country){
        new Select(findElement(countryInputBy)).selectByVisibleText(country);
        return this;
    }

    public TransactionResultPage clickPurchase(){
        clickOnElement(purchaseButtonBy);
        return new TransactionResultPage(driver);
    }

    public TransactionResultPage setCheckoutDataAndPurchase(String email, String firstName, String lastName, String address, String city, String state, String phone, String country){
        return setEmail(email)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAddress(address)
                .setCity(city)
                .setState(state)
                .setPhone(phone)
                .setCountry(country)
                .clickPurchase();
    }
}
