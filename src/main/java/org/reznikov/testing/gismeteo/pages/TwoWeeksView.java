package org.reznikov.testing.gismeteo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class TwoWeeksView extends CityPage {
    public static final String FORECAST_ON_DATE = "//*[contains(@class,'rframe wblock wdata')][.//*[@class='s_date'][text()='{0}']]";

    public TwoWeeksView(WebDriver driver) {
        super(driver);
    }

    public void getForecastForDay(LocalDate date) {
        //LocalDate.now();//на нашем компе
        //LocalDate.parse("January 23 2016", DateTimeFormatter.ofPattern("MMMMM/dd/yyyy"));
        // LocalDate.now();//сегодняшняя дата
        // LocalDate.now().plusDays(14);//сегодняшняя дата + 14 дней

        LocalDate firstDayInList = LocalDate.now();
        LocalDate lastDayInList = LocalDate.now().plusDays(13);
//        if (0 < ChronoUnit.DAYS.between(firstDayInList, date) &&
//                (ChronoUnit.DAYS.between(firstDayInList, date) < 13)) {
//           //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FORECAST_ON_DAY.replace)))//передаем прогноз на день
//            // System.out.println("in two weeks range");
//        }
//// else  if (0> Duration.between(firstDayInList,date).toDays()){
////            System.out.println("earlier");
////        }else {
////            System.out.println("later");
////        }
////передаем дату любую и сравниваем с текущим днем
//        else {
//            throw new WebDriverException("Date" + date.toString() + "is not in two weeks range");
//        }

        if (0 < ChronoUnit.DAYS.between(firstDayInList, date) && ChronoUnit.DAYS.between(firstDayInList, date) < 13) {
            //wait.until(ExpectedConditions.)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    FORECAST_ON_DATE.replace("{0}",//будет икспас шаблон, который будет каждый день меняться
                            //каждый раз селектор будет меняться
                            date.format(DateTimeFormatter.ofPattern("dd.MM")
                                    .withLocale(Locale.forLanguageTag("ru-RU"))
                            ))))).click();
            System.out.println("In two weeks range");
        } else {
            throw new WebDriverException(("Date " + date.toString() + " is not in two week range"));
        }
    }
}
