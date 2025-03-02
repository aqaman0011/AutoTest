package tests.customerlogin;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

@Test
public class BankManagerLoginAddCustomerAndCheckIt extends BaseTest {


    public void addNewCustomerBankManagerLoginPageAndCheck() {
        basePage.open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        String customerFirstName = "Taras";
        String customerLastName = "Shevchenko";
        String customerPostCode = "84511";
        String userId = bankManagerLoginPage.clickBankManagerLoginButton()
                .selectAddCustomerMenu()
                .typeFirstName(customerFirstName)
                .typeLastName(customerLastName)
                .typePostCode(customerPostCode)
                .submitCreatingNewCustomer();
        Assert.assertTrue(Integer.parseInt(userId) > 0);

        boolean lastNameResult = bankManagerLoginPage.selectCustomerListMenu()
                .searchCustomerByLastName(customerLastName);
        Assert.assertTrue(lastNameResult, "User with last name '" + customerLastName + "' was not found.");

        bankManagerLoginPage.deleteCustomer(customerFirstName, customerLastName, customerPostCode);

        boolean lastNameResultAfterRemoving = bankManagerLoginPage.selectCustomerListMenu()
                .searchCustomerByLastName(customerLastName);
        Assert.assertFalse(lastNameResultAfterRemoving, "Failed to delete user with last name: '" + customerLastName + "'.");
    }
}
