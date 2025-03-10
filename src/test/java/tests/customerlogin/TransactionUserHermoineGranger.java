package tests.customerlogin;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.Arrays;
import java.util.List;

public class TransactionUserHermoineGranger extends BaseTest {

    @Test
    public void checkExactTransactionForUserHermoineGranger  () {
        basePage.open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");

        String dateStart = "2015-01-01T00:00";
        String dateAnd = "2015-01-01T23:59";

        transactionUserPage
                .clickDropdownButtonYourName()
                .findAndClickNameIsHermoineGranger()
                .clickLoginButton()
                .checkPageTextWelcome()
                .checkTextWelcomeHermoineGranger()
                .clickTransactionListButton()
                .dateInputInCalendar(dateStart,dateAnd)
        ;

        // Проверяем таблицу на наличии наших данных
        List<String> expectedDates = Arrays.asList("Jan 1, 2015 12:00:00 AM", "Jan 1, 2015 12:00:00 AM");
        List<String> expectedAmounts = Arrays.asList("30", "4");
        List<String> expectedTypes = Arrays.asList("Credit", "Debit");

        transactionUserPage.checkTransactionDateTimes(expectedDates);
        transactionUserPage.checkTransactionAmounts(expectedAmounts);
        transactionUserPage.checkTransactionTypes(expectedTypes);

    }
}
