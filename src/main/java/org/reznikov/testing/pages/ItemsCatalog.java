package org.reznikov.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by antonreznikov on 1/17/17.
 */
public class ItemsCatalog extends LandingPage {

    public ItemsCatalog(WebDriver driver) {
        super(driver);
        /*PageFactory.initElements(driver,this);*/
    }
/*     Так делать не надо
    @FindBy(xpath = "//ok")
    WebElement ok;*/

    public ItemsCatalog selectCategory(String category){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("fat_menu_btn"))).build().perform();
        return this;
    }

    public LandingPage goToCategory(String category){
        selectCategory(category);
        return new LandingPage(driver);
    }
}
