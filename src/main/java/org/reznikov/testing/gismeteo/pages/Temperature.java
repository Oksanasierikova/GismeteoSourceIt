package org.reznikov.testing.gismeteo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Temperature extends CityPage {
    private static final String TEMP_DAY = "//*[@id='tbwdaily1']/tr[3]/td[3]/span[1]";
    private static final String TEMP_NIGHT = "//*[@id='tbwdaily1']/tr[1]/td[3]/span[1]";

    public Temperature(WebDriver driver) {
        super(driver);
    }

    public DayTemp getDayTemp() {
        wait.until(ExpectedConditions.textToBe(By.xpath(TEMP_DAY), "−1"));
        return new DayTemp(driver);
    }

    public DayTemp getNightTemp() {
        wait.until(ExpectedConditions.textToBe(By.xpath(TEMP_NIGHT), "−4"));
        return new DayTemp(driver);
    }
}
