package tests.customerlogin;

import org.testng.annotations.Test;
import pages.homeglobalsqa.HomeGlobalsqaPage;
import tests.base.BaseTest;

@Test
public class FindCustomerLoginPageWithMainPageTest extends BaseTest {
    public void checkIsRedirectToCustomerLoginPage (){
        basePage.open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        homeGlobalsqaPage
                .enterCustomerLoginButton();
        customerLoginPage
                .checkCountUsers();

    }
}
