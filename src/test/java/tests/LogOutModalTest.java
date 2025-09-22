package tests;

import data.TestData;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;

/**
 * LogOut test class containing tests for complete login and logout flow
 */
public class LogOutModalTest extends BaseTest {

    @Test(description = "Verify complete login and logout flow")
    public void verifyCompleteLoginAndLogoutFlow() {
        logger.info("Starting complete login and logout flow test");

        // Navigate to homepage and login
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

        // Perform login
        pm.loginModal.login(TestData.User.USERNAME, TestData.User.PASSWORD);

        // Verify successful login
        softly.assertThat(pm.homePage.getWelcomeUserLink().is(visible))
                .as("Welcome user link should be visible after login")
                .isTrue();

        softly.assertThat(pm.homePage.getLogoutLink().is(visible))
                .as("Logout link should be visible after login")
                .isTrue();

        // Perform logout
        pm.homePage.clickWelcomeUser();
        pm.homePage.clickLogout();

        // Verify successful logout
        softly.assertThat(pm.homePage.getLoginLink().is(visible))
                .as("Login link should be visible after logout")
                .isTrue();

        softly.assertThat(pm.homePage.getSignupLink().is(visible))
                .as("Signup link should be visible after logout")
                .isTrue();

        logger.info("Complete login and logout flow test completed");
    }
}