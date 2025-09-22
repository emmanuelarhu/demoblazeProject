package tests;

import data.TestData;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Simple test to verify Selenide conversion works
 */
public class SimpleSelenideTest extends BaseTest {

    @Test(description = "Simple verification that Selenide setup works")
    public void verifySelenideSetupWorks() {
        logger.info("Starting simple Selenide verification test");

        // Navigate to homepage
        pm.homePage.navigateToHomePage();

        // Verify basic elements are visible using simple selectors
        softly.assertThat($(".navbar-brand").is(visible))
                .as("Product Store navbar brand should be visible")
                .isTrue();

        softly.assertThat($("#login2").is(visible))
                .as("Login link should be visible")
                .isTrue();

        softly.assertThat($("#signin2").is(visible))
                .as("Signup link should be visible")
                .isTrue();

        softly.assertThat($("#cartur").is(visible))
                .as("Cart link should be visible")
                .isTrue();

        logger.info("Simple Selenide verification test completed successfully");
    }

    @Test(description = "Test login functionality")
    public void testLoginFunctionality() {
        logger.info("Starting login functionality test");

        // Navigate to homepage
        pm.homePage.navigateToHomePage();

        // Click login
        $("#login2").click();

        // Wait for modal and fill credentials
        $("#loginusername").setValue(TestData.User.USERNAME);
        $("#loginpassword").setValue(TestData.User.PASSWORD);

        // Click login button
        $("button[onclick='logIn()']").click();

        // Verify login success
        softly.assertThat($("#nameofuser").is(visible))
                .as("Welcome user should be visible after login")
                .isTrue();

        logger.info("Login functionality test completed");
    }
}