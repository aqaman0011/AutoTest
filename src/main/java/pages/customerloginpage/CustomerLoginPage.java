package pages.customerloginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

public class CustomerLoginPage extends BasePage {

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    private final By dropdownButtonYourName = By.xpath("//select[@id='userSelect']");
    private final By yourNameIsHarryPotter = By.xpath("//option[@class='ng-binding ng-scope' and text()='Harry Potter']");
    private final By loginButton = By.xpath("//button[@ng-show and text()='Login']");
    private final By textWelcome = By.xpath("//strong[text()=' Welcome ']");
    private final By textWelcomeHarryPotter = By.xpath("//span[text()='Harry Potter']");

    public CustomerLoginPage checkCountUsers () {
        waitElementIsVisible(driver.findElement(dropdownButtonYourName));
        int countUsers = driver.findElements(dropdownButtonYourName).size();
        Assert.assertEquals(countUsers, 1);
        return this;
    }

    public CustomerLoginPage clickDropdownButtonYourName () {
        waitElementIsVisible(driver.findElement(dropdownButtonYourName));
        driver.findElement(dropdownButtonYourName).click();
        return this;
    }

    public CustomerLoginPage findNameIsHarryPotter () {
        waitElementIsVisible(driver.findElement(yourNameIsHarryPotter));
        driver.findElement(yourNameIsHarryPotter).click();
        return this;
    }

    public CustomerLoginPage findAndClickLoginButton () {
        waitElementIsVisible(driver.findElement(loginButton));
        driver.findElement(loginButton).click();
        return this;
    }

    public CustomerLoginPage checkTextWelcome () {
        waitElementIsVisible(driver.findElement(textWelcome));
        Assert.assertTrue(driver.findElement(textWelcome).isDisplayed(),"Text 'Welcome' not found!");
        return this;
    }

    public CustomerLoginPage checkTextWelcomeHarryPotter () {
        waitElementIsVisible(driver.findElement(textWelcomeHarryPotter));
        Assert.assertTrue(driver.findElement(textWelcomeHarryPotter).isDisplayed(),"Text 'Welcome Harry Potter' not found!");
        return this;
    }



// Старый код
//    public CustomerLoginPage chooseHarryPotterAndClickLogin (){
//        waitElementIsVisible(driver.findElement(dropdownButtonYourName));
//        driver.findElement(dropdownButtonYourName).click();
//        waitElementIsVisible(driver.findElement(yourNameIsHarryPotter));
//        driver.findElement(yourNameIsHarryPotter).click();
//        waitElementIsVisible(driver.findElement(loginButton));
//        driver.findElement(loginButton).click();
//        waitElementIsVisible(driver.findElement(textWelcome));
//        waitElementIsVisible(driver.findElement(textWelcomeHarryPotter));
//        Assert.assertTrue(driver.findElement(textWelcome).isDisplayed(),"Text 'Welcome' not found!");
//        Assert.assertTrue(driver.findElement(textWelcomeHarryPotter).isDisplayed(),"Text 'Welcome Harry Potter' not found!");
//        return this;
//    }




}