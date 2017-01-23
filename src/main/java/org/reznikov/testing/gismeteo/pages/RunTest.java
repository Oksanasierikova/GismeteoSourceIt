package org.reznikov.testing.gismeteo.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.reznikov.testing.BaseWebDriverTest;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class RunTest extends BaseWebDriverTest {

    @Test
    public void testGoToTwoWeeksView() {
        GismeteoHomePage page = new GismeteoHomePage(driver);
        page.searchForCity("Харьков");
        wait.until(ExpectedConditions.titleIs("GISMETEO: Погода в Харькове на сегодня, завтра - прогноз погоды на 3 дня, Харьковская область, Харьков, Украина."));
        CityPage pageTwoWeeks = new CityPage(driver);
        pageTwoWeeks.switchToTwoWeeksView();
       // wait.until(ExpectedConditions.urlContains("https://www.gismeteo.ua/weather-kharkiv-5053/14-days/"));
        assert driver.getCurrentUrl().equals("https://www.gismeteo.ua/weather-kharkiv-5053/14-days/");
        TwoWeeksView twoWeeks = new TwoWeeksView(driver);
        twoWeeks.getForecastForDay(LocalDate.of(2017, 01, 24));
        Temperature tempForDay = new Temperature(driver);
        tempForDay.getDayTemp();
        tempForDay.getNightTemp();
    }
}
