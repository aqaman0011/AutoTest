package pages.transactionuserpage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionUserPage extends BasePage {

    private final By dropdownButtonYourName = By.xpath("//select[@id='userSelect']");
    private final By yourNameIsHermoineGranger = By.xpath("//option[@class='ng-binding ng-scope' and text()='Hermoine Granger']");
    private final By loginButton = By.xpath("//button[@ng-show and text()='Login']");
    private final By textWelcome = By.xpath("//strong[text()=' Welcome ']");
    private final By textWelcomeHermoineGranger = By.xpath("//span[text()='Hermoine Granger']");
    private final By transactionListButton =  By.xpath("//button[@ng-class='btnClass1']");
    private final By calendarStartWindow = By.xpath("//input[@id='start']");
    private final By calendarEndWindow = By.xpath("//input[@id='end']");


    public TransactionUserPage(WebDriver driver) {
        super(driver);
    }

    public TransactionUserPage clickDropdownButtonYourName () {
        waitElementIsVisible(driver.findElement(dropdownButtonYourName));
        driver.findElement(dropdownButtonYourName).click();
        return this;
    }

    public TransactionUserPage findAndClickNameIsHermoineGranger () {
        waitElementIsVisible(driver.findElement(yourNameIsHermoineGranger));
        driver.findElement(yourNameIsHermoineGranger).click();
        return this;
    }

    public TransactionUserPage clickLoginButton () {
        waitElementIsVisible(driver.findElement(loginButton));
        driver.findElement(loginButton).click();
        return this;
    }

    public TransactionUserPage checkPageTextWelcome () {
        waitElementIsVisible(driver.findElement(textWelcome));
        Assert.assertTrue(driver.findElement(textWelcome).isDisplayed(),"Text 'Welcome' not found!");
        return this;
    }

    public TransactionUserPage checkTextWelcomeHermoineGranger() {
        waitElementIsVisible(driver.findElement(textWelcomeHermoineGranger));
        Assert.assertTrue(driver.findElement(textWelcomeHermoineGranger).isDisplayed(),"Text 'Welcome Hermoine Granger' not found!");
        return this;
    }

    public TransactionUserPage clickTransactionListButton () {
        waitElementIsVisible(driver.findElement(transactionListButton));
        driver.findElement(transactionListButton).click();
        return this;
    }

    public TransactionUserPage clickСalendarStartWindow () {
        waitElementIsVisible(driver.findElement(calendarStartWindow));
        driver.findElement(calendarStartWindow).click();
        return this;
    }

    public TransactionUserPage clickСalendarEndWindow () {
        waitElementIsVisible(driver.findElement(calendarEndWindow));
        driver.findElement(calendarEndWindow).click();
        return this;
    }


    // Метод для выбора даты через JavaScript ввод стартовой даты
    public static void setDateInStartCalendar(WebDriver driver, String dateTime) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('start').value = arguments[0];", dateTime);
        //js.executeScript("document.getElementById('start').dispatchEvent(new Event('change'));");
        js.executeScript("document.getElementById('start').dispatchEvent(new Event('input'));");
        js.executeScript("document.getElementById('start').dispatchEvent(new Event('blur'));");
        String actualDate = (String) js.executeScript("return document.getElementById('start').value;");
        assert actualDate != null;
        if (!actualDate.equals(dateTime)) {
            throw new AssertionError("Date not found! Need: " + dateTime + ", but we have: " + actualDate);
        }
    }

    // Метод для выбора даты через JavaScript ввод финишной даты
    public static void setDateInEndCalendar (WebDriver driver, String dateTime) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('end').value = arguments[0];", dateTime);
      //js.executeScript("document.getElementById('end').dispatchEvent(new Event('change'));");
        js.executeScript("document.getElementById('end').dispatchEvent(new Event('input'));");
        js.executeScript("document.getElementById('end').dispatchEvent(new Event('blur'));");
        String actualDate = (String) js.executeScript("return document.getElementById('end').value;");
        assert actualDate != null;
        if (!actualDate.equals(dateTime)) {
            throw new AssertionError("Date not found! Need: " + dateTime + ", but we have: " + actualDate);
        }
    }

    public TransactionUserPage dateInputInCalendar(String startDateTime, String endDateTime) {
        pauseBetweenSteps();
        setDateInStartCalendar(driver, startDateTime);
        setDateInEndCalendar(driver, endDateTime);
        pauseBetweenSteps();
        return this;
    }

    @Override
    protected void pauseBetweenSteps() {
        super.pauseBetweenSteps();
    }

    //Метод с помощью которого получаю список знаений из таблицы
    public List<List<String>> getTransactionTableData() {
        List<List<String>> tableData = new ArrayList<>();

        //нахожу все строки в таблице
        List<WebElement> rowsTable = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : rowsTable) {
            List<String> rowData = new ArrayList<>();

            //Поиск всех ячеек таблицы
            List<WebElement> cells = row.findElements(By.tagName("td"));

            for (WebElement cell : cells) {
                rowData.add(cell.getText().trim()); // Добавяем текст ячейки в наш список
            }

            tableData.add(rowData); // Добавляем строку в итоговый список
        }

        return tableData;
    }

    //проверка колонки даты из таблицы
    public void checkTransactionDateTimes(List<String> expectedDates) {
        List<WebElement> dateTimeCells = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));

        List<String> actualDates = dateTimeCells.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());

        Assert.assertEquals(actualDates, expectedDates, "Date-Time column values do not match!");
    }

    //проверка колонки суммы из таблицы
    public void checkTransactionAmounts(List<String> expectedAmounts) {
        List<WebElement> amountCells = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));

        List<String> actualAmounts = amountCells.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());

        Assert.assertEquals(actualAmounts, expectedAmounts, "Amount column values do not match!");
    }

    //проверка колонки типа транзакции из таблицы
    public void checkTransactionTypes(List<String> expectedTypes) {
        List<WebElement> typeCells = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));

        List<String> actualTypes = typeCells.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());

        Assert.assertEquals(actualTypes, expectedTypes, "Transaction Type column values do not match!");
    }
}
