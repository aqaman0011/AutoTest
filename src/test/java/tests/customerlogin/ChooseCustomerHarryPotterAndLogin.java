package tests.customerlogin;

import org.testng.annotations.Test;
import tests.base.BaseTest;
@Test
public class ChooseCustomerHarryPotterAndLogin extends BaseTest {
    public void findIsHarryPotterAndLogin (){
        basePage.open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
        customerLoginPage
                .chooseHarryPotterAndClickLogin();

    }
}
