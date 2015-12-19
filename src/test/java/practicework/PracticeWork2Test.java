package practicework;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import practicework.pages.ReserveConfirmPage;
import practicework.pages.ReserveInputPage;
import core.ChromeDriverTest;

public class PracticeWork2Test extends ChromeDriverTest {
    @Before
    public void setUp() {
        super.setUp();
        // ページ遷移の際に少し待機するため
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }

    @Test
    public void testReserveWith9MmebersUsingPageObject() throws Exception {
        File html = new File("reserveApp/index.html");
        String url = html.toURI().toString();
        driver.get(url);

        // 1ページ目入力画面
        ReserveInputPage inputPage = new ReserveInputPage(driver);

        // TODO 残りの処理を記述してください
        inputPage.setReserveDate();
        inputPage.setReserveTerm("1");
        inputPage.setReserveHeadcount("9");
        inputPage.setReserveBreakfast(ReserveInputPage.ON);
        inputPage.setReservePlanA(ReserveInputPage.ON);
        inputPage.setReservePlanB(ReserveInputPage.OFF);
        inputPage.setReserveName("a");

        ReserveConfirmPage confirmPage = inputPage.goToNext();

        // 2ページ目入力画面
        assertThat(confirmPage.getPrice(), is("105750"));
        assertThat(confirmPage.getDateFrom(), is("2015年12月26日")); // TODO 変更してください
        assertThat(confirmPage.getDateTo(), is("2015年12月27日")); // TODO 変更してください
        assertThat(confirmPage.getDaysCount(), is("1"));
        assertThat(confirmPage.getHc(), is("9"));
        assertThat(confirmPage.getBfOrder(), is("あり"));
        assertThat(confirmPage.getPlanA(), is("昼からチェックインプラン"));
        assertThat(confirmPage.getPlanB(), is("お得な観光プラン"));
        assertThat(confirmPage.getGname(), is("a"));

        // TODO 残りの処理を記述してください
    }
}
