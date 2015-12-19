package introwork;

import core.ChromeDriverTest;
import org.junit.Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.io.File;

/**
 * 入門課題その3:「文字列を入力してみよう」
 */
public class IntroWork3Test extends ChromeDriverTest {
    @Test
    public void testClearAndSendKeys() throws Exception {
        File html = new File("introwork/introWork3.html");
        String url = html.toURI().toString();
        driver.get(url);
        
        // TODO 以下を削除して、代わりに文字列を入力する処理を記述してください
        //Thread.sleep(8000);
        WebElement input
                = driver.findElement(By.id("subject"));
        input.clear();
        input.sendKeys("hogehoge");
        // TODO ここまで削除してください
    }
}
