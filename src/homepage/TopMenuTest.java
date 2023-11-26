package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class TopMenuTest extends Utility {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseurl);
    }

    public void selectMenu(String menu){
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='" + menu + "']"));

    }
    @Test
    public void verifyPageNavigation(){
        List<String> topMenus = new ArrayList<>();
        topMenus.add("Computers");
        topMenus.add("Electronics");
        topMenus.add("Apparel");
        topMenus.add("Digital downloads");
        topMenus.add("Books");
        topMenus.add("Jewelry");
        topMenus.add("Gift Cards");

        for (String topMenu : topMenus) {
            selectMenu(topMenu);
            String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='" + topMenu + "']"));
            Assert.assertEquals("Menu Not Found.", topMenu, actualMessage);
        }
    }

    @After
    public void closingBrowser(){
        closeBrowser();
    }




}
