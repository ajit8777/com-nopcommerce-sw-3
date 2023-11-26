package utilities;

import browserfactor.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();

    }


    //**************************************** Alert Methods  **************************************************************************

    /**
     * This method will switch to alert
     */
    public void switchToAlert(){
        driver.switchTo().alert();
    }

    /**
     * This method will accept to alert
     */
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    // 3 more method send text, dismiss,

    //*************************************** Select method  ****************************************************************

    public void selectValueFromDropDown(By by, String value){
        WebElement dropDown = driver.findElement(by);
        // create the object of select class
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    //************************* Action Method *****************************************

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
}
