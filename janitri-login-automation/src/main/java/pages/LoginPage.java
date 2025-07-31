package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By userIdInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.tagName("button");
    private By passwordToggle = By.cssSelector("svg");
    private By errorMsg = By.cssSelector(".Toastify__toast-body");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserId(String userId) {
        driver.findElement(userIdInput).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    public boolean isPasswordMasked() {
        return driver.findElement(passwordInput).getAttribute("type").equals("password");
    }

    public void togglePasswordVisibility() {
        driver.findElement(passwordToggle).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }

    public boolean areElementsPresent() {
        return driver.findElement(userIdInput).isDisplayed()
            && driver.findElement(passwordInput).isDisplayed()
            && driver.findElement(passwordToggle).isDisplayed();
    }
}