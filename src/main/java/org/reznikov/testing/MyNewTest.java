package org.reznikov.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.reznikov.testing.pages.ItemsCatalog;
import org.reznikov.testing.pages.LandingPage;
import org.testng.annotations.Test;

/**
 * Created by antonreznikov on 1/10/17.
 */
public class MyNewTest extends BaseWebDriverTest{

    public static final String INPUT_SELECTOR = "//input[contains(@class,'rz-header-search-input-text')]";
    public static final String FILTER_SELECTOR = "a.filter-active-i-link";
    public static final String IPHONE_ITEM = "//div[contains(@class,'g-i-tile g-i-tile-catalog')]//div[contains(@class,'g-i-tile-i-title')]/a[contains(text(),'Apple iPhone 7 128GB Jet Black')]";

    @Test(groups = "PC")
    public void testSite(){

        //Search for Iphone
        /*driver.findElement(By.xpath(INPUT_SELECTOR))
                .sendKeys("Iphone"+ Keys.ENTER);*/
        LandingPage page = new LandingPage(driver);
        page.search("Iphone");
        ItemsCatalog catalog = page.getItemsCatalog();
        LandingPage itemPage = catalog.goToCategory("");


        wait.until(ExpectedConditions.textToBe(By.cssSelector(FILTER_SELECTOR),"Apple"));
        /*String result = driver.findElement(By.cssSelector(FILTER_SELECTOR)).getText();
        //Verify filter is enabled
        assert result.equals("Apple");*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .sendKeys("Samsung");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("rz-search-button")))
                .click();
        wait.until(ExpectedConditions.textToBe(By.cssSelector(FILTER_SELECTOR),"Samsung"));

        System.out.println("Test Done");


    }

    @Test
    public void testRozetka(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .sendKeys("iphone 7 32gb");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("rz-search-button")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(IPHONE_ITEM))).click();
        try {
            Thread.sleep(5000);
        } catch (Exception e){

        }
        assert driver.getCurrentUrl().equals("http://rozetka.com.ua/apple_iphone_7_128gb_jet_black/p11241577/");
    }

    @Test(priority = 2)
    public void testMe1(){
        System.out.println("Yay1");
    }

    @Test(priority = 1)
    public void testMe2(){
        System.out.println("Yay2");
    }

    @Test(priority = 1)
    public void testMe3(){
        System.out.println("Yay2");
    }

    @Test(priority = 1)
    public void testMe4(){
        System.out.println("Yay2");
    }

    @Test(priority = 1)
    public void testMe5(){
        System.out.println("Yay2");
    }

}
