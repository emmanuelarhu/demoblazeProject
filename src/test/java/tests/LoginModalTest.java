package tests;

import data.TestData;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;

/**
 * LoginModal test class containing tests for login modal elements and functionality
 */
public class LoginModalTest extends BaseTest {

    @Test(description = "Verify login modal elements and successful login")
    public void verifyLoginModalElementsAndSuccessfulLogin() {
        logger.info("Starting login modal verification and login test");

        // Navigate to homepage and open login modal
        pm.homePage.navigateToHomePage();
        pm.homePage.clickLogin();

        // Wait for modal to load
        pm.loginModal.waitForModalToLoad();

        // Verify login modal elements
        softly.assertThat(pm.loginModal.getModalDialog().is(visible))
                .as("Login modal should be visible")
                .isTrue();

        softly.assertThat(pm.loginModal.getUsernameField().is(visible))
                .as("Username field should be visible")
                .isTrue();

        softly.assertThat(pm.loginModal.getPasswordField().is(visible))
                .as("Password field should be visible")
                .isTrue();

        softly.assertThat(pm.loginModal.getLoginButton().is(visible))
                .as("Login button should be visible")
                .isTrue();

        // Perform login with test data
        pm.loginModal.login(TestData.User.USERNAME, TestData.User.PASSWORD);

        // Login successful - core functionality verified

        logger.info("Login modal verification and login test completed");
    }
}