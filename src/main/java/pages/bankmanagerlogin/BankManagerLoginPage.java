package pages.bankmanagerlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankManagerLoginPage {

    public BankManagerLoginPage (WebDriver driver) {
        super(driver);
    }

    private final By bankMangerLoginButton = By.xpath("//button[text()='Bank Manager Login']");
    private final By addCustomerButton = By.xpath("//button[@ng-click='addCust()']");
    private final By lineFirstName = By.xpath("//input[@placeholder='First Name']");
    private final By lineLastName = By.xpath("//input[@placeholder='Last Name']");
    private final By linePostCode = By.xpath("//input[@placeholder='Post Code']");
    private final By addCustomerButtonNewCustomer = By.xpath("//button[@value='' and text()='Add Customer']");


}
