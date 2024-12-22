package pages.homeglobalsqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class HomeGlobalsqaPage extends BasePage {
    public HomeGlobalsqaPage(WebDriver driver) {
        super(driver);
    }

    By customerLoginButton = By.xpath("//button[@ng-click='customer()']");

    public HomeGlobalsqaPage enterCustomerLoginButton(){
        driver.findElement(customerLoginButton).click();
        return this;
    }

}