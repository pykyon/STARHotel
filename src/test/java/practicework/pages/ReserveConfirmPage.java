package practicework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReserveConfirmPage {
    private final WebDriver driver;
    private final By price        = By.id("price");
    private final By dateFrom     = By.id("datefrom");
    private final By dateTo       = By.id("dateto");
    private final By daysCount    = By.id("dayscount");
    private final By hc           = By.id("hc");
    private final By bf_order     = By.id("bf_order");
    private final By plan_a_order = By.id("plan_a_order");
    private final By plan_b_order = By.id("plan_b_order");
    private final By gname        = By.id("gname");

    private boolean existsPlan(By id) {
        if( driver.findElements(id).size() > 0 ) return true;
        return false;
    }

    public ReserveConfirmPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPrice() {
        return driver.findElement(price).getText();
    }
    
    public String getDateFrom() {
        return driver.findElement(dateFrom).getText();
    }

    public String getDateTo() {
        return driver.findElement(dateTo).getText();
    }
    
    public String getDaysCount() {
        return driver.findElement(daysCount).getText();
    }

    public String getHc() { return driver.findElement(hc).getText(); }

    public String getBfOrder() { return driver.findElement(bf_order).getText(); }

    public String getPlanA() {
        if( !existsPlan(plan_a_order) ) return "";
        return driver.findElement(plan_a_order).getText();
    }

    public String getPlanB() {
        if( !existsPlan(plan_b_order) ) return "";
        return driver.findElement(plan_b_order).getText();
    }

    public String getGname() { return driver.findElement(gname).getText(); }
}
