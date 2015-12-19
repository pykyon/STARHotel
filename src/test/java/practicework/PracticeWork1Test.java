package practicework;

import core.ChromeDriverTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.CalendarUtility;

import java.io.File;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PracticeWork1Test extends ChromeDriverTest {
    @Before
    public void setUp() {
        super.setUp();
        // ページ遷移の際に少し待機するため
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }

    @Test
    public void testReserveWith9Mmebers() throws Exception {
        File html = new File("reserveApp/index.html");
        String url = html.toURI().toString();
        driver.get(url);

        // 現在のシステム日付を起点に明日以降の直近の土曜日を取得します
        Calendar immediateSaturday = CalendarUtility.getImmediateDayOfWeek(Calendar.getInstance(), Calendar.SATURDAY);
        int reserveYear = immediateSaturday.get(Calendar.YEAR);
        int reserveMonth = immediateSaturday.get(Calendar.MONTH) + 1;
        int reserveDay = immediateSaturday.get(Calendar.DAY_OF_MONTH);

        // 上記で取得した直近の土曜日を使用します
        driver.findElement(By.id("reserve_year")).clear();
        driver.findElement(By.id("reserve_year")).sendKeys(Integer.toString(reserveYear));
        driver.findElement(By.id("reserve_month")).clear();
        driver.findElement(By.id("reserve_month")).sendKeys(Integer.toString(reserveMonth));
        driver.findElement(By.id("reserve_day")).clear();
        driver.findElement(By.id("reserve_day")).sendKeys(Integer.toString(reserveDay));
        driver.findElement(By.id("reserve_term")).clear();
        driver.findElement(By.id("reserve_term")).sendKeys("1");
        driver.findElement(By.id("headcount")).clear();
        driver.findElement(By.id("headcount")).sendKeys("9");
        driver.findElement(By.id("breakfast_on")).click();
        WebElement planA = driver.findElement(By.id("plan_a"));
        if (!planA.isSelected()) {
            planA.click();
        }
        WebElement planB = driver.findElement(By.id("plan_b"));
        if (!planB.isSelected()) {
            planB.click();
        }
        driver.findElement(By.id("guestname")).clear();
        driver.findElement(By.id("guestname")).sendKeys("a");
        driver.findElement(By.id("goto_next")).click();

        // 2ページ目入力画面
        Calendar checkoutSunday = (Calendar) immediateSaturday.clone();
        checkoutSunday.add(Calendar.DAY_OF_MONTH, 1);
        int checkoutYear = checkoutSunday.get(Calendar.YEAR);
        int checkoutMonth = checkoutSunday.get(Calendar.MONTH) + 1;
        int checkoutDay = checkoutSunday.get(Calendar.DAY_OF_MONTH);
        assertThat(driver.findElement(By.id("price")).getText(), is("105750"));
        assertThat(driver.findElement(By.id("datefrom")).getText(), is(reserveYear + "年" + reserveMonth + "月" + reserveDay + "日"));
        assertThat(driver.findElement(By.id("dateto")).getText(), is(checkoutYear + "年" + checkoutMonth + "月" + checkoutDay + "日"));
        assertThat(driver.findElement(By.id("dayscount")).getText(), is("1"));
        assertThat(driver.findElement(By.id("hc")).getText(), is("9"));
        assertThat(driver.findElement(By.id("bf_order")).getText(), is("あり"));
        assertThat(driver.findElement(By.id("plan_a_order")).getText(), is("昼からチェックインプラン"));
        assertThat(driver.findElement(By.id("plan_b_order")).getText(), is("お得な観光プラン"));
        assertThat(driver.findElement(By.id("gname")).getText(), is("a"));
        driver.findElement(By.id("commit")).click();
    }
}
