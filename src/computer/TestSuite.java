package computer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        selectValueFromDropDown(By.id("products-orderby"), "6");

        List actualList = new ArrayList();

        List<WebElement> nameOfProduct = driver.findElements(By.xpath("//h2[@class='product-title']"));

        for (WebElement text : nameOfProduct) {
            String data = text.getText();
            actualList.add(data);
        }
        List expectedList = new ArrayList();
        expectedList.addAll(actualList);
        Collections.sort(expectedList);

        Assert.assertTrue(actualList.equals(expectedList));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        selectValueFromDropDown(By.id("products-orderby"), "5");
        Thread.sleep(3000);
        clickOnElement(By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[1]"));

        // 2.5 Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']"));
        Assert.assertEquals(expectedText, actualText);

        // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectValueFromDropDown(By.id("product_attribute_1"), "1");

        // 2.7.Select "8GB [+$60.00]" using Select class
        selectValueFromDropDown(By.id("product_attribute_2"), "5");

        // 2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

        // 2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));

        // 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        clickOnElement(By.id("product_attribute_5_12"));

        // 2.11 Verify the price "$1,475.00"
        String expectedPrice = "$1,475.00";
        String actualPrice = getTextFromElement(By.xpath("//span[text()='$1,475.00']"));
        Thread.sleep(5000);
        Assert.assertEquals(expectedPrice, actualPrice);
       // Thread.sleep(3000);


        // 2.12 Click on "ADD TO CARD" Button
        clickOnElement(By.id("add-to-cart-button-1"));

        // 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedText1 = "The product has been added to your shopping cart";
        String actualText1 = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedText1, actualText1);

        // After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        // 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));

        //2.15 Verify the message "Shopping cart"
        String expectedText2 = "Shopping cart";
        String actualText2 = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals(expectedText2, actualText2);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.id("updatecart"));
        Thread.sleep(6000);

        //2.17 Verify the Total"$2,950.00"
        String expectedText3 = "$2,950.00";
        String actualText3 = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals(expectedText3, actualText3);

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedText4 = "Welcome, Please Sign In!";
        String actualText4 = getTextFromElement(By.cssSelector("div[class='page-title'] h1"));
        Assert.assertEquals(expectedText4, actualText4);

        // 2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));

        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Tesco");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Extra");
        sendTextToElement(By.id("BillingNewAddress_Email"), "tesco1234@gmail.com");
        selectValueFromDropDown(By.id("BillingNewAddress_CountryId"), "233");
        sendTextToElement(By.id("BillingNewAddress_City"), "Harrow");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "100, close Avenue");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "HA3 GHH");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07774445551");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectValueFromDropDown(By.xpath("//select[@id='CreditCardType']"), "MasterCard");

        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Tesco Extra");
        sendTextToElement(By.id("CardNumber"), "5585478547852145");
        selectValueFromDropDown(By.id("ExpireMonth"), "11");
        selectValueFromDropDown(By.id("ExpireYear"), "2025");
        sendTextToElement(By.id("CardCode"), "456");

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.30 Verify “Payment Method” is “Credit Card”
        String expectedText5 = "Payment Method: Credit Card";
        String actualText5 = getTextFromElement(By.xpath("//li[@class='payment-method']"));
        Assert.assertEquals(expectedText5, actualText5);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedText6 = "Shipping Method: Next Day Air";
        String actualText6 = getTextFromElement(By.xpath("//li[@class='shipping-method']"));
        Assert.assertEquals(expectedText6, actualText6);

        //2.33 Verify Total is “$2,950.00”
        String expectedText7 = "$2,950.00";
        String actualText7 = getTextFromElement(By.xpath("//tr[@class='order-total']//span[@class='value-summary']"));
        Assert.assertEquals(expectedText7, actualText7);

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.35 Verify the Text “Thank You”
        String expectedText8 = "Thank you";
        String actualText8 = getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        Assert.assertEquals(expectedText8, actualText8);

        //2.36 Verify the message “Your order has been successfully processed!”
        String expectedText9 = "Your order has been successfully processed!";
        String actualText9 = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        Assert.assertEquals(expectedText9, actualText9);

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.37 Verify the text “Welcome to our store”
        //
        String expectedText10 = "Welcome to our store";
        String actualText10 = getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        Assert.assertEquals(expectedText10, actualText10);
//

    }
}
