import Driver.Driver;
import org.codehaus.plexus.util.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class TestContext {

    private By allProductsButton = By.xpath("//li[contains(@class,'menu-item')]//a[text()='All Product']");
    private By goToCardButton = By.cssSelector("div#header_cart");
    private By continueToCheckoutButton = By.cssSelector("a.step2");
    private By searchInput = By.cssSelector("input.search");
    private By iphone5ProductName = By.xpath("//a[text()='iPhone 5']");
    private By iphone5CarouselItem = By.cssSelector("ul#slide_menu>a:nth-of-type(2)");
    private By iphone5CarouselBuy = By.cssSelector("a[title='Buy Now']>img[alt='iPhone 5']");
    private By removeProductButton = By.cssSelector("input[value='Remove']");
    private By addedToCardMessage = By.cssSelector("div.alert.addtocart");

    private By transactionSummaryProductRow = By.cssSelector("table.wpsc-purchase-log-transaction-results > tbody > tr");
    private By transactionSummaryProductNameField = By.cssSelector("table.wpsc-purchase-log-transaction-results > tbody > tr > td:nth-of-type(1)");
    private By transactionSummaryProductPriceField = By.cssSelector("table.wpsc-purchase-log-transaction-results > tbody > tr > td:nth-of-type(2)");
    private By transactionSummaryProductQuantityField = By.cssSelector("table.wpsc-purchase-log-transaction-results > tbody > tr > td:nth-of-type(3)");
    private By transactionSummaryProductSumField = By.cssSelector("table.wpsc-purchase-log-transaction-results > tbody > tr > td:nth-of-type(4)");

    @Rule
    public final TestName name = new TestName();

    @Before
    public void initializeDriver(){
        Driver.openPage("http://store.demoqa.com");
        System.out.println(name.getMethodName() + " execution started.");
    }
    @After
    public void quitDriver(){
        System.out.println(name.getMethodName() + " execution ended.");
        Driver.quit();
    }

    @Test
    public void buySingleProductTest() {
        Driver.getDriver().findElement(allProductsButton).click();
        addToCard("iPhone 5");

        Driver.getDriver().findElement(goToCardButton).click();
        Driver.getDriver().findElement(continueToCheckoutButton).click();

        setCheckoutDataAndPurchase("aaa@a.pl", "firstName","lastName", "My address", "My city",
                "My undefined", "666666666", "Albania");

        Assert.assertEquals("Wrong number of products.",
                1, Driver.getDriver().findElements(transactionSummaryProductRow).size());
        Assert.assertEquals("Wrong product name",
                "iPhone 5", Driver.getDriver().findElement(transactionSummaryProductNameField).getText());
        Assert.assertEquals("Wrong price",
                "$12.00", Driver.getDriver().findElement(transactionSummaryProductPriceField).getText());
        Assert.assertEquals("Wrong quantity",
                "1", Driver.getDriver().findElement(transactionSummaryProductQuantityField).getText());
        Assert.assertEquals("Wrong sum",
                "$12.00", Driver.getDriver().findElement(transactionSummaryProductSumField).getText());
    }

    @Test
    public void cancelBuyProduct(){
        Driver.getDriver().findElement(allProductsButton).click();
        addToCard("iPhone 5");

        Driver.getDriver().findElement(goToCardButton).click();
        Driver.getDriver().findElement(removeProductButton).click();

        Assert.assertEquals("Wrong message after cancel remove product",
                "Oops, there is nothing in your cart.", Driver.getDriver().findElement(By.cssSelector("div.entry-content")).getText());
    }

    @Test
    public void searchAndBuyProduct() {
        provideInput(searchInput, "iphone 5" + Keys.ENTER);
        Driver.getDriver().findElement(iphone5ProductName).click();

        addToCard();

        Driver.getDriver().findElement(goToCardButton).click();
        Driver.getDriver().findElement(continueToCheckoutButton).click();

        setCheckoutDataAndPurchase("aaa@a.pl", "firstName","lastName", "My address", "My city",
                "My undefined", "666666666", "Albania");

        Assert.assertEquals("Wrong number of products.",
                1, Driver.getDriver().findElements(transactionSummaryProductRow).size());
        Assert.assertEquals("Wrong product name",
                "iPhone 5", Driver.getDriver().findElement(transactionSummaryProductNameField).getText());
        Assert.assertEquals("Wrong price",
                "$12.00", Driver.getDriver().findElement(transactionSummaryProductPriceField).getText());
        Assert.assertEquals("Wrong quantity",
                "1", Driver.getDriver().findElement(transactionSummaryProductQuantityField).getText());
        Assert.assertEquals("Wrong sum",
                "$12.00", Driver.getDriver().findElement(transactionSummaryProductSumField).getText());
    }

    @Test
    public void buyIphoneFromCarousel() {
        Driver.getDriver().findElement(iphone5CarouselItem).click();
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(iphone5CarouselBuy)));
        waitForElementAndReturn(iphone5CarouselBuy,0);

        Driver.getDriver().findElement(iphone5CarouselBuy).click();
        addToCard();
        Driver.getDriver().findElement(goToCardButton).click();
        Driver.getDriver().findElement(continueToCheckoutButton).click();

        setCheckoutDataAndPurchase("aaa@a.pl", "firstName","lastName", "My address", "My city",
                "My undefined", "666666666", "Albania");

        Assert.assertEquals("Wrong number of products.",
                1, Driver.getDriver().findElements(transactionSummaryProductRow).size());
        Assert.assertEquals("Wrong product name",
                "iPhone 5", Driver.getDriver().findElement(transactionSummaryProductNameField).getText());
        Assert.assertEquals("Wrong price",
                "$12.00", Driver.getDriver().findElement(transactionSummaryProductPriceField).getText());
        Assert.assertEquals("Wrong quantity",
                "1", Driver.getDriver().findElement(transactionSummaryProductQuantityField).getText());
        Assert.assertEquals("Wrong sum",
                "$12.00", Driver.getDriver().findElement(transactionSummaryProductSumField).getText());
    }

    private void addToCard(String productName){
        List<WebElement> productList = Driver.getDriver().findElements(By.cssSelector("a.wpsc_product_title"));
        for (int i=0; i<productList.size(); i++) {
            if(productList.get(i).getText().equals(productName)){
                WebElement buyButton = Driver.getDriver().findElements(By.cssSelector("input.wpsc_buy_button")).get(i);
                buyButton.click();
                waitForElementAndReturn(addedToCardMessage,5);
                break;
            }
        }
    }
    private void addToCard() {
        WebElement buyButton = Driver.getDriver().findElement(By.cssSelector("input.wpsc_buy_button"));
        buyButton.click();
        waitForElementAndReturn(addedToCardMessage, 0);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(addedToCardMessage)));
    }

    private void setCheckoutDataAndPurchase(String email, String firstName, String lastName, String address, String city, String state, String phone, String country) {

        By emailInputBy = By.cssSelector("input#wpsc_checkout_form_9");
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(emailInputBy)));
        waitForElementAndReturn(emailInputBy,0);

        provideInput(By.cssSelector("input#wpsc_checkout_form_9"), email);
        provideInput(By.cssSelector("input#wpsc_checkout_form_2"), firstName);
        provideInput(By.cssSelector("input#wpsc_checkout_form_3"), lastName);
        provideInput(By.cssSelector("textarea#wpsc_checkout_form_4"), address);
        provideInput(By.cssSelector("input#wpsc_checkout_form_5"), city);
        provideInput(By.cssSelector("input#wpsc_checkout_form_6"), state);
        provideInput(By.cssSelector("input#wpsc_checkout_form_18"), phone);

        new Select(Driver.getDriver().findElement(By.cssSelector("select#wpsc_checkout_form_7"))).selectByVisibleText(country);
        Driver.getDriver().findElement(By.cssSelector("input.make_purchase")).click();
    }

    private void provideInput(By inputBy, CharSequence value){
        WebElement input = Driver.getDriver().findElement(inputBy);
        input.clear();
        input.sendKeys(value);
    }

    private WebElement waitForElementAndReturn(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeoutInSeconds);
        try{
            wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(by)));
        }
        catch (TimeoutException e){
            File scrFile = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
            String dateString = dateFormat.format(date);
            try {
                String path = "c:\\SeleniumTemp\\" + dateString + ".png";
                FileUtils.copyFile(scrFile, new File(path));
                System.out.println("Element with selector " + by + " was not found after " + timeoutInSeconds + " seconds. " +
                        "Screenshot available at: " + path);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(by)));
    }
}
