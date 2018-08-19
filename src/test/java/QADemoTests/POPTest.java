package QADemoTests;

import Pages.QADemo.BuyingPages.CheckoutPage;
import Pages.QADemo.BuyingPages.TransactionResultPage;
import org.junit.Assert;
import org.junit.Test;

public class POPTest extends POPBaseTest{

    @Test
    public void cancelBuyProduct(){
        CheckoutPage checkoutPage = mainPage.clickAllProductMenu()
                .addToCart("iPhone 5")
                .header.clickCartButton()
                .clickRemoveProduct();

        Assert.assertEquals("Wrong message after cancel remove product",
                "Oops, there is nothing in your cart.", checkoutPage.getCheckoutContent());
    }

    @Test
    public void buySingleProductTest(){
        int expectedNumberOfProducts = 1;
        String expectedProductName = "iPhone 5";
        String expectedPrice = "$12.00";
        String expectedProductQuantity = "1";
        String expectedSum = "$12.00";

        TransactionResultPage transactionResultPage = mainPage.clickAllProductMenu()
                .addToCart(expectedProductName)
                .header.clickCartButton()
                .clickContinueButton()
                .setCheckoutDataAndPurchase("aaa@a.pl", "firstName","lastName", "My address", "My city",
                "My undefined", "666666666", "Albania");

        Assert.assertEquals("Wrong number of products.",
                expectedNumberOfProducts, transactionResultPage.getNumberOfProducts());
        Assert.assertEquals("Wrong product name",
                expectedProductName, transactionResultPage.getProductName());
        Assert.assertEquals("Wrong price",
                expectedPrice, transactionResultPage.getProductPrice());
        Assert.assertEquals("Wrong quantity",
                expectedProductQuantity, transactionResultPage.getProductQuantity());
        Assert.assertEquals("Wrong sum",
                expectedSum, transactionResultPage.getProductsSum());
    }

    @Test
    public void searchAndBuyProduct(){
        int expectedNumberOfProducts = 1;
        String expectedProductName = "iPhone 5";
        String expectedPrice = "$12.00";
        String expectedProductQuantity = "1";
        String expectedSum = "$12.00";

        TransactionResultPage transactionResultPage = mainPage.header.searchProduct(expectedProductName)
                .openProduct(expectedProductName)
                .addToCart()
                .header.clickCartButton()
                .clickContinueButton()
                .setCheckoutDataAndPurchase("aaa@a.pl", "firstName","lastName", "My address", "My city",
                "My undefined", "666666666", "Albania");

        Assert.assertEquals("Wrong number of products.",
                expectedNumberOfProducts, transactionResultPage.getNumberOfProducts());
        Assert.assertEquals("Wrong product name",
                expectedProductName, transactionResultPage.getProductName());
        Assert.assertEquals("Wrong price",
                expectedPrice, transactionResultPage.getProductPrice());
        Assert.assertEquals("Wrong quantity",
                expectedProductQuantity, transactionResultPage.getProductQuantity());
        Assert.assertEquals("Wrong sum",
                expectedSum, transactionResultPage.getProductsSum());
    }

    @Test
    public void buyIphoneFromCarousel(){
        int expectedNumberOfProducts = 1;
        String expectedProductName = "iPhone 5";
        String expectedPrice = "$12.00";
        String expectedProductQuantity = "1";
        String expectedSum = "$12.00";

        TransactionResultPage transactionResultPage = mainPage.clickIphoneCarouselItem()
                .clickIphoneCarouselBuy()
                .addToCart()
                .header.clickCartButton()
                .clickContinueButton()
                .setCheckoutDataAndPurchase("aaa@a.pl", "firstName","lastName", "My address", "My city",
                "My undefined", "666666666", "Albania");

        Assert.assertEquals("Wrong number of products.",
                expectedNumberOfProducts, transactionResultPage.getNumberOfProducts());
        Assert.assertEquals("Wrong product name",
                expectedProductName, transactionResultPage.getProductName());
        Assert.assertEquals("Wrong price",
                expectedPrice, transactionResultPage.getProductPrice());
        Assert.assertEquals("Wrong quantity",
                expectedProductQuantity, transactionResultPage.getProductQuantity());
        Assert.assertEquals("Wrong sum",
                expectedSum, transactionResultPage.getProductsSum());
    }

}
