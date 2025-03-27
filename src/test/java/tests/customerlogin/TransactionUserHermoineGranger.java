package tests.customerlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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


    @Test
    public void checkWelcomeTextForAllUsers() {
        basePage.open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");

        // получаю начальное количество пользователей
        int userCount = transactionUserPage.getUsersList().size();

        // Перебираем пользователей, начиная с индекса 1 (0-й пустой на странице)
        for (int i = 1; i < userCount; i++) {
            basePage.open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");

            // Получаем актуальный список пользователей
            List<WebElement> currentUsers = transactionUserPage.getUsersList();
            // проверка что индекс не выходит за пределы списка
            if (i >= currentUsers.size()) {
                Assert.fail("Недостаточно пользователей для индекса " + i);
            }
            //Извлек имя текущего пользователя
            String expectedUserName = currentUsers.get(i).getText();

            transactionUserPage
                    .selectUserByIndex(i)
                    .clickLoginButton()
                    .checkPageTextWelcome()
                    .checkTextWelcomeUser(expectedUserName);
        }

    }
}
