package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.Random;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // 1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        Random randomNum = new Random();
        int number = randomNum.nextInt(10000);

        // 1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals(expectedText, actualText);

        // 2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        Thread.sleep(3000);

        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));

        //2.6 Verify the text “Nokia Lumia 1020”
        String expectedText1 = "Nokia Lumia 1020";
        String actualText1 = getTextFromElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"));
        Assert.assertEquals(expectedText1, actualText1);

        //2.7 Verify the price “$349.00”
        String expectedText2 = "$349.00";
        String actualText2 = getTextFromElement(By.id("price-value-20"));
        Assert.assertEquals(expectedText2, actualText2);

        //2.8 Change quantity to 2
        driver.findElement(By.id("product_enteredQuantity_20")).clear();
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));

        // 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedText3 = "The product has been added to your shopping cart";
        String actualText3 = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedText3, actualText3);
        Thread.sleep(2000);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        // mouseHoverToElement(By.xpath("//button[normalize-space()='Go to cart']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        Thread.sleep(5000);

        //2.12 Verify the message "Shopping cart"
        String expectedText4 = "Shopping cart";
        String actualText4 = getTextFromElement(By.cssSelector("div[class='page-title'] h1"));
        Assert.assertEquals(expectedText4, actualText4);

        //2.13 Verify the quantity is 2
        //String expectedText5 = "2";
        //String actualText5 = getTextFromElement(By.xpath("(//label[@class='td-title'])[3]"));
        //Assert.assertEquals(expectedText5, actualText5);

        //2.14 Verify the Total $698.00
        String expectedText6 = "$698.00";
        String actualText6 = getTextFromElement(By.cssSelector(".product-subtotal"));
        Assert.assertEquals(expectedText6, actualText6);

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedText7 = "Welcome, Please Sign In!";
        String actualText7 = getTextFromElement(By.cssSelector("div[class='page-title'] h1"));
        Assert.assertEquals(expectedText7, actualText7);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));

        //2.19 Verify the text “Register”
        String expectedText8 = "Register";
        String actualText8 = getTextFromElement(By.cssSelector("div[class='page-title'] h1"));
        Assert.assertEquals(expectedText8, actualText8);

        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"), "Tesco");
        sendTextToElement(By.name("LastName"), "Extra");
        sendTextToElement(By.id("Email"), "tescoextra" + number + "@gmail.com");
        sendTextToElement(By.id("Password"), "Tesco1234");
        sendTextToElement(By.id("ConfirmPassword"), "Tesco1234");
        Thread.sleep(3000);

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));

        //2.22 Verify the message “Your registration completed”
        String expectedText9 = "Your registration completed";
        String actualText9 = getTextFromElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals(expectedText9, actualText9);

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //2.24 Verify the text “Shopping card”
        String expectedText10 = "Shopping cart";
        String actualText10 = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals(expectedText10, actualText10);

        //2.25 click on checkbox “I agree with the terms of service”

        //2.26 Click on “CHECKOUT”
        //2.27 Fill the Mandatory fields
        //2.28 Click on “CONTINUE”
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        //2.30 Click on “CONTINUE”
        //2.31 Select Radio Button “Credit Card”
        //2.32 Select “Visa” From Select credit card dropdown
        //2.33 Fill all the details
        //2.34 Click on “CONTINUE”
        //2.35 Verify “Payment Method” is “Credit Card”
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        //2.37 Verify Total is “$698.00”
        //2.38 Click on “CONFIRM”
        //2.39 Verify the Text “Thank You”
        //2.40 Verify the message “Your order has been successfully processed!”
        //2.41 Click on “CONTINUE”
        //2.42 Verify the text “Welcome to our store”
        //2.43 Click on “Logout” link
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
    }
}
