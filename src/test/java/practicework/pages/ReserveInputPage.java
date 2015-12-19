package practicework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import util.CalendarUtility;

import java.util.Calendar;

public class ReserveInputPage {
    private final WebDriver driver;
    private final By date         = By.id("datePick");
    private final By reserveYear  = By.id("reserve_year");
    private final By reserveMonth = By.id("reserve_month");
    private final By reserveDay   = By.id("reserve_day");
    private final By reserveTerm  = By.id("reserve_term");
    private final By goToNext     = By.id("goto_next");
    private final By headcount    = By.id("headcount");
    private final By breakfastOn  = By.id("breakfast_on");
    private final By breakfastOff = By.id("breakfast_off");
    private final By guestName    = By.id("guestname");
    private final By planA        = By.id("plan_a");
    private final By planB        = By.id("plan_b");
    private final By agreeAndGotoNext = By.id("agree_and_goto_next");

    public static final boolean ON  = true;
    public static final boolean OFF = false;

    public ReserveInputPage(WebDriver driver) {
        this.driver = driver;
    }

    private void setReserveYear(String value) {
        WebElement element = driver.findElement(reserveYear);
        element.clear();
        element.sendKeys(value);
    }

    private void setReserveMonth(String value) {
        WebElement element = driver.findElement(reserveMonth);
        element.clear();
        element.sendKeys(value);
    }

    private void setReserveDay(String value) {
        WebElement element = driver.findElement(reserveDay);
        element.clear();
        element.sendKeys(value);
    }

    public void setReserveDate(){
        Calendar immediateDay = CalendarUtility.getImmediateDayOfWeek(
                Calendar.getInstance(), Calendar.SATURDAY
        );
        int reserveYear = immediateDay.get(Calendar.YEAR);
        int reserveMonth = immediateDay.get(Calendar.MONTH) + 1;
        int reserveDay = immediateDay.get(Calendar.DAY_OF_MONTH);

        setReserveDate(
                Integer.toString(reserveYear),
                Integer.toString(reserveMonth),
                Integer.toString(reserveDay)
        );
    }

    public void setReserveDate(String year, String month, String day) {
        //setReserveYear(year);
        //setReserveMonth(month);
        //setReserveDay(day);
        WebElement element
                = driver.findElement(date);
        element.clear();
        element.sendKeys(
                year + "/" + month + "/" + day
        );
        element.sendKeys(Keys.RETURN);
    }

    public void setReserveTerm(String value) {
        WebElement element = driver.findElement(reserveTerm);
        Select select = new Select(element);
        select.selectByValue(value);
        //element.clear();
        //element.sendKeys(value);
    }

    public void setReserveHeadcount(String hc){
        WebElement element = driver.findElement(headcount);
        Select select = new Select(element);
        select.selectByValue(hc);
        //driver.findElement(headcount).clear();
        //driver.findElement(headcount).sendKeys(hc);
    }

    public void setReserveBreakfast(boolean flag) {
        if(flag) driver.findElement(breakfastOn).click();
        else driver.findElement(breakfastOff).click();
    }

    public void setReservePlanA(boolean aflag){
        WebElement plan_a = driver.findElement(planA);
        if( aflag && !plan_a.isSelected() ) plan_a.click();
    }

    public void setReservePlanB(boolean bflag){
        WebElement plan_b = driver.findElement(planB);
        if( bflag && !plan_b.isSelected() ) plan_b.click();
    }

    public void setReserveName(String name) {
        driver.findElement(guestName).clear();
        driver.findElement(guestName).sendKeys(name);
    }

    public ReserveConfirmPage goToNext() {
        driver.findElement(agreeAndGotoNext).click();
        return new ReserveConfirmPage(driver);
    }
}
