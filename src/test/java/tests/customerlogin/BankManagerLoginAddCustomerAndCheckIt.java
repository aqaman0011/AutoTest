package tests.customerlogin;

import org.testng.annotations.Test;
import tests.base.BaseTest;

@Test
public class BankManagerLoginAddCustomerAndCheckIt extends BaseTest {


    public void addNewCustomerBankManagerLoginPageAndCheck () {
        basePage.open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        bankManagerLoginPage
                .addNewCustomerBankManagerLoginPageAndCheck();
    }
}
