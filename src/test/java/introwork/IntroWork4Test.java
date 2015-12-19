package introwork;

import core.ChromeDriverTest;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.io.File;

/**
 * 入門課題その4:「ラジオボタンを選択してみよう」
 */
public class IntroWork4Test extends ChromeDriverTest {
    @Test
    public void testClickRadioButton() throws Exception {
        File html = new File("introwork/introWork4.html");
        String url = html.toURI().toString();
        driver.get(url);
        
        // TODO 以下を削除して、代わりにラジオボタンを選択する処理を記述してください
        //Thread.sleep(8000);
        WebElement onRadioButton
                = driver.findElement(By.id("on_radio"));
        onRadioButton.click();
        // TODO ここまで削除してください
    }
}
