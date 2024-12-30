package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    protected void pauseBetweenSteps() {
        try {
            Thread.sleep(2000); // Пауза в 2 секунд
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Восстановление статуса потока при прерывании
        }
    }

    public BasePage (WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public WebElement waitElementIsVisible (WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
        return element;

    }


}
