package pages.bankmanagerlogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

import java.time.Duration;

public class BankManagerLoginPage extends BasePage{

    private final By bankMangerLoginButton = By.xpath("//button[text()='Bank Manager Login']");
    private final By addCustomerButton = By.xpath("//button[@ng-click='addCust()']");
    private final By lineFirstName = By.xpath("//input[@placeholder='First Name']");
    private final By lineLastName = By.xpath("//input[@placeholder='Last Name']");
    private final By linePostCode = By.xpath("//input[@placeholder='Post Code']");
    private final By customersTable = By.xpath("//button[@ng-click='showCust()']");
    private final By searchCustomerLine = By.xpath("//input[@ng-model='searchCustomer']");
    private final By surnameTestUserForCheck = By.xpath("//td[text()='Shevchenko']");
    private final By deleteCustomerButton = By.xpath("//button[@ng-click='deleteCust(cust)']");
    // Method addCustomerButtonNewCustomer triggers Alert with button "OK"
    private final By addCustomerButtonNewCustomer = By.xpath("//button[@value='' and text()='Add Customer']");



    public BankManagerLoginPage (WebDriver driver) {
        super(driver);
    }



      public BankManagerLoginPage addNewCustomerBankManagerLoginPageAndCheck () {
        waitElementIsVisible(driver.findElement(bankMangerLoginButton));
        driver.findElement(bankMangerLoginButton).click();
        waitElementIsVisible(driver.findElement(addCustomerButton));
        driver.findElement(addCustomerButton).click();
        waitElementIsVisible(driver.findElement(lineFirstName));
        driver.findElement(lineFirstName).sendKeys("Taras");
        waitElementIsVisible(driver.findElement(lineLastName));
        driver.findElement(lineLastName).sendKeys("Shevchenko");
        waitElementIsVisible(driver.findElement(linePostCode));
        driver.findElement(linePostCode).sendKeys("84511");
        waitElementIsVisible(driver.findElement(addCustomerButtonNewCustomer));
        driver.findElement(addCustomerButtonNewCustomer).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Alert alert = driver.switchTo().alert();
        alert.accept();
        waitElementIsVisible(driver.findElement(customersTable));
        driver.findElement(customersTable).click();
        waitElementIsVisible(driver.findElement(searchCustomerLine));
        driver.findElement(searchCustomerLine).sendKeys("Shevchenko");
        waitElementIsVisible(driver.findElement(surnameTestUserForCheck));
        Assert.assertTrue(driver.findElement(surnameTestUserForCheck).isDisplayed(),"User not found!");
        waitElementIsVisible(driver.findElement(deleteCustomerButton));
        driver.findElement(deleteCustomerButton).click();
        return this;
    }

}
