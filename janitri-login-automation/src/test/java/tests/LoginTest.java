package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginButtonDisabledWhenFieldsAreEmpty() {
        test = extent.createTest("Verify login button is disabled when fields are empty");
        LoginPage login = new LoginPage(driver);
        Assert.assertFalse(login.isLoginButtonEnabled(), "Login button should be disabled when fields are empty");
    }

    @Test
    public void testPasswordMaskedButton() {
        test = extent.createTest("Verify password masking/unmasking toggle");
        LoginPage login = new LoginPage(driver);
        login.enterPassword("dummyPass123");
        Assert.assertTrue(login.isPasswordMasked(), "Password should be masked by default");
        login.togglePasswordVisibility();
        Assert.assertFalse(login.isPasswordMasked(), "Password should be unmasked after toggle");
    }

    @Test
    public void testInvalidLoginShowsErrorMsg() {
        test = extent.createTest("Verify error message on invalid login");
        LoginPage login = new LoginPage(driver);
        login.enterUserId("random@example.com");
        login.enterPassword("invalidPassword");
        login.clickLogin();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String errorMsg = login.getErrorMessage();
        System.out.println("Error Message: " + errorMsg);
        Assert.assertTrue(errorMsg.length() > 0, "Error message should be displayed on invalid login");
    }

    @Test
    public void testPageElementsPresence() {
        test = extent.createTest("Verify presence of login page elements");
        LoginPage login = new LoginPage(driver);
        Assert.assertTrue(login.areElementsPresent(), "All essential login elements should be present");
    }
}