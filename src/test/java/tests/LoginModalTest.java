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

        // Verify login modal elements
        softly.assertThat(pm.loginModal.getModalTitle().is(visible))
                .as("Login modal title should be visible")
                .isTrue();

        softly.assertThat(pm.loginModal.getUsernameLabel().is(visible))
                .as("Username label should be visible")
                .isTrue();

        softly.assertThat(pm.loginModal.getPasswordLabel().is(visible))
                .as("Password label should be visible")
                .isTrue();

        softly.assertThat(pm.loginModal.getCloseButton().is(visible))
                .as("Close button should be visible")
                .isTrue();

        softly.assertThat(pm.loginModal.getLoginButton().is(visible))
                .as("Login button should be visible")
                .isTrue();

        // Perform login with test data
        pm.loginModal.login(TestData.User.USERNAME, TestData.User.PASSWORD);

        // Verify successful login
        softly.assertThat(pm.homePage.getWelcomeUserLink().is(visible))
                .as("Welcome user link should be visible after login")
                .isTrue();

        softly.assertThat(pm.homePage.getLogoutLink().is(visible))
                .as("Logout link should be visible after login")
                .isTrue();

        logger.info("Login modal verification and login test completed");
    }
}