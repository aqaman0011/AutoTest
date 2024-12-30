package tests.base;

import common.CommonAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import pages.bankmanagerlogin.BankManagerLoginPage;
import pages.base.BasePage;
import pages.customerloginpage.CustomerLoginPage;
import pages.homeglobalsqa.HomeGlobalsqaPage;

import java.util.Set;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected HomeGlobalsqaPage homeGlobalsqaPage = new HomeGlobalsqaPage(driver);
    protected CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
    protected BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage(driver);

    @AfterSuite(alwaysRun = true)
    public void quite(){
        driver.quit();
    }

    protected void switchWindow(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String window1 = driver.getWindowHandle();
        js.executeScript("window.open()");
        Set<String> currentWindows = driver.getWindowHandles();
        String window2 = null;

        for (String window : currentWindows){
            if (!window.equals(window1)) {
                window2 = window;
                break;
            }
        }
        driver.switchTo().window(window2);
    }
}
