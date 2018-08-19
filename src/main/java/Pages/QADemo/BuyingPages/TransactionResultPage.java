package Pages.QADemo.BuyingPages;

import Pages.QADemo.ContentBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionResultPage extends ContentBasePage {

    private final By transactionSummaryProductRow = By.cssSelector("table.wpsc-purchase-log-transaction-results > tbody > tr");
    private final By transactionSummaryProductNameField = By.cssSelector("table.wpsc-purchase-log-transaction-results > tbody > tr > td:nth-of-type(1)");
    private final By transactionSummaryProductPriceField = By.cssSelector("table.wpsc-purchase-log-transaction-results > tbody > tr > td:nth-of-type(2)");
    private final By transactionSummaryProductQuantityField = By.cssSelector("table.wpsc-purchase-log-transaction-results > tbody > tr > td:nth-of-type(3)");
    private final By transactionSummaryProductSumField = By.cssSelector("table.wpsc-purchase-log-transaction-results > tbody > tr > td:nth-of-type(4)");

    public TransactionResultPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfProducts(){
        return findElements(transactionSummaryProductRow).size();
    }

    public String getProductName(){
        return findElement(transactionSummaryProductNameField).getText();
    }

    public String getProductPrice(){
        return findElement(transactionSummaryProductPriceField).getText();
    }

    public String getProductQuantity(){
        return findElement(transactionSummaryProductQuantityField).getText();
    }

    public String getProductsSum(){
        return findElement(transactionSummaryProductSumField).getText();
    }
}
