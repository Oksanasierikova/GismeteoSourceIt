package org.reznikov.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by antonreznikov on 1/17/17.
 */
public class LandingPage {
    public static final String INPUT_SELECTOR = "//input[contains(@class,'rz-header-search-input-text')]";

    public WebDriver driver;
    public WebDriverWait wait;

    public LandingPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(this.driver, 15);
        this.driver.get("http://rozetka.com.ua/");
    }

    public LandingPage search(String query){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .sendKeys(query);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("rz-search-button")))
                .click();
        return this;
    }

    public ItemsCatalog getItemsCatalog(){
        return new ItemsCatalog(driver);
    }
}
