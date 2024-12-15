package pages.customerloginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

public class CustomerLoginPage extends BasePage {

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    private final By dropdownButtonYourName = By.xpath("//select[@id='userSelect']");

    public CustomerLoginPage checkCountUsers () {
        waitElementIsVisible(driver.findElement(dropdownButtonYourName));
        int countUsers = driver.findElements(dropdownButtonYourName).size();
        Assert.assertEquals(countUsers, 1);
        return this;
    }

    //private final By loginByRoleHarryPotter = By.xpath("//select[@id='userSelect']");
}
