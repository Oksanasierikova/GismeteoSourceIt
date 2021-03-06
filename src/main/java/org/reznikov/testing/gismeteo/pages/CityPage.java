package org.reznikov.testing.gismeteo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CityPage //extends GismeteoHomePage
{
    private static final String THREE_DAYS_VIEW_TAB = "";
    private static final String MONTH_VIEW_TAB = "";
    private static final String TWO_WEEKS_VIEW_TAB = "//*[@id='weather-daily']/div[3]/div[1]/a[4]";
    private static final String TEMP_DAY = "//*[@id='tbwdaily1']/tr[3]/td[3]/span[1]";
    private static final String TEMP_NIGHT = "//*[@id='tbwdaily1']/tr[1]/td[3]/span[1]";

    protected WebDriver driver;
    protected WebDriverWait wait;
    private long DEFAULT_TIMEOUT = 1;

    public CityPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

//    public CityPage(WebDriver driver) {
//        super(driver);
//    }

    public ThreeDaysView switchToThreeDayView() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(THREE_DAYS_VIEW_TAB))).click();
        return new ThreeDaysView(driver);
    }

    public MonthView switchToMonthView() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MONTH_VIEW_TAB))).click();
        return new MonthView(driver);
    }

    public TwoWeeksView switchToTwoWeeksView() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TWO_WEEKS_VIEW_TAB))).click();
        return new TwoWeeksView(driver);
    }

    public DayTemp getDayTemp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TEMP_DAY)));
        return new DayTemp(driver);
    }

    public NightTemp getNightTemp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TEMP_NIGHT)));
        return new NightTemp(driver);
    }
}
