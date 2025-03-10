package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static common.Config.IMPLICIT_WAIT;
import static common.Config.PLATFORM_AND_BROWSER;

public class CommonAction {
    private static WebDriver driver = null;

    private CommonAction() {
    }

/*    public static WebDriver createDriver() {
        if (driver == null) {
            switch (PLATFORM_AND_BROWSER){
                case "win_Chrome":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "mac_Chrome":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                    driver = new ChromeDriver();
                    break;
                default:
                    Assert.fail("Incorrect platform or browser name: " + PLATFORM_AND_BROWSER);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        }
        }
        return driver;*/

        public static WebDriver createDriver() {
            if (driver == null) {
                switch (PLATFORM_AND_BROWSER) {
                    case "win_Chrome":
                    case "mac_Chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    default:
                        Assert.fail("Incorrect platform or browser name: " + PLATFORM_AND_BROWSER);
                }
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
            }
            return driver;
        }
}
