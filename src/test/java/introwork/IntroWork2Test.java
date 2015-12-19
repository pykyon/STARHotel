package introwork;

import java.io.File;

import org.junit.Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import core.ChromeDriverTest;

/**
 * 入門課題その2:「クリックしてみよう」
 */
public class IntroWork2Test extends ChromeDriverTest {
    @Test
    public void testClickOKButton() throws Exception {
        File html = new File("introwork/introWork2.html");
        String url = html.toURI().toString();
        driver.get(url);

        // TODO 以下を削除して、代わりにOKボタンをクリックする処理を記述してください
        //Thread.sleep(1000);
        WebElement okButton
                = driver.findElement(By.id("ok_button"));
        okButton.click();
        //Thread.sleep(1000);
        // TODO ここまで削除してください
    }
}
