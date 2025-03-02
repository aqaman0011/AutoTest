package pages.bankmanagerlogin;

import org.openqa.selenium.*;
import pages.base.BasePage;

import java.time.Duration;

public class BankManagerLoginPage extends BasePage {

    private final By bankMangerLoginButton = By.xpath("//button[text()='Bank Manager Login']");
    private final By addCustomerButtonMenu = By.xpath("//button[@ng-click='addCust()']");
    private final By lineFirstName = By.xpath("//input[@placeholder='First Name']");
    private final By lineLastName = By.xpath("//input[@placeholder='Last Name']");
    private final By linePostCode = By.xpath("//input[@placeholder='Post Code']");
    private final By customersTable = By.xpath("//button[@ng-click='showCust()']");
    private final By searchCustomerLine = By.xpath("//input[@ng-model='searchCustomer']");
    private final By addCustomerButtonNewCustomer = By.xpath("//button[@value='' and text()='Add Customer']");


    public BankManagerLoginPage(WebDriver driver) {
        super(driver);
    }

    public BankManagerLoginPage clickBankManagerLoginButton() {
        waitElementIsVisible(driver.findElement(bankMangerLoginButton));
        driver.findElement(bankMangerLoginButton).click();
        return this;
    }

    public BankManagerLoginPage selectAddCustomerMenu() {
        waitElementIsVisible(driver.findElement(addCustomerButtonMenu));
        driver.findElement(addCustomerButtonMenu).click();
        return this;
    }

    public BankManagerLoginPage selectCustomerListMenu() {
        waitElementIsVisible(driver.findElement(customersTable));
        driver.findElement(customersTable).click();
        return this;
    }

    public BankManagerLoginPage typeFirstName(String firstName) {
        fillInput(lineFirstName, firstName);
        return this;
    }

    public BankManagerLoginPage typeLastName(String lastName) {
        fillInput(lineLastName, lastName);
        return this;
    }

    public BankManagerLoginPage typePostCode(String postCode) {
        fillInput(linePostCode, postCode);
        return this;
    }

    public boolean searchCustomerByFirstName(String firstName) {
        return searchCustomer(firstName, 1);
    }

    public boolean searchCustomerByLastName(String lastName) {
        return searchCustomer(lastName, 2);
    }

    public boolean searchCustomerByPostCode(String postCode) {
        return searchCustomer(postCode, 3);
    }

    private boolean searchCustomer(String searchParam, int targetColumnIndex) {
        fillInput(searchCustomerLine, searchParam);
        String xpathTemplate = String.format("//tbody/tr/td[%d][text()='%s']", targetColumnIndex, searchParam);
        By customer = By.xpath(xpathTemplate);
        try {
            return driver.findElement(customer).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    private void fillInput(By by, String input) {
        waitElementIsVisible(driver.findElement(by));
        WebElement searchInputElement = driver.findElement(by);
        searchInputElement.clear();
        searchInputElement.sendKeys(input);
    }

    public String submitCreatingNewCustomer() {
        waitElementIsVisible(driver.findElement(addCustomerButtonNewCustomer));
        driver.findElement(addCustomerButtonNewCustomer).click();
        String s = applyAlert();
        String createdUserId = s.split(":")[1];
        return createdUserId;
    }

    public String applyAlert() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public BankManagerLoginPage deleteCustomer(String firstName, String lastName, String postCode) {
        String xpathTemplate = String.format("//tbody/tr[td[text()='%s'] and td[text()='%s'] and td[text()='%s']]/td[5]/button[@ng-click='deleteCust(cust)']", firstName, lastName, postCode);
        By deleteButtonForCustomer = By.xpath(xpathTemplate);
        waitElementIsVisible(driver.findElement(deleteButtonForCustomer));
        driver.findElement(deleteButtonForCustomer).click();
        return this;
    }

}
