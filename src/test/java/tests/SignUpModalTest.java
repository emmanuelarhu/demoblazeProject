package tests;

import data.TestData;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;

/**
 * SignUpModal test class containing tests for signup modal elements and functionality
 */
public class SignUpModalTest extends BaseTest {

    @Test(description = "Verify signup modal elements and signup functionality")
    public void verifySignupModalElementsAndSignupFunctionality() {
        logger.info("Starting signup modal verification and signup test");

        // Navigate to homepage and open signup modal
        pm.homePage.navigateToHomePage();
        pm.homePage.clickSignup();

        // Verify signup modal elements
        softly.assertThat(pm.signUpModal.getModalTitle().is(visible))
                .as("Signup modal title should be visible")
                .isTrue();

        softly.assertThat(pm.signUpModal.getUsernameLabel().is(visible))
                .as("Username label should be visible")
                .isTrue();

        softly.assertThat(pm.signUpModal.getPasswordLabel().is(visible))
                .as("Password label should be visible")
                .isTrue();

        softly.assertThat(pm.signUpModal.getCloseButton().is(visible))
                .as("Close button should be visible")
                .isTrue();

        softly.assertThat(pm.signUpModal.getSignUpButton().is(visible))
                .as("Sign up button should be visible")
                .isTrue();

        // Perform signup with test data
        pm.signUpModal.signUp(TestData.User.USERNAME, TestData.User.PASSWORD);

        logger.info("Signup modal verification and signup test completed");
    }
}