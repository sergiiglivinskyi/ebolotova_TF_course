package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class SignInPage extends BaseMain {
    public SignInPage(WebDriver dr) {
        super(dr);
    }

    String correctEmail = "bolotova.katya@gmail.com";
    String correctPassword = "password";
    String incorrectEmail = "ebolotov";
    String emptyPassword = "";

    By emailInputField = By.xpath("//input[@id='email']");
    By passwordInputField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[@type='submit']");
    By checkBoxRememberMe = By.xpath("//input[@id='auth-page-remember-me']");
    By errorMessage = By.xpath("//p[contains(text(), 'Error') and @class  = '']");


    public void fillInLoginForm(String name, String password){
        driver.findElement(emailInputField).sendKeys(name);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void fillTheSignFormWithIncorrectEmail() {
        driver.findElement(emailInputField).sendKeys(incorrectEmail);
        driver.findElement(passwordInputField).sendKeys(correctPassword);
        driver.findElement(loginButton).click();
    }

    public void fillTheSignFormWithCorrectData() {
        driver.findElement(emailInputField).sendKeys(correctEmail);
        driver.findElement(passwordInputField).sendKeys(correctPassword);
        driver.findElement(loginButton).click();
    }

    public void fillTheSignFormWithEmptyPassword() {
        driver.findElement(emailInputField).sendKeys(correctEmail);
        driver.findElement(passwordInputField).sendKeys(emptyPassword);
        driver.findElement(loginButton).click();
    }

    public String elementGetText(By element) {
        return pageElement(element).getText();
    }
}
